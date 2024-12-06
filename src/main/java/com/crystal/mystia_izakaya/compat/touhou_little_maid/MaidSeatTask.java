package com.crystal.mystia_izakaya.compat.touhou_little_maid;

import com.crystal.mystia_izakaya.client.block.MystiasSeatBlock;
import com.crystal.mystia_izakaya.client.blockEntity.MystiaSeatTE;
import com.crystal.mystia_izakaya.registry.MemoryTypeRegister;
import com.crystal.mystia_izakaya.registry.PoiRegistry;
import com.github.tartaricacid.touhoulittlemaid.entity.ai.brain.task.MaidCheckRateTask;
import com.github.tartaricacid.touhoulittlemaid.entity.item.EntitySit;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.github.tartaricacid.touhoulittlemaid.init.InitEntities;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.behavior.BlockPosTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.Random;

import static com.crystal.mystia_izakaya.client.block.MystiasSeatBlock.MystiasSeat;

public class MaidSeatTask extends MaidCheckRateTask {
    float speed;
    int closeEnoughDist;

    public MaidSeatTask(float movementSpeed, int closeEnoughDist) {
        super(ImmutableMap.of(MemoryModuleType.WALK_TARGET, MemoryStatus.VALUE_ABSENT,
                InitEntities.TARGET_POS.get(), MemoryStatus.VALUE_ABSENT));
        this.closeEnoughDist = closeEnoughDist;
        this.speed = movementSpeed;
        this.setMaxCheckRate(10);
    }

    @Override
    protected boolean checkExtraStartConditions(ServerLevel worldIn, EntityMaid maid) {
        if (super.checkExtraStartConditions(worldIn, maid) && maid.canBrainMoving()) {
            BlockPos seatPos = findSeat(worldIn, maid);
            if (seatPos != null && maid.isWithinRestriction(seatPos)) {
                if (seatPos.distToCenterSqr(maid.position()) < Math.pow(this.closeEnoughDist, 2)) {
                    maid.getBrain().setMemory(InitEntities.TARGET_POS.get(), new BlockPosTracker(seatPos));
                    return true;
                }
                BehaviorUtils.setWalkAndLookTargetMemories(maid, seatPos, speed, 1);
                this.setNextCheckTickCount(5);
            } else {
                maid.getBrain().eraseMemory(InitEntities.TARGET_POS.get());
            }
        }
        return false;
    }

    @Override
    protected void start(@NotNull ServerLevel level, EntityMaid maid, long gameTimeIn) {
        maid.getBrain().getMemory(InitEntities.TARGET_POS.get()).ifPresent((targetPos) -> {
            BlockPos pos = targetPos.currentBlockPosition();
            BlockState blockState = level.getBlockState(pos);
            if (blockState.getBlock() instanceof MystiasSeatBlock) {
                this.startMaidSit(maid, blockState, level, pos);
                maid.getBrain().setMemory(MemoryTypeRegister.TARGET_POS.get(), targetPos);
            }
        });
        maid.getBrain().eraseMemory(InitEntities.TARGET_POS.get());
        maid.getBrain().eraseMemory(MemoryModuleType.WALK_TARGET);
        maid.getBrain().eraseMemory(MemoryModuleType.LOOK_TARGET);
    }

    public void startMaidSit(EntityMaid maid, BlockState state, Level worldIn, BlockPos pos) {
        if (worldIn instanceof ServerLevel serverLevel) {
            BlockEntity blockEntity = serverLevel.getBlockEntity(pos);
            if (blockEntity instanceof MystiaSeatTE mystiaSeatTE) {
                BlockPos position = mystiaSeatTE.getBlockPos();
                Random random = new Random();
                Direction direction = Direction.values()[random.nextInt(4) + 2];
                Vec3i normal = direction.getNormal();
                EntitySit newSitEntity = new EntitySit(worldIn, new Vec3(pos.getX() + 0.5,pos.getY(), pos.getZ() + 0.5).add(Vec3.atLowerCornerOf(normal)), MystiasSeat, position);
                newSitEntity.setYRot(direction.getOpposite().toYRot());
                worldIn.addFreshEntity(newSitEntity);
                mystiaSeatTE.setChanged();
                maid.startRiding(newSitEntity);
            }
        }
    }

    @Nullable
    private BlockPos findSeat(ServerLevel world, EntityMaid maid) {
        BlockPos blockPos = maid.getBrainSearchPos();
        PoiManager poiManager = world.getPoiManager();
        int range = (int) maid.getRestrictRadius();
        return poiManager.getInRange(type -> type.value().equals(PoiRegistry.MYSTIAS_SEAT.get()), blockPos, range, PoiManager.Occupancy.ANY)
                .map(PoiRecord::getPos).filter(pos -> !isOccupied(world, pos))
                .min(Comparator.comparingDouble(pos -> pos.distSqr(maid.blockPosition()))).orElse(null);
    }

    private boolean isOccupied(ServerLevel worldIn, BlockPos pos) {
        BlockEntity te = worldIn.getBlockEntity(pos);
        if (te instanceof MystiaSeatTE seatTE) {
            return worldIn.getEntity(seatTE.getSitId()) != null;
        }
        return true;
    }
}

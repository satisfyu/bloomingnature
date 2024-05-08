package satisfy.wildernature.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;

// Owl by Lemonszz: https://github.com/Lemonszz/Biome-Makeover/blob/1.20/LICENCE
public class FlyingFollowOwnerGoal extends BetterFollowOwnerGoal {

    public FlyingFollowOwnerGoal(TamableAnimal tameable, double speed, float minDistance, float maxDistance, boolean leavesAllowed) {
        super(tameable, speed, minDistance, maxDistance, leavesAllowed);
    }

    @Override
    protected void startFollowing() {
        this.navigation.moveTo(this.owner, owner.isFallFlying() ? 1.2F : speed);
    }

    @Override
    protected boolean canTeleportTo(BlockPos pos) {
        BlockPathTypes pathNodeType = WalkNodeEvaluator.getBlockPathTypeStatic(this.level, pos.mutable());
        if (pathNodeType != BlockPathTypes.WALKABLE && pathNodeType != BlockPathTypes.OPEN) {
            return false;
        } else {
            BlockState blockState = this.level.getBlockState(pos.below());
            if (!this.leavesAllowed && blockState.getBlock() instanceof LeavesBlock) {
                return false;
            } else {
                BlockPos blockPos = pos.subtract(this.tameable.getOnPos());
                return this.level.noCollision(this.tameable, this.tameable.getBoundingBox().move(blockPos));
            }
        }
    }
}
package net.satisfy.bloomingnature.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;


public class SinkInBlock extends Block {
    private static final float HORIZONTAL_PARTICLE_MOMENTUM_FACTOR = 0.083333336F;
    private static final float IN_BLOCK_HORIZONTAL_SPEED_MULTIPLIER = 0.9F;
    private static final float IN_BLOCK_VERTICAL_SPEED_MULTIPLIER = 1.5F;
    private static final float NUM_BLOCKS_TO_FALL_INTO_BLOCK = 2.5F;
    private static final VoxelShape FALLING_COLLISION_SHAPE = Shapes.box(0.0, 0.0, 0.0, 1.0, 0.8999999761581421, 1.0);
    private static final double MINIMUM_FALL_DISTANCE_FOR_SOUND = 4.0;
    private static final double MINIMUM_FALL_DISTANCE_FOR_BIG_SOUND = 7.0;

    public SinkInBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public boolean skipRendering(BlockState blockState, BlockState blockState2, Direction direction) {
        return blockState2.is(this) ? true : super.skipRendering(blockState, blockState2, direction);
    }

    public VoxelShape getOcclusionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return Shapes.empty();
    }

    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        if (!(entity instanceof LivingEntity) || entity.getFeetBlockState().is(this)) {
            entity.makeStuckInBlock(blockState, new Vec3(0.8999999761581421, 1.5, 0.8999999761581421));
            if (level.isClientSide) {
                RandomSource randomSource = level.getRandom();
                boolean bl = entity.xOld != entity.getX() || entity.zOld != entity.getZ();
                if (bl && randomSource.nextBoolean()) {
                    level.addParticle(ParticleTypes.SQUID_INK, entity.getX(), (double) (blockPos.getY() + 1), entity.getZ(), (double) (Mth.randomBetween(randomSource, -1.0F, 1.0F) * 0.083333336F), 0.05000000074505806, (double) (Mth.randomBetween(randomSource, -1.0F, 1.0F) * 0.083333336F));
                }
            }
        }
        if (entity instanceof LivingEntity) {
            entity.hurt(level.damageSources().inWall(), 1.f);
        }

        if (!level.isClientSide) {
            if (entity.isOnFire() && (level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) || entity instanceof Player) && entity.mayInteract(level, blockPos)) {
                level.destroyBlock(blockPos, false);
            }

            entity.setSharedFlagOnFire(false);
        }
    }

    public void fallOn(Level level, BlockState blockState, BlockPos blockPos, Entity entity, float f) {
        if (!((double) f < 4.0) && entity instanceof LivingEntity livingEntity) {
            LivingEntity.Fallsounds fallsounds = livingEntity.getFallSounds();
            SoundEvent soundEvent = (double) f < 7.0 ? fallsounds.small() : fallsounds.big();
            entity.playSound(soundEvent, 1.0F, 1.0F);
        }
    }

    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (collisionContext instanceof EntityCollisionContext entityCollisionContext) {
            Entity entity = entityCollisionContext.getEntity();
            if (entity != null) {
                if (entity.fallDistance > 2.5F) {
                    return FALLING_COLLISION_SHAPE;
                }

                boolean bl = entity instanceof FallingBlockEntity;
            }
        }

        return Shapes.empty();
    }

    public VoxelShape getVisualShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return Shapes.empty();
    }


    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, PathComputationType pathComputationType) {
        return true;
    }
}


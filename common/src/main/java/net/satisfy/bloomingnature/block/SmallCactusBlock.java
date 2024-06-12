package net.satisfy.bloomingnature.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.satisfy.bloomingnature.registry.ObjectRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class SmallCactusBlock extends CactusBlock {
    private static final VoxelShape SHAPE = Shapes.box(0.1875, 0, 0.1875, 0.8125, 1, 0.8125);

    public SmallCactusBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @SuppressWarnings("deprecation")
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        Iterator<Direction> var4 = Direction.Plane.HORIZONTAL.iterator();

        Direction direction;
        BlockState blockState2;
        do {
            if (!var4.hasNext()) {
                BlockState blockState3 = levelReader.getBlockState(blockPos.below());
                return (blockState3.is(ObjectRegistry.SMALL_CACTUS.get()) || blockState3.is(BlockTags.SAND)) && !levelReader.getBlockState(blockPos.above()).liquid();
            }

            direction = var4.next();
            blockState2 = levelReader.getBlockState(blockPos.relative(direction));
        } while(!blockState2.isSolid() && !levelReader.getFluidState(blockPos.relative(direction)).is(FluidTags.LAVA));

        return false;
    }
}

package satisfy.bloomingnature.block.storage;

import de.cristelknight.doapi.common.block.storage.FlowerPotBigBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class BNFlowerPotBigBlock extends FlowerPotBigBlock {
    private static final VoxelShape SHAPE;

    private static final Supplier<VoxelShape> voxelShapeSupplier = () -> {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.joinUnoptimized(shape, Shapes.box(0.25, 0, 0.25, 0.75, 0.5, 0.75), BooleanOp.OR);
        shape = Shapes.joinUnoptimized(shape, Shapes.box(0.25, 0.5, 0.25, 0.75, 0.5625, 0.3125), BooleanOp.OR);
        shape = Shapes.joinUnoptimized(shape, Shapes.box(0.25, 0.5, 0.6875, 0.75, 0.5625, 0.75), BooleanOp.OR);
        shape = Shapes.joinUnoptimized(shape, Shapes.box(0.6875, 0.5, 0.3125, 0.75, 0.5625, 0.6875), BooleanOp.OR);
        shape = Shapes.joinUnoptimized(shape, Shapes.box(0.25, 0.5, 0.3125, 0.3125, 0.5625, 0.6875), BooleanOp.OR);
        return shape;
    };

    static {
        SHAPE = voxelShapeSupplier.get();
    }

    public BNFlowerPotBigBlock(Properties settings) {
        super(settings);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
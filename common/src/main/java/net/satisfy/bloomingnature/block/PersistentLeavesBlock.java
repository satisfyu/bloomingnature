package net.satisfy.bloomingnature.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

public class PersistentLeavesBlock extends LeavesBlock {
    public static final int CUSTOM_DECAY_DISTANCE = 11;
    public static final IntegerProperty CUSTOM_DISTANCE = IntegerProperty.create("distance", 1, CUSTOM_DECAY_DISTANCE);

    public PersistentLeavesBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(CUSTOM_DISTANCE, CUSTOM_DECAY_DISTANCE)
                .setValue(PERSISTENT, false)
                .setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CUSTOM_DISTANCE, PERSISTENT, WATERLOGGED);
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighbor, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        int distance = getDistanceAt(neighbor) + 1;
        if (distance > CUSTOM_DECAY_DISTANCE) {
            distance = CUSTOM_DECAY_DISTANCE;
        }
        return state.setValue(CUSTOM_DISTANCE, distance);
    }

    private static int getDistanceAt(BlockState state) {
        if (state.is(BlockTags.LOGS)) {
            return 0;
        } else if (state.hasProperty(CUSTOM_DISTANCE)) {
            return state.getValue(CUSTOM_DISTANCE);
        }
        return CUSTOM_DECAY_DISTANCE;
    }
}
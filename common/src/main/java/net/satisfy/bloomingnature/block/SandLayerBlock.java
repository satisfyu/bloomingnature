package net.satisfy.bloomingnature.block;

import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelReader;
import net.minecraft.core.BlockPos;

public class SandLayerBlock extends SnowLayerBlock {
    public SandLayerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return true;
    }
}

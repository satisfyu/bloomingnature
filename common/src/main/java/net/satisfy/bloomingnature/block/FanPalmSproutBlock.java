package net.satisfy.bloomingnature.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.satisfy.bloomingnature.world.ConfiguredFeatures;
import org.jetbrains.annotations.NotNull;

public class FanPalmSproutBlock extends SaplingBlock {
    public FanPalmSproutBlock() {
        super(new AbstractTreeGrower() {
            @Override
            protected @NotNull ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean bl) {
                return ConfiguredFeatures.FAN_PALM_TREE_KEY;
            }
        }, Properties.copy(Blocks.ACACIA_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(Blocks.SAND);
    }
}


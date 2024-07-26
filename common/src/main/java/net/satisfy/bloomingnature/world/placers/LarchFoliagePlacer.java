package net.satisfy.bloomingnature.world.placers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.satisfy.bloomingnature.registry.ObjectRegistry;
import net.satisfy.bloomingnature.registry.PlacerTypesRegistry;
import org.jetbrains.annotations.NotNull;

public class LarchFoliagePlacer extends FoliagePlacer {
    public static final Codec<LarchFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            foliagePlacerParts(instance)
                    .and(IntProvider.codec(0, 24).fieldOf("trunk_height").forGetter(placer -> placer.trunkHeight))
                    .apply(instance, LarchFoliagePlacer::new));
    private final IntProvider trunkHeight;

    public LarchFoliagePlacer(IntProvider intProvider, IntProvider intProvider2, IntProvider trunkHeight) {
        super(intProvider, intProvider2);
        this.trunkHeight = trunkHeight;
    }

    @Override
    protected @NotNull FoliagePlacerType<?> type() {
        return PlacerTypesRegistry.LARCH_FOLIAGE_PLACER.get();
    }

    public int foliageHeight(RandomSource random, int trunkHeight, TreeConfiguration config) {
        return Math.max(12, trunkHeight - this.trunkHeight.sample(random));
    }

    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, int trunkHeight, FoliageAttachment treeNode, int foliageHeight, int radius, int offset) {
        BlockPos blockPos = treeNode.pos();
        BlockPos.MutableBlockPos mutable = blockPos.mutable();

        for (int l = 0; l < trunkHeight; ++l) {
            BlockPos trunkPos = blockPos.above(l);
            foliageSetter.set(trunkPos, ObjectRegistry.LARCH_LOG.get().defaultBlockState());
        }

        for (int l = offset; l >= -foliageHeight - 4; --l) {
            if (l >= offset - 2) {
                mutable.setWithOffset(blockPos, 0, l, 0);
                tryPlaceLeaf(levelSimulatedReader, foliageSetter, random, config, mutable);
            } else if (l >= offset - foliageHeight - 4) {
                mutable.setWithOffset(blockPos, 0, l, 0);
                if (random.nextBoolean()) {
                    tryPlaceLeaf(levelSimulatedReader, foliageSetter, random, config, mutable.relative(Direction.NORTH, 1).relative(Direction.EAST, 1));
                }
                if (random.nextBoolean()) {
                    tryPlaceLeaf(levelSimulatedReader, foliageSetter, random, config, mutable.relative(Direction.NORTH, 1).relative(Direction.WEST, 1));
                }
                if (random.nextBoolean()) {
                    tryPlaceLeaf(levelSimulatedReader, foliageSetter, random, config, mutable.relative(Direction.SOUTH, 1).relative(Direction.EAST, 1));
                }
                if (random.nextBoolean()) {
                    tryPlaceLeaf(levelSimulatedReader, foliageSetter, random, config, mutable.relative(Direction.SOUTH, 1).relative(Direction.WEST, 1));
                }
                placeLeavesRow(levelSimulatedReader, foliageSetter, random, config, blockPos, Math.max(1, radius - 1), l, treeNode.doubleTrunk());
            }
        }
    }

    protected boolean shouldSkipLocation(RandomSource random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return dx == radius && dz == radius && radius > 0;
    }

    protected void placeLeavesRow(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, BlockPos centerPos, int radius, int y, boolean giantTrunk) {
        int i = giantTrunk ? 1 : 0;
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        for (int j = -radius; j <= radius + i; ++j) {
            for (int k = -radius; k <= radius + i; ++k) {
                if (!shouldSkipLocationSigned(random, j, y, k, radius, giantTrunk)) {
                    mutable.setWithOffset(centerPos, j, y, k);
                    tryPlaceLeaf(levelSimulatedReader, foliageSetter, random, config, mutable);
                }
            }
        }
    }
}

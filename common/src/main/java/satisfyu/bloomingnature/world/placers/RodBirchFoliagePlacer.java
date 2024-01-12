package satisfyu.bloomingnature.world.placers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import satisfyu.bloomingnature.registry.PlacerTypesRegistry;

public class RodBirchFoliagePlacer extends FoliagePlacer {

    public RodBirchFoliagePlacer(IntProvider int_one, IntProvider int_two) {
        super(int_one, int_two);
    }

    public static final Codec<RodBirchFoliagePlacer> CODEC = RecordCodecBuilder.create((placer) -> foliagePlacerParts(placer).apply(placer, RodBirchFoliagePlacer::new));

    @Override
    protected FoliagePlacerType<?> type() {
        return PlacerTypesRegistry.ROD_BIRCH_FOLIAGE_PLACER.get();
    }


    @Override
    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource randomSource, TreeConfiguration treeConfiguration, int i, FoliageAttachment foliageAttachment, int j, int k, int l) {
		this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, foliageAttachment.pos(), 0, 3, foliageAttachment.doubleTrunk());
		this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, foliageAttachment.pos(), 0, 2, foliageAttachment.doubleTrunk());
        this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, foliageAttachment.pos(), 1, 1, foliageAttachment.doubleTrunk());
        this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, foliageAttachment.pos(), 1, 0, foliageAttachment.doubleTrunk());
        this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, foliageAttachment.pos(), 1, -1, foliageAttachment.doubleTrunk());
        this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, foliageAttachment.pos(), 1, -2, foliageAttachment.doubleTrunk());
        this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, foliageAttachment.pos(), 1, -3, foliageAttachment.doubleTrunk());
        this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, foliageAttachment.pos(), 1, -4, foliageAttachment.doubleTrunk());
    }

    @Override
    public int foliageHeight(RandomSource p_225601_, int p_225602_, TreeConfiguration p_225603_) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int xOffset, int yOffset, int zOffset,
                                         int radius, boolean isDoubleTrunk) {
        return
                (xOffset == radius && zOffset == radius && yOffset == 3) ||
                        (xOffset == radius && zOffset == radius && yOffset == 1) ||
                        (xOffset == radius && zOffset == radius && yOffset == 0) ||
                        (xOffset == radius && zOffset == radius && yOffset == -4);
    }
}
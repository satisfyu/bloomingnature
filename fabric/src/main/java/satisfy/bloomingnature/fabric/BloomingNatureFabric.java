package satisfy.bloomingnature.fabric;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import satisfy.bloomingnature.BloomingNature;
import satisfy.bloomingnature.fabric.config.ConfigFabric;
import satisfy.bloomingnature.registry.CompostableRegistry;
import satisfy.bloomingnature.util.BloomingNatureIdentifier;
import satisfy.bloomingnature.world.PlacedFeatures;

import java.util.function.Predicate;

public class BloomingNatureFabric implements ModInitializer {
    private static Predicate<BiomeSelectionContext> getBloomingNatureSelector(String path) {
        return BiomeSelectors.tag(TagKey.create(Registries.BIOME, new BloomingNatureIdentifier(path)));
    }

    @Override
    public void onInitialize() {
        AutoConfig.register(ConfigFabric.class, GsonConfigSerializer::new);
        BloomingNature.init();
        BloomingNature.commonInit();
        CompostableRegistry.init();
        addBiomeModification();
    }

    void addBiomeModification() {
        ConfigFabric config = AutoConfig.getConfigHolder(ConfigFabric.class).getConfig();
        BiomeModification world = BiomeModifications.create(new BloomingNatureIdentifier("world_features"));
        Predicate<BiomeSelectionContext> overworld = getBloomingNatureSelector("overworld");
        Predicate<BiomeSelectionContext> plains = getBloomingNatureSelector("plains");
        Predicate<BiomeSelectionContext> river = getBloomingNatureSelector("river");
        Predicate<BiomeSelectionContext> aspen = getBloomingNatureSelector("aspen");
        Predicate<BiomeSelectionContext> birch = getBloomingNatureSelector("birch");
        Predicate<BiomeSelectionContext> forest = getBloomingNatureSelector("forest");
        Predicate<BiomeSelectionContext> flower_forest = getBloomingNatureSelector("flower_forest");
        Predicate<BiomeSelectionContext> cherry_grove = getBloomingNatureSelector("cherry_grove");
        Predicate<BiomeSelectionContext> snowy_plains = getBloomingNatureSelector("snowy_plains");
        Predicate<BiomeSelectionContext> snowy_taiga = getBloomingNatureSelector("snowy_taiga");
        Predicate<BiomeSelectionContext> beach = getBloomingNatureSelector("beach");
        Predicate<BiomeSelectionContext> stony_shore = getBloomingNatureSelector("stony_shore");
        Predicate<BiomeSelectionContext> jungle = getBloomingNatureSelector("jungle");
        Predicate<BiomeSelectionContext> sparse_jungle = getBloomingNatureSelector("sparse_jungle");
        Predicate<BiomeSelectionContext> desert = getBloomingNatureSelector("desert");
        Predicate<BiomeSelectionContext> swamp = getBloomingNatureSelector("swamp");
        Predicate<BiomeSelectionContext> dark_forest = getBloomingNatureSelector("dark_forest");
        Predicate<BiomeSelectionContext> mangrove_swamp = getBloomingNatureSelector("mangrove_swamp");
        Predicate<BiomeSelectionContext> sunflower_plains = getBloomingNatureSelector("sunflower_plains");
        Predicate<BiomeSelectionContext> taiga = getBloomingNatureSelector("taiga");
        Predicate<BiomeSelectionContext> old_growth_spruce_taiga = getBloomingNatureSelector("old_growth_spruce_taiga");
        Predicate<BiomeSelectionContext> old_growth_pine_taiga = getBloomingNatureSelector("old_growth_pine_taiga");
        Predicate<BiomeSelectionContext> savanna = getBloomingNatureSelector("savanna");
        Predicate<BiomeSelectionContext> savanna_plateau = getBloomingNatureSelector("savanna_plateau");


        if (config.removeLavaLakes) {
            world.add(ModificationPhase.REMOVALS, overworld, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.LAVA_LAKE_SURFACE));
        } else {
            world.add(ModificationPhase.ADDITIONS, overworld, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.LAVA_LAKE_SURFACE));
        }
        if (config.removeLavaLakesUnderground) {
            world.add(ModificationPhase.REMOVALS, overworld, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.LAVA_LAKE_UNDERGROUND));
        } else {
            world.add(ModificationPhase.ADDITIONS, overworld, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.LAVA_LAKE_UNDERGROUND));
        }
        if (config.removeMarshBlocks) {
            world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_MARSH));
            world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_MARSH));

        } else {
            world.add(ModificationPhase.REMOVALS, mangrove_swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_MARSH));
            world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_MARSH));
        }
        if (config.removeQuicksandBlocks) {
            world.add(ModificationPhase.ADDITIONS, desert, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.QUICKSAND));

        } else {
            world.add(ModificationPhase.REMOVALS, desert, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.QUICKSAND));
        }
        world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getEffects().setGrassColor(config.setPlainsGrassColor));
        world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getEffects().setFoliageColor(config.setPlainsFoliageColor));
        if (config.removeVanillaPlainsFlowers) {
            world.add(ModificationPhase.REMOVALS, plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_FLOWERS));
        }
        if (config.removeVanillaPlainsTrees) {
            world.add(ModificationPhase.REMOVALS, plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_TREES));
        }
        if (config.addBloomingNaturePlainsTrees) {
            world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_TREES));
        } else {
            world.add(ModificationPhase.REMOVALS, plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_TREES));
        }
        if (config.addBloomingNaturePlainsFlowers) {
            world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_FLOWERS));
        } else {
            world.add(ModificationPhase.REMOVALS, plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_FLOWERS));
        }
        if (config.addBloomingNaturePlainsGrass) {
            world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_GRASS));
        } else {
            world.add(ModificationPhase.REMOVALS, plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_GRASS));
        }
        if (config.addBloomingNaturePlainsStoneBoulders) {
            world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_STONE_BOULDER));
        } else {
            world.add(ModificationPhase.REMOVALS, plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_STONE_BOULDER));
        }
        if (config.addBloomingNaturePlainsStoneMounds) {
            world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_MOUND));
        } else {
            world.add(ModificationPhase.REMOVALS, plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_MOUND));
        }
        if (config.addBloomingNaturePlainsGravelBeaches) {
            world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_GRAVEL_BEACH));
        } else {
            world.add(ModificationPhase.REMOVALS, plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_GRAVEL_BEACH));
        }
        if (config.addBloomingNaturePlainsStoneSlabs) {
            world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_STONE_SLABS));
        } else {
            world.add(ModificationPhase.REMOVALS, plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_STONE_SLABS));
        }
        if (config.addBloomingNaturePlainsBurriedTravertin) {
            world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_TRAVERTIN));
        } else {
            world.add(ModificationPhase.REMOVALS, plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_TRAVERTIN));
        }
        if (config.addBloomingNatureSunflowerPlainsTrees) {
            world.add(ModificationPhase.ADDITIONS, sunflower_plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SUNFLOWER_PLAINS_BN_TREES));
        } else {
            world.add(ModificationPhase.REMOVALS, sunflower_plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SUNFLOWER_PLAINS_BN_TREES));
        }
        if (config.addBloomingNatureSunflowerPlainsFlowers) {
            world.add(ModificationPhase.ADDITIONS, sunflower_plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SUNFLOWER_PLAINS_BN_FLOWERS));
        } else {
            world.add(ModificationPhase.REMOVALS, sunflower_plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SUNFLOWER_PLAINS_BN_FLOWERS));
        }
        world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getEffects().setGrassColor(config.setRiverGrassColor));
        world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getEffects().setFoliageColor(config.setRiverFoliageColor));
        if (config.removeVanillaRiverFlowers) {
            world.add(ModificationPhase.REMOVALS, river, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_FLOWERS));
        }
        if (config.removeVanillaRiverTrees) {
            world.add(ModificationPhase.REMOVALS, river, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_TREES));
        }
        if (config.addBloomingNatureRiverTrees) {
            world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_BN_TREES));
        } else {
            world.add(ModificationPhase.REMOVALS, river, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_BN_TREES));
        }
        if (config.addBloomingNatureRiverGrass) {
            world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_BN_GRASS));
        } else {
            world.add(ModificationPhase.REMOVALS, river, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_BN_GRASS));
        }
        if (config.addBloomingNatureRiverStoneBoulders) {
            world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_BN_STONE_BOULDER));
        } else {
            world.add(ModificationPhase.REMOVALS, river, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_BN_STONE_BOULDER));
        }
        if (config.addBloomingNatureRiverStoneMounds) {
            world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_BN_MOUND));
        } else {
            world.add(ModificationPhase.REMOVALS, river, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_BN_MOUND));
        }
        if (config.addBloomingNatureRiverGravelBeaches) {
            world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_BN_GRAVEL_BEACH));
        } else {
            world.add(ModificationPhase.REMOVALS, river, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_BN_GRAVEL_BEACH));
        }
        if (config.addBloomingNatureRiverStoneSlabs) {
            world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_BN_STONE_SLABS));
        } else {
            world.add(ModificationPhase.REMOVALS, river, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_BN_STONE_SLABS));
        }
        if (config.addBloomingNatureRiverBurriedTravertin) {
            world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_BN_TRAVERTIN));
        } else {
            world.add(ModificationPhase.REMOVALS, river, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_BN_TRAVERTIN));
        }
        world.add(ModificationPhase.ADDITIONS, aspen, ctx -> ctx.getEffects().setGrassColor(config.setOldGrowthBirchForestGrassColor));
        world.add(ModificationPhase.ADDITIONS, aspen, ctx -> ctx.getEffects().setFoliageColor(config.setOldGrowthBirchForestFoliageColor));
        if (config.removeVanillaOldGrowthBirchForestFlowers) {
            world.add(ModificationPhase.REMOVALS, aspen, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_DEFAULT));
        }
        if (config.removeVanillaOldGrowthBirchForestFlowers) {
            world.add(ModificationPhase.REMOVALS, aspen, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_FLOWERS));
        }
        if (config.removeVanillaOldGrowthBirchForestTrees) {
            world.add(ModificationPhase.REMOVALS, aspen, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_TREES));
        }
        if (config.addBloomingNatureOldGrowthBirchForestTrees) {
            world.add(ModificationPhase.ADDITIONS, aspen, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_BN_TREES));
        } else {
            world.add(ModificationPhase.REMOVALS, aspen, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_BN_TREES));
        }
        if (config.addBloomingNatureOldGrowthBirchForestFallenTrees) {
            world.add(ModificationPhase.ADDITIONS, aspen, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_BN_FALLEN));
        } else {
            world.add(ModificationPhase.REMOVALS, aspen, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_BN_FALLEN));
        }
        if (config.addBloomingNatureOldGrowthBirchForestFlowers) {
            world.add(ModificationPhase.ADDITIONS, aspen, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_BN_FLOWERS));
        } else {
            world.add(ModificationPhase.REMOVALS, aspen, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_BN_FLOWERS));
        }
        if (config.addBloomingNatureOldGrowthBirchForestGrass) {
            world.add(ModificationPhase.ADDITIONS, aspen, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_BN_GRASS));
        } else {
            world.add(ModificationPhase.REMOVALS, aspen, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_BN_GRASS));
        }
        if (config.addBloomingNatureOldGrowthBirchStoneSlabs) {
            world.add(ModificationPhase.ADDITIONS, aspen, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_BN_STONE_SLABS));
        } else {
            world.add(ModificationPhase.REMOVALS, aspen, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_BN_STONE_SLABS));
        }
        world.add(ModificationPhase.ADDITIONS, birch, ctx -> ctx.getEffects().setGrassColor(config.setBirchForestGrassColor));
        world.add(ModificationPhase.ADDITIONS, birch, ctx -> ctx.getEffects().setFoliageColor(config.setBirchForestFoliageColor));
        if (config.removeVanillaBirchForestFlowers) {
            world.add(ModificationPhase.REMOVALS, birch, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_DEFAULT));
        }
        if (config.removeVanillaBirchForestFlowers) {
            world.add(ModificationPhase.REMOVALS, birch, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_FLOWERS));
        }
        if (config.removeVanillaBirchForestTrees) {
            world.add(ModificationPhase.REMOVALS, birch, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_TREES));
        }
        if (config.addBloomingNatureBirchForestTrees) {
            world.add(ModificationPhase.ADDITIONS, birch, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_BN_TREES));
        } else {
            world.add(ModificationPhase.REMOVALS, birch, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_BN_TREES));
        }
        if (config.addBloomingNatureBirchForestFallenTrees) {
            world.add(ModificationPhase.ADDITIONS, birch, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_BN_FALLEN));
        } else {
            world.add(ModificationPhase.REMOVALS, birch, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_BN_FALLEN));
        }
        if (config.addBloomingNatureBirchForestFlowers) {
            world.add(ModificationPhase.ADDITIONS, birch, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_BN_FLOWERS));
        } else {
            world.add(ModificationPhase.REMOVALS, birch, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_BN_FLOWERS));
        }
        if (config.addBloomingNatureBirchForestGrass) {
            world.add(ModificationPhase.ADDITIONS, birch, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_BN_GRASS));
        } else {
            world.add(ModificationPhase.REMOVALS, birch, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_BN_GRASS));
        }
        if (config.addBloomingNatureBirchStoneSlabs) {
            world.add(ModificationPhase.ADDITIONS, birch, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_BN_STONE_SLABS));
        } else {
            world.add(ModificationPhase.REMOVALS, birch, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_BN_STONE_SLABS));
        }
        world.add(ModificationPhase.ADDITIONS, forest, ctx -> ctx.getEffects().setGrassColor(config.setForestGrassColor));
        world.add(ModificationPhase.ADDITIONS, forest, ctx -> ctx.getEffects().setFoliageColor(config.setForestFoliageColor));
        if (config.removeVanillaForestFlowers) {
            world.add(ModificationPhase.REMOVALS, forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_FLOWERS));
        }
        if (config.removeVanillaForestTrees) {
            world.add(ModificationPhase.REMOVALS, forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_TREES));
        }
        if (config.addBloomingNatureForestTrees) {
            world.add(ModificationPhase.ADDITIONS, forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_BN_TREES));
        } else {
            world.add(ModificationPhase.REMOVALS, forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_BN_TREES));
        }
        if (config.addBloomingNatureForestFallenTrees) {
            world.add(ModificationPhase.ADDITIONS, forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_BN_FALLEN));
        } else {
            world.add(ModificationPhase.REMOVALS, forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_BN_FALLEN));
        }
        if (config.addBloomingNatureForestFlowers) {
            world.add(ModificationPhase.ADDITIONS, forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_BN_FLOWERS));
        } else {
            world.add(ModificationPhase.REMOVALS, forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_BN_FLOWERS));
        }
        if (config.addBloomingNatureForestGrass) {
            world.add(ModificationPhase.ADDITIONS, forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_BN_GRASS));
        } else {
            world.add(ModificationPhase.REMOVALS, forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_BN_GRASS));
        }
        if (config.addBloomingNatureForestStoneBoulder) {
            world.add(ModificationPhase.ADDITIONS, forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_BN_STONE_BOULDER));
        } else {
            world.add(ModificationPhase.REMOVALS, forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_BN_STONE_BOULDER));
        }
        if (config.addBloomingNatureForestStoneSlabs) {
            world.add(ModificationPhase.ADDITIONS, forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_BN_STONE_SLABS));
        } else {
            world.add(ModificationPhase.REMOVALS, forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_BN_STONE_SLABS));
        }
        world.add(ModificationPhase.ADDITIONS, flower_forest, ctx -> ctx.getEffects().setGrassColor(config.setFlowerforestGrassColor));
        world.add(ModificationPhase.ADDITIONS, flower_forest, ctx -> ctx.getEffects().setFoliageColor(config.setFlowerforestFoliageColor));
        if (config.removeVanillaFlowerforestFlowers) {
            world.add(ModificationPhase.REMOVALS, flower_forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_FLOWER));
            world.add(ModificationPhase.REMOVALS, flower_forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_FLOWER_FLOWER));
        }
        if (config.removeVanillaFlowerforestTrees) {
            world.add(ModificationPhase.REMOVALS, flower_forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_TREES));
        }
        if (config.addBloomingNatureFlowerforestTrees) {
            world.add(ModificationPhase.ADDITIONS, flower_forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_BN_TREES));
        } else {
            world.add(ModificationPhase.REMOVALS, flower_forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_BN_TREES));
        }
        if (config.addBloomingNatureFlowerforestFallenTrees) {
            world.add(ModificationPhase.ADDITIONS, flower_forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_BN_FALLEN));
        } else {
            world.add(ModificationPhase.REMOVALS, flower_forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_BN_FALLEN));
        }
        if (config.addBloomingNatureFlowerforestFlowers) {
            world.add(ModificationPhase.ADDITIONS, flower_forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_BN_FLOWERS));
        } else {
            world.add(ModificationPhase.REMOVALS, flower_forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_BN_FLOWERS));
        }
        if (config.addBloomingNatureFlowerforestGrass) {
            world.add(ModificationPhase.ADDITIONS, flower_forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_BN_GRASS));
        } else {
            world.add(ModificationPhase.REMOVALS, flower_forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_BN_GRASS));
        }
        if (config.addBloomingNatureFlowerforestStoneSlabs) {
            world.add(ModificationPhase.ADDITIONS, flower_forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_BN_STONE_SLABS));
        } else {
            world.add(ModificationPhase.REMOVALS, flower_forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_BN_STONE_SLABS));
        }
        if (config.removeVanillaCherryGroveFlowers) {
            world.add(ModificationPhase.REMOVALS, cherry_grove, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.CHERRY_FLOWERS));
        }
        if (config.removeVanillaCherryGroveTrees) {
            world.add(ModificationPhase.REMOVALS, cherry_grove, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.CHERRY_TREES));
        }
        if (config.addBloomingNatureCherryGroveTrees) {
            world.add(ModificationPhase.ADDITIONS, cherry_grove, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.CHERRY_BN_TREES));
        } else {
            world.add(ModificationPhase.REMOVALS, cherry_grove, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.CHERRY_BN_TREES));
        }
        if (config.addBloomingNatureCherryGroveFlowers) {
            world.add(ModificationPhase.ADDITIONS, cherry_grove, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.CHERRY_BN_FLOWERS));
        } else {
            world.add(ModificationPhase.REMOVALS, cherry_grove, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.CHERRY_BN_FLOWERS));
        }
        if (config.removeVanillaSnowyPlainsFlowers) {
            world.add(ModificationPhase.REMOVALS, snowy_plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_PLAINS_FLOWERS));
        }
        if (config.removeVanillaSnowyPlainsTrees) {
            world.add(ModificationPhase.REMOVALS, snowy_plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_PLAINS_TREES));
        }
        if (config.addBloomingNatureSnowyPlainsTrees) {
            world.add(ModificationPhase.ADDITIONS, snowy_plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_PLAINS_BN_TREES));
        } else {
            world.add(ModificationPhase.REMOVALS, snowy_plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_PLAINS_BN_TREES));
        }
        if (config.addBloomingNatureSnowyPlainsAdditionalTrees) {
            world.add(ModificationPhase.ADDITIONS, snowy_plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_PLAINS_BN_ADDITIONAL_TREES));
        } else {
            world.add(ModificationPhase.REMOVALS, snowy_plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_PLAINS_BN_ADDITIONAL_TREES));
        }
        if (config.addBloomingNatureSnowyPlainsStoneBoulders) {
            world.add(ModificationPhase.ADDITIONS, snowy_plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_SLOPES_STONE_BOULDER));
        } else {
            world.add(ModificationPhase.REMOVALS, snowy_plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_SLOPES_STONE_BOULDER));
        }
        if (config.addBloomingNatureSnowyPlainsStoneMound) {
            world.add(ModificationPhase.ADDITIONS, snowy_plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_SLOPES_STONE_MOUND));
        } else {
            world.add(ModificationPhase.REMOVALS, snowy_plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_SLOPES_STONE_MOUND));
        }
        if (config.addBloomingNatureSnowyPlainsGravelBeach) {
            world.add(ModificationPhase.ADDITIONS, snowy_plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_SLOPES_GRAVEL_BEACH));
        } else {
            world.add(ModificationPhase.REMOVALS, snowy_plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_SLOPES_GRAVEL_BEACH));
        }
        if (config.addBloomingNatureSnowyPlainsStoneSlabs) {
            world.add(ModificationPhase.ADDITIONS, snowy_plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_SLOPES_STONE_SLABS));
        } else {
            world.add(ModificationPhase.REMOVALS, snowy_plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_SLOPES_STONE_SLABS));
        }
        if (config.removeVanillaSnowyTaigaTrees) {
            world.add(ModificationPhase.REMOVALS, snowy_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_TAIGA_TREES));
        }
        if (config.addBloomingSnowyTaigaTrees) {
            world.add(ModificationPhase.ADDITIONS, snowy_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_TAIGA_BN_TREES));
        } else {
            world.add(ModificationPhase.REMOVALS, snowy_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_TAIGA_BN_TREES));
        }
        if (config.addBloomingNatureSnowyTaigaStoneBoulders) {
            world.add(ModificationPhase.ADDITIONS, snowy_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_TAIGA_BN_STONE_BOULDER));
        } else {
            world.add(ModificationPhase.REMOVALS, snowy_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_TAIGA_BN_STONE_BOULDER));
        }
        if (config.addBloomingNatureSnowyTaigaStoneMounds) {
            world.add(ModificationPhase.ADDITIONS, snowy_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_TAIGA_BN_STONE_MOUND));
        } else {
            world.add(ModificationPhase.REMOVALS, snowy_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_TAIGA_BN_STONE_MOUND));
        }
        if (config.addBloomingNatureSnowyTaigaGravelBeaches) {
            world.add(ModificationPhase.ADDITIONS, snowy_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_TAIGA_BN_GRAVEL_BEACH));
        } else {
            world.add(ModificationPhase.REMOVALS, snowy_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_TAIGA_BN_GRAVEL_BEACH));
        }
        if (config.addBloomingNatureSnowyTaigaStoneSlabs) {
            world.add(ModificationPhase.ADDITIONS, snowy_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_TAIGA_BN_STONE_SLABS));
        } else {
            world.add(ModificationPhase.REMOVALS, snowy_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_TAIGA_BN_STONE_SLABS));
        }
        if (config.removeVanillaSwampTrees) {
            world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_TREES));
        }
        if (config.removeVanillaSwampFlowers) {
            world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_FLOWERS));
        }
        if (config.removeVanillaSwampGrass) {
            world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_GRASS));
        }
        if (config.addBloomingNatureSwampWaterBasins) {
            world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_WATER_BASIN));
        } else {
            world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_WATER_BASIN));
        }
        if (config.addBloomingNatureSwampMarshBasins) {
            world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_MARSH_BASIN));
        } else {
            world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_MARSH_BASIN));
        }
        if (config.addBloomingNatureSwampFloatingLeaves) {
            world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_FLOATING_LEAVES));
        } else {
            world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_FLOATING_LEAVES));
        }
        if (config.addBloomingNatureSwampMud) {
            world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_MUD));
        } else {
            world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_MUD));
        }
        if (config.addBloomingNatureSwampadditionalMud) {
            world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_SWAMP_MUD));
        } else {
            world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_SWAMP_MUD));
        }
        if (config.addBloomingNatureSwampTrees) {
            world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_BN_TREES));
        } else {
            world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_BN_TREES));
        }
        if (config.addBloomingNatureSwampVegetation) {
            world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_VEGETATION));
        } else {
            world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_VEGETATION));
        }
        if (config.addBloomingNatureSwampCattails) {
            world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_CATTAILS));
        } else {
            world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_CATTAILS));
        }
        if (config.addBloomingNatureSwampReed) {
            world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_REED));
        } else {
            world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_REED));
        }
        if (config.addBloomingNatureSwampGrass) {
            world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_BN_GRASS));
        } else {
            world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_BN_GRASS));
        }
        if (config.addBloomingNatureSwampFlowers) {
            world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_BN_FLOWERS));
        } else {
            world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_BN_FLOWERS));
        }
        if (config.addBloomingNatureMangroveSwampWaterBasins) {
            world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MANGROVE_SWAMP_WATER_BASIN));
        } else {
            world.add(ModificationPhase.REMOVALS, mangrove_swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MANGROVE_SWAMP_WATER_BASIN));
        }
        if (config.addBloomingNatureMangroveSwampMarshBasins) {
            world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MANGROVE_SWAMP_MARSH_BASIN));
        } else {
            world.add(ModificationPhase.REMOVALS, mangrove_swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MANGROVE_SWAMP_MARSH_BASIN));
        }
        if (config.addBloomingNatureMangroveSwampFloatingLeaves) {
            world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MANGROVE_SWAMP_FLOATING_LEAVES));
        } else {
            world.add(ModificationPhase.REMOVALS, mangrove_swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MANGROVE_SWAMP_FLOATING_LEAVES));
        }
        if (config.addBloomingNatureMangroveSwampMud) {
            world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MANGROVE_SWAMP_MUD));
        } else {
            world.add(ModificationPhase.REMOVALS, mangrove_swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MANGROVE_SWAMP_MUD));
        }
        if (config.addBloomingNatureMangroveSwampadditionalMud) {
            world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MANGROVE_SWAMP_SWAMP_MUD));
        } else {
            world.add(ModificationPhase.REMOVALS, mangrove_swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MANGROVE_SWAMP_SWAMP_MUD));
        }
        if (config.addBloomingNatureMangroveSwampVegetation) {
            world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MANGROVE_SWAMP_VEGETATION));
        } else {
            world.add(ModificationPhase.REMOVALS, mangrove_swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MANGROVE_SWAMP_VEGETATION));
        }
        if (config.addBloomingNatureMangroveSwampCattails) {
            world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MANGROVE_SWAMP_CATTAILS));
        } else {
            world.add(ModificationPhase.REMOVALS, mangrove_swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MANGROVE_SWAMP_CATTAILS));
        }
        if (config.addBloomingNatureMangroveSwampReed) {
            world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MANGROVE_SWAMP_REED));
        } else {
            world.add(ModificationPhase.REMOVALS, mangrove_swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MANGROVE_SWAMP_REED));
        }



             world.add(ModificationPhase.ADDITIONS, stony_shore, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_PILLARS));
        world.add(ModificationPhase.ADDITIONS, stony_shore, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_CLIFFS));
        world.add(ModificationPhase.ADDITIONS, stony_shore, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.COBBLESTONE_BEACH));
        world.add(ModificationPhase.ADDITIONS, stony_shore, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.COBBLESTONE_BEACH_MOSSY));



        world.add(ModificationPhase.REMOVALS, taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_LARGE_FERN));
        world.add(ModificationPhase.REMOVALS, taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_TREES));
        world.add(ModificationPhase.REMOVALS, taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_FLOWERS));
        world.add(ModificationPhase.REMOVALS, taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_GRASS));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_SPRUCE_TREES));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_SPRUCE_FALLEN));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_GRASS_PATCH));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_BN_FLOWERS));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_BOULDER));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_MOUND));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GRAVEL_BEACH));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_SLABS));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TRAVERTIN));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_FOREST_MOSS));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getEffects().setGrassColor(11977352));




        world.add(ModificationPhase.REMOVALS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_SPRUCE_TAIGA_LARGE_FERN));
        world.add(ModificationPhase.REMOVALS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_SPRUCE_TAIGA_TREES));
        world.add(ModificationPhase.REMOVALS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_SPRUCE_TAIGA_FLOWERS));
        world.add(ModificationPhase.REMOVALS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_SPRUCE_TAIGA_GRASS));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_SPRUCE_TAIGA_BN_TREES));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_SPRUCE_FALLEN));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_GRASS_PATCH));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_BN_FLOWERS));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_BOULDER));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_MOUND));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GRAVEL_BEACH));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_SLABS));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TRAVERTIN));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_FOREST_MOSS));




        world.add(ModificationPhase.REMOVALS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_PINE_TAIGA_LARGE_FERN));
        world.add(ModificationPhase.REMOVALS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_PINE_TAIGA_TREES));
        world.add(ModificationPhase.REMOVALS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_PINE_TAIGA_FLOWERS));
        world.add(ModificationPhase.REMOVALS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_PINE_TAIGA_GRASS));
        world.add(ModificationPhase.ADDITIONS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.LARCH_TREES));
        world.add(ModificationPhase.ADDITIONS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.LARCH_FALLEN));
        world.add(ModificationPhase.ADDITIONS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.LARCH_FLOWERS));
        world.add(ModificationPhase.ADDITIONS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.LARCH_GRASS_PATCH));
        world.add(ModificationPhase.ADDITIONS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_SLABS));
        world.add(ModificationPhase.ADDITIONS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_FOREST_MOSS));
        world.add(ModificationPhase.ADDITIONS, old_growth_pine_taiga, ctx -> ctx.getEffects().setGrassColor(9286496));
        world.add(ModificationPhase.ADDITIONS, old_growth_pine_taiga, ctx -> ctx.getEffects().setFoliageColor(10399058));



        world.add(ModificationPhase.REMOVALS, savanna, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TREES_SAVANNA));
        world.add(ModificationPhase.REMOVALS, savanna, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PATCH_GRASS_SAVANNA));
        world.add(ModificationPhase.REMOVALS, savanna, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BROWN_MUSHROOM_NORMAL));
        world.add(ModificationPhase.REMOVALS, savanna, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RED_MUSHROOM_NORMAL));
        world.add(ModificationPhase.REMOVALS, savanna, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_WARM));
        world.add(ModificationPhase.ADDITIONS, savanna, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SAVANNA_TREES));
        world.add(ModificationPhase.ADDITIONS, savanna, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SAVANNA_VEGETATION));
        world.add(ModificationPhase.ADDITIONS, savanna, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SAVANNA_GRASS_PATCH));
        world.add(ModificationPhase.ADDITIONS, savanna, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GRANITE_BOULDERS));
        world.add(ModificationPhase.ADDITIONS, savanna, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GRANITE_SLABS));
        world.add(ModificationPhase.ADDITIONS, savanna, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PACKED_MUD));
        world.add(ModificationPhase.ADDITIONS, savanna, ctx -> ctx.getEffects().setGrassColor(15259000));
        world.add(ModificationPhase.ADDITIONS, savanna, ctx -> ctx.getEffects().setFoliageColor(10399058));



        world.add(ModificationPhase.REMOVALS, savanna_plateau, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TREES_SAVANNA));
        world.add(ModificationPhase.REMOVALS, savanna_plateau, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PATCH_GRASS_SAVANNA));
        world.add(ModificationPhase.REMOVALS, savanna_plateau, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BROWN_MUSHROOM_NORMAL));
        world.add(ModificationPhase.REMOVALS, savanna_plateau, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RED_MUSHROOM_NORMAL));
        world.add(ModificationPhase.REMOVALS, savanna_plateau, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_WARM));
        world.add(ModificationPhase.ADDITIONS, savanna_plateau, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SAVANNA_PLATEAU_TREES));
        world.add(ModificationPhase.ADDITIONS, savanna_plateau, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SAVANNA_VEGETATION));
        world.add(ModificationPhase.ADDITIONS, savanna_plateau, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SAVANNA_GRASS_PATCH));
        world.add(ModificationPhase.ADDITIONS, savanna_plateau, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GRANITE_BOULDERS));
        world.add(ModificationPhase.ADDITIONS, savanna_plateau, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GRANITE_SLABS));
        world.add(ModificationPhase.ADDITIONS, savanna_plateau, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PACKED_MUD));
        world.add(ModificationPhase.ADDITIONS, savanna_plateau, ctx -> ctx.getEffects().setGrassColor(15259000));



        world.add(ModificationPhase.REMOVALS, dark_forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.DARK_FOREST_VEGETATION));
        world.add(ModificationPhase.ADDITIONS, dark_forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.DARK_FOREST_TREES));
        world.add(ModificationPhase.ADDITIONS, dark_forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.DARK_FOREST_GRASS_PATCH));
        world.add(ModificationPhase.ADDITIONS, dark_forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.DARK_FOREST_TREE_FALLEN));
        world.add(ModificationPhase.ADDITIONS, dark_forest, ctx -> ctx.getEffects().setGrassColor(6975545));
        world.add(ModificationPhase.REMOVALS, jungle, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.JUNGLE_FLOWERS));
        world.add(ModificationPhase.REMOVALS, jungle, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.JUNGLE_TREES));
        world.add(ModificationPhase.REMOVALS, jungle, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.JUNGLE_BAMBOO));
        //world.add(ModificationPhase.ADDITIONS, jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOATING_LEAVES));
        world.add(ModificationPhase.ADDITIONS, jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SAVANNA_VEGETATION));
        world.add(ModificationPhase.ADDITIONS, jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.JUNGLE_FLOWERS));
        world.add(ModificationPhase.ADDITIONS, jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.JUNGLE_BN_TREES));
        world.add(ModificationPhase.ADDITIONS, jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SPARSE_JUNGLE_BN_GRASS));
        world.add(ModificationPhase.ADDITIONS, jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SPARSE_JUNGLE_BN_PUDDLE));
        world.add(ModificationPhase.ADDITIONS, jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SPARSE_JUNGLE_BN_MUD));
        world.add(ModificationPhase.ADDITIONS, jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SPARSE_JUNGLE_LATERIT_BOULDER));
        world.add(ModificationPhase.ADDITIONS, jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, PlacedFeatures.SPARSE_JUNGLE_ORE_LATERIT));
        world.add(ModificationPhase.ADDITIONS, jungle, ctx -> ctx.getEffects().setGrassColor(8970560));
        world.add(ModificationPhase.ADDITIONS, jungle, ctx -> ctx.getEffects().setFoliageColor(6337104));



        world.add(ModificationPhase.REMOVALS, sparse_jungle, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SPARSE_JUNGLE_FLOWERS));
        world.add(ModificationPhase.REMOVALS, sparse_jungle, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SPARSE_JUNGLE_TREES));
        //world.add(ModificationPhase.ADDITIONS, sparse_jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOATING_LEAVES));
        world.add(ModificationPhase.ADDITIONS, sparse_jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SAVANNA_VEGETATION));
        world.add(ModificationPhase.ADDITIONS, sparse_jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.JUNGLE_FLOWERS));
        world.add(ModificationPhase.ADDITIONS, sparse_jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SPARSE_JUNGLE_BN_TREES));
        world.add(ModificationPhase.ADDITIONS, sparse_jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SPARSE_JUNGLE_BN_GRASS));
        world.add(ModificationPhase.ADDITIONS, sparse_jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SPARSE_JUNGLE_BN_PUDDLE));
        world.add(ModificationPhase.ADDITIONS, sparse_jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SPARSE_JUNGLE_BN_MUD));
        world.add(ModificationPhase.ADDITIONS, sparse_jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SPARSE_JUNGLE_LATERIT_BOULDER));
        world.add(ModificationPhase.ADDITIONS, sparse_jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, PlacedFeatures.SPARSE_JUNGLE_ORE_LATERIT));
        world.add(ModificationPhase.ADDITIONS, sparse_jungle, ctx -> ctx.getEffects().setGrassColor(8970560));
        world.add(ModificationPhase.ADDITIONS, sparse_jungle, ctx -> ctx.getEffects().setFoliageColor(6337104));



        world.add(ModificationPhase.ADDITIONS, beach, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FAN_PALM_TREE));
        world.add(ModificationPhase.ADDITIONS, beach, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BEACH_FLOWERS));

    }
}

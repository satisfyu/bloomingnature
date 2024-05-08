package satisfy.wildernature.fabric;

import com.google.common.base.Preconditions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.Heightmap;
import satisfy.wildernature.WilderNature;
import satisfy.wildernature.registry.EntityRegistry;
import satisfy.wildernature.registry.TagsRegistry;
import satisfy.wildernature.util.WilderNatureIdentifier;

import java.util.List;
import java.util.function.Predicate;

@SuppressWarnings("unused")
public class WilderNatureFabric implements ModInitializer {
    private static Predicate<BiomeSelectionContext> getWilderNatureSelector(String path) {
        return BiomeSelectors.tag(TagKey.create(Registries.BIOME, new WilderNatureIdentifier(path)));
    }

    @Override
    public void onInitialize() {
        WilderNature.init();
        WilderNature.commonInit();
        addSpawns();
    }

    void addSpawns() {
        addMobSpawn(TagsRegistry.SPAWNS_DEER, EntityRegistry.DEER.get(), 12, 2, 4);
        addMobSpawn(BiomeTags.IS_BEACH, EntityRegistry.PELICAN.get(), 5, 3, 4);
        addMobSpawn(BiomeTags.HAS_WOODLAND_MANSION, EntityType.EVOKER, 4, 1, 2);
        addMobSpawn(BiomeTags.HAS_WOODLAND_MANSION, EntityType.VINDICATOR, 4, 1, 2);
        addMobSpawn(BiomeTags.HAS_WOODLAND_MANSION, EntityType.PILLAGER, 4, 1, 3);
        addMobSpawn(TagsRegistry.SPAWNS_MUDDY_PIG, EntityRegistry.MUDDY_PIG.get(), 8, 4, 5);
        addMobSpawn(TagsRegistry.SPAWNS_MOSSY_SHEEP, EntityRegistry.MOSSY_SHEEP.get(), 8, 3, 5);
        addMobSpawn(TagsRegistry.SPAWNS_RACCOON, EntityRegistry.RACCOON.get(), 8, 2, 3);
        addMobSpawn(TagsRegistry.SPAWNS_SQUIRREL, EntityRegistry.SQUIRREL.get(), 8, 2, 2);
        addMobSpawn(TagsRegistry.SPAWNS_RED_WOLF, EntityRegistry.RED_WOLF.get(), 10, 3, 4);
        addMobSpawn(TagsRegistry.SPAWNS_OWL, EntityRegistry.OWL.get(), 12, 3, 3);
        addMobSpawn(TagsRegistry.SPAWNS_BOAR, EntityRegistry.BOAR.get(), 14, 5, 5);
        addMobSpawn(TagsRegistry.SPAWNS_BISON, EntityRegistry.BISON.get(), 10, 3, 5);
        addMobSpawn(TagsRegistry.SPAWNS_TURKEY, EntityRegistry.TURKEY.get(), 12, 3, 5);
        addMobSpawn(TagsRegistry.SPAWNS_TURKEY, EntityRegistry.TURKEY.get(), 12, 3, 5);
        removeSpawn(BiomeTags.IS_SAVANNA, List.of(EntityType.SHEEP, EntityType.PIG, EntityType.CHICKEN, EntityType.COW));
        removeSpawn(ConventionalBiomeTags.SWAMP, List.of(EntityType.SHEEP, EntityType.PIG, EntityType.CHICKEN, EntityType.COW));
        removeSpawn(BiomeTags.IS_FOREST, List.of(EntityType.PIG, EntityType.CHICKEN));
        removeSpawn(BiomeTags.IS_JUNGLE, List.of(EntityType.PIG, EntityType.CHICKEN, EntityType.COW));
        addMobSpawn(BiomeTags.IS_JUNGLE, EntityType.FROG, 8, 3, 4);

        SpawnPlacements.register(EntityRegistry.SQUIRREL.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.OWL.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.TURKEY.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.RACCOON.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.PELICAN.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.MUDDY_PIG.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.DEER.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.MOSSY_SHEEP.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.RED_WOLF.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.BOAR.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.BISON.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
    }

    void addMobSpawn(TagKey<Biome> tag, EntityType<?> entityType, int weight, int minGroupSize, int maxGroupSize) {
        BiomeModifications.addSpawn(biomeSelector -> biomeSelector.hasTag(tag), MobCategory.CREATURE, entityType, weight, minGroupSize, maxGroupSize);
    }

    void removeSpawn(TagKey<Biome> tag, List<EntityType<?>> entityTypes) {
        entityTypes.forEach(entityType -> {
            ResourceLocation id = BuiltInRegistries.ENTITY_TYPE.getKey(entityType);
            Preconditions.checkState(BuiltInRegistries.ENTITY_TYPE.containsKey(id), "Unregistered entity type: %s", entityType);
            BiomeModifications.create(id).add(ModificationPhase.REMOVALS, biomeSelector -> biomeSelector.hasTag(tag), context -> context.getSpawnSettings().removeSpawnsOfEntityType(entityType));
        });
    }
}

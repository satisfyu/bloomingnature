package satisfy.wildernature.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import satisfy.wildernature.util.WilderNatureIdentifier;

public class TagsRegistry {
    public static final TagKey<Item> SQUIRREL_HOLDABLE = TagKey.create(Registries.ITEM, new WilderNatureIdentifier("squirrel_holdable"));
    public static final TagKey<EntityType<?>> OWL_TARGETS = TagKey.create(Registries.ENTITY_TYPE, new WilderNatureIdentifier("owl_targets"));
    public static final TagKey<Biome> SPAWNS_DEER = TagKey.create(Registries.BIOME, new WilderNatureIdentifier("spawns_deer"));
    public static final TagKey<Biome> SPAWNS_MOSSY_SHEEP = TagKey.create(Registries.BIOME, new WilderNatureIdentifier("spawns_mossy_sheep"));
    public static final TagKey<Biome> SPAWNS_MUDDY_PIG = TagKey.create(Registries.BIOME, new WilderNatureIdentifier("spawns_muddy_pig"));
    public static final TagKey<Biome> SPAWNS_BOAR = TagKey.create(Registries.BIOME, new WilderNatureIdentifier("spawns_boar"));
    public static final TagKey<Biome> SPAWNS_OWL = TagKey.create(Registries.BIOME, new WilderNatureIdentifier("spawns_owl"));
    public static final TagKey<Biome> SPAWNS_BISON = TagKey.create(Registries.BIOME, new WilderNatureIdentifier("spawns_bison"));
    public static final TagKey<Biome> SPAWNS_TURKEY = TagKey.create(Registries.BIOME, new WilderNatureIdentifier("spawns_turkey"));
    public static final TagKey<Biome> SPAWNS_RACCOON = TagKey.create(Registries.BIOME, new WilderNatureIdentifier("spawns_raccoon"));
    public static final TagKey<Biome> SPAWNS_RED_WOLF = TagKey.create(Registries.BIOME, new WilderNatureIdentifier("spawns_red_wolf"));
    public static final TagKey<Biome> SPAWNS_SQUIRREL = TagKey.create(Registries.BIOME, new WilderNatureIdentifier("spawns_squirrel"));
    public static final TagKey<Biome> REMOVE_WOLF = TagKey.create(Registries.BIOME, new WilderNatureIdentifier("remove_wolf"));
}

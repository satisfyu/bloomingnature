package satisfy.wildernature.registry;

import de.cristelknight.doapi.Util;
import dev.architectury.core.item.ArchitecturySpawnEggItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import satisfy.wildernature.WilderNature;
import satisfy.wildernature.item.WilderNatureStandardItem;
import satisfy.wildernature.util.WilderNatureIdentifier;

import java.util.function.Consumer;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ObjectRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(WilderNature.MOD_ID, Registries.ITEM);
    public static final Registrar<Item> ITEM_REGISTRAR = ITEMS.getRegistrar();
    public static final RegistrySupplier<Item> WILDERNATURE_STANDARD = registerItem("wildernature_standard", () -> new WilderNatureStandardItem(new Item.Properties().stacksTo(16).rarity(Rarity.EPIC)));
    public static final RegistrySupplier<Item> DEER_SPAWN_EGG = registerItem("deer_spawn_egg", () -> new ArchitecturySpawnEggItem(EntityRegistry.DEER, -1, -1, getSettings()));
    public static final RegistrySupplier<Item> RED_WOLF_SPAWN_EGG = registerItem("red_wolf_spawn_egg", () -> new ArchitecturySpawnEggItem(EntityRegistry.RED_WOLF, -1, -1, getSettings()));
    public static final RegistrySupplier<Item> RACCOON_SPAWN_EGG = registerItem("raccoon_spawn_egg", () -> new ArchitecturySpawnEggItem(EntityRegistry.RACCOON, -1, -1, getSettings()));
    public static final RegistrySupplier<Item> SQUIRREL_SPAWN_EGG = registerItem("squirrel_spawn_egg", () -> new ArchitecturySpawnEggItem(EntityRegistry.SQUIRREL, -1, -1, getSettings()));
    public static final RegistrySupplier<Item> MOSSY_SHEEP_SPAWN_EGG = registerItem("mossy_sheep_spawn_egg", () -> new ArchitecturySpawnEggItem(EntityRegistry.MOSSY_SHEEP, -1, -1, getSettings()));
    public static final RegistrySupplier<Item> MUDDY_PIG_SPAWN_EGG = registerItem("muddy_pig_spawn_egg", () -> new ArchitecturySpawnEggItem(EntityRegistry.MUDDY_PIG, -1, -1, getSettings()));
    public static final RegistrySupplier<Item> PELICAN_SPAWN_EGG = registerItem("pelican_spawn_egg", () -> new ArchitecturySpawnEggItem(EntityRegistry.PELICAN, -1, -1, getSettings()));
    public static final RegistrySupplier<Item> OWL_SPAWN_EGG = registerItem("owl_spawn_egg", () -> new ArchitecturySpawnEggItem(EntityRegistry.OWL, -1, -1, getSettings()));
    public static final RegistrySupplier<Item> BOAR_SPAWN_EGG = registerItem("boar_spawn_egg", () -> new ArchitecturySpawnEggItem(EntityRegistry.BOAR, -1, -1, getSettings()));
    public static final RegistrySupplier<Item> BISON_SPAWN_EGG = registerItem("bison_spawn_egg", () -> new ArchitecturySpawnEggItem(EntityRegistry.BISON, -1, -1, getSettings()));
    public static final RegistrySupplier<Item> TURKEY_SPAWN_EGG = registerItem("turkey_spawn_egg", () -> new ArchitecturySpawnEggItem(EntityRegistry.TURKEY, -1, -1, getSettings()));
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(WilderNature.MOD_ID, Registries.BLOCK);
    public static final Registrar<Block> BLOCK_REGISTRAR = BLOCKS.getRegistrar();

    public static void init() {
        WilderNature.LOGGER.debug("Registering Mod Block and Items for " + WilderNature.MOD_ID);
        ITEMS.register();
        BLOCKS.register();
    }

    private static Item.Properties getSettings(Consumer<Item.Properties> consumer) {
        Item.Properties settings = new Item.Properties();
        consumer.accept(settings);
        return settings;
    }

    static Item.Properties getSettings() {
        return getSettings(settings -> {
        });
    }

    public static <T extends Block> RegistrySupplier<T> registerWithItem(String name, Supplier<T> block) {
        return Util.registerWithItem(BLOCKS, BLOCK_REGISTRAR, ITEMS, ITEM_REGISTRAR, new WilderNatureIdentifier(name), block);
    }

    public static <T extends Block> RegistrySupplier<T> registerWithoutItem(String path, Supplier<T> block) {
        return Util.registerWithoutItem(BLOCKS, BLOCK_REGISTRAR, new WilderNatureIdentifier(path), block);
    }

    public static <T extends Item> RegistrySupplier<T> registerItem(String path, Supplier<T> itemSupplier) {
        return Util.registerItem(ITEMS, ITEM_REGISTRAR, new WilderNatureIdentifier(path), itemSupplier);
    }
}

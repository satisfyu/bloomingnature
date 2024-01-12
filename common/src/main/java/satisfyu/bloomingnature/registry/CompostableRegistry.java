package satisfyu.bloomingnature.registry;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import satisfyu.bloomingnature.util.VillagerUtil;

public class CompostableRegistry {

    public static void init() {
        registerCompostableItem(ObjectRegistry.CATTAIL, 0.4F);
        registerCompostableItem(ObjectRegistry.REED, 0.3F);
        registerCompostableItem(ObjectRegistry.HYSSOP, 0.3F);
        registerCompostableItem(ObjectRegistry.MOUNTAIN_SNOWBELL, 0.3F);
        registerCompostableItem(ObjectRegistry.CARDINAL, 0.3F);
        registerCompostableItem(ObjectRegistry.MOUNTAIN_LAUREL, 0.3F);
        registerCompostableItem(ObjectRegistry.BIRD_OF_PARADISE, 0.3F);
        registerCompostableItem(ObjectRegistry.WHITE_ORCHID, 0.3F);
        registerCompostableItem(ObjectRegistry.DAPHNE, 0.3F);
        registerCompostableItem(ObjectRegistry.BOTTLEBRUSHES, 0.3F);
        registerCompostableItem(ObjectRegistry.BLUEBELL, 0.3F);
        registerCompostableItem(ObjectRegistry.BEGONIE, 0.3F);
        registerCompostableItem(ObjectRegistry.GOATSBEARD, 0.3F);
        registerCompostableItem(ObjectRegistry.GENISTEAE, 0.3F);
        registerCompostableItem(ObjectRegistry.FOXGLOVE_WHITE, 0.3F);
        registerCompostableItem(ObjectRegistry.FOXGLOVE_PINK, 0.3F);
        registerCompostableItem(ObjectRegistry.FREESIA_YELLOW, 0.3F);
        registerCompostableItem(ObjectRegistry.FREESIA_PINK, 0.3F);
        registerCompostableItem(ObjectRegistry.LUPINE_BLUE, 0.3F);
        registerCompostableItem(ObjectRegistry.LUPINE_PURPLE, 0.3F);
        registerCompostableItem(ObjectRegistry.BEACH_BUSH, 0.3F);
        registerCompostableItem(ObjectRegistry.BEACH_GRASS, 0.3F);
        registerCompostableItem(ObjectRegistry.BEACH_BUSH_TALL, 0.3F);
        registerCompostableItem(ObjectRegistry.ASPEN_SAPLING, 0.3F);
        registerCompostableItem(ObjectRegistry.FIR_SAPLING, 0.3F);
        registerCompostableItem(ObjectRegistry.BAOBAB_SAPLING, 0.3F);
        registerCompostableItem(ObjectRegistry.SWAMP_CYPRESS_SAPLING, 0.3F);
        registerCompostableItem(ObjectRegistry.SWAMP_OAK_SAPLING, 0.3F);
        registerCompostableItem(ObjectRegistry.EBONY_SAPLING, 0.3F);
        registerCompostableItem(ObjectRegistry.LARCH_SAPLING, 0.3F);
        registerCompostableItem(ObjectRegistry.CHESTNUT_SAPLING, 0.3F);

    }



    public static <T extends ItemLike> void registerCompostableItem(RegistrySupplier<T> item, float chance) {
        if (item.get().asItem() != Items.AIR) {
            ComposterBlock.COMPOSTABLES.put(item.get(), chance);
        }
    }
}

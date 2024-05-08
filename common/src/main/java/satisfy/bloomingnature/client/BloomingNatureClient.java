package satisfy.bloomingnature.client;

import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.FoliageColor;
import satisfy.bloomingnature.client.model.TermiteModel;
import satisfy.bloomingnature.client.model.WanderingGardenerModel;
import satisfy.bloomingnature.client.render.entity.TermiteRenderer;
import satisfy.bloomingnature.client.render.entity.WanderingGardenerRenderer;
import satisfy.bloomingnature.registry.EntityRegistry;
import satisfy.bloomingnature.registry.ObjectRegistry;

@Environment(EnvType.CLIENT)
public class BloomingNatureClient {

    public static void initClient() {
        RenderTypeRegistry.register(RenderType.cutout(),
                ObjectRegistry.CARDINAL.get(), ObjectRegistry.MOUNTAIN_LAUREL.get(), ObjectRegistry.JOE_PYE.get(), ObjectRegistry.HYSSOP.get(),
                ObjectRegistry.MOUNTAIN_SNOWBELL.get(), ObjectRegistry.CARDINAL.get(), ObjectRegistry.BIRD_OF_PARADISE.get(), ObjectRegistry.WHITE_ORCHID.get(),
                ObjectRegistry.POTTED_MOUNTAIN_LAUREL.get(), ObjectRegistry.POTTED_JOE_PYE.get(), ObjectRegistry.POTTED_HYSSOP.get(),
                ObjectRegistry.POTTED_MOUNTAIN_SNOWBELL.get(), ObjectRegistry.POTTED_WHITE_ORCHID.get(), ObjectRegistry.POTTED_BIRD_OF_PARADISE.get(),
                ObjectRegistry.BEGONIE.get(), ObjectRegistry.GENISTEAE.get(), ObjectRegistry.GOATSBEARD.get(), ObjectRegistry.BLUEBELL.get(), ObjectRegistry.DAPHNE.get(),
                ObjectRegistry.BOTTLEBRUSHES.get(), ObjectRegistry.FOXGLOVE_WHITE.get(), ObjectRegistry.FOXGLOVE_PINK.get(), ObjectRegistry.FREESIA_YELLOW.get(),
                ObjectRegistry.FREESIA_PINK.get(), ObjectRegistry.LUPINE_BLUE.get(), ObjectRegistry.LUPINE_PURPLE.get(),
                ObjectRegistry.LARCH_DOOR.get(), ObjectRegistry.POTTED_BEGONIE.get(), ObjectRegistry.POTTED_GENISTEAE.get(),
                ObjectRegistry.POTTED_GOATSBEARD.get(), ObjectRegistry.POTTED_BLUEBELL.get(), ObjectRegistry.POTTED_DAPHNE.get(), ObjectRegistry.POTTED_BOTTLEBRUSHES.get(),
                ObjectRegistry.POTTED_FOXGLOVE_WHITE.get(), ObjectRegistry.POTTED_FOXGLOVE_PINK.get(), ObjectRegistry.POTTED_FREESIA_YELLOW.get(),
                ObjectRegistry.POTTED_FREESIA_PINK.get(), ObjectRegistry.POTTED_LUPINE_BLUE.get(), ObjectRegistry.POTTED_LUPINE_PURPLE.get(),
                ObjectRegistry.POTTED_LARCH_SAPLING.get(), ObjectRegistry.LARCH_SAPLING.get(), ObjectRegistry.SWAMP_OAK_TRAPDOOR.get(),
                ObjectRegistry.SWAMP_OAK_WINDOW.get(), ObjectRegistry.SWAMP_OAK_DOOR.get(), ObjectRegistry.SWAMP_OAK_SAPLING.get(), ObjectRegistry.LARCH_WINDOW.get(),
                ObjectRegistry.TALL_MOUNTAIN_LAUREL.get(), ObjectRegistry.TALL_LUPINE_BLUE.get(), ObjectRegistry.TALL_LUPINE_PURPLE.get(), ObjectRegistry.BEACH_BUSH.get(),
                ObjectRegistry.BEACH_BUSH_TALL.get(), ObjectRegistry.BEACH_GRASS.get(), ObjectRegistry.GOLDEN_ROD.get(), ObjectRegistry.WILD_SUNFLOWER.get(),
                ObjectRegistry.FAN_PALM_SPROUT.get(), ObjectRegistry.FAN_PALM_DOOR.get(), ObjectRegistry.FAN_PALM_TRAPDOOR.get(), ObjectRegistry.FAN_PALM_WINDOW.get(),
                ObjectRegistry.CATTAIL.get(), ObjectRegistry.REED.get(), ObjectRegistry.POTTED_LARCH_SAPLING.get(), ObjectRegistry.POTTED_FIR_SAPLING.get(),
                ObjectRegistry.POTTED_SWAMP_CYPRESS_SAPLING.get(), ObjectRegistry.POTTED_SWAMP_OAK_SAPLING.get(), ObjectRegistry.POTTED_FAN_PALM_SPROUT.get(),
                ObjectRegistry.POTTED_ASPEN_SAPLING.get(), ObjectRegistry.POTTED_BAOBAB_SAPLING.get(), ObjectRegistry.POTTED_GOLDEN_ROD.get(),
                ObjectRegistry.POTTED_BEACH_BUSH.get(), ObjectRegistry.BAOBAB_WINDOW.get(), ObjectRegistry.ASPEN_WINDOW.get(), ObjectRegistry.SWAMP_CYPRESS_WINDOW.get(),
                ObjectRegistry.FIR_WINDOW.get(), ObjectRegistry.BAOBAB_DOOR.get(), ObjectRegistry.ASPEN_DOOR.get(), ObjectRegistry.SWAMP_CYPRESS_DOOR.get(),
                ObjectRegistry.ASPEN_TRAPDOOR.get(), ObjectRegistry.SWAMP_CYPRESS_TRAPDOOR.get(), ObjectRegistry.BAOBAB_SAPLING.get(), ObjectRegistry.ASPEN_SAPLING.get(),
                ObjectRegistry.SWAMP_CYPRESS_SAPLING.get(), ObjectRegistry.FIR_SAPLING.get(), ObjectRegistry.CHESTNUT_DOOR.get(), ObjectRegistry.CHESTNUT_SAPLING.get(),
                ObjectRegistry.CHESTNUT_WINDOW.get(), ObjectRegistry.CHESTNUT_TRAPDOOR.get(), ObjectRegistry.EBONY_WINDOW.get(), ObjectRegistry.EBONY_DOOR.get(),
                ObjectRegistry.EBONY_SAPLING.get(), ObjectRegistry.POTTED_EBONY_SAPLING.get(), ObjectRegistry.EBONY_TRAPDOOR.get(), ObjectRegistry.MOSSY_LATERIT.get(),
                ObjectRegistry.FIR_LEAVES.get(), ObjectRegistry.FLOATING_LEAVES.get(), ObjectRegistry.POTTED_CHESTNUT_SAPLING.get()

        );


        ColorHandlerRegistry.registerItemColors((stack, tintIndex) -> FoliageColor.get(0.5, 1.0), ObjectRegistry.CHESTNUT_LEAVES.get(), ObjectRegistry.SWAMP_CYPRESS_LEAVES.get(), ObjectRegistry.MOSSY_LATERIT.get(), ObjectRegistry.EBONY_LEAVES.get());
        ColorHandlerRegistry.registerBlockColors((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return -1;
            }
            return BiomeColors.getAverageFoliageColor(world, pos);
        }, ObjectRegistry.SWAMP_CYPRESS_LEAVES.get(), ObjectRegistry.CHESTNUT_LEAVES.get(), ObjectRegistry.EBONY_LEAVES.get());
        ColorHandlerRegistry.registerBlockColors((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return -1;
            }
            return BiomeColors.getAverageGrassColor(world, pos);
        }, ObjectRegistry.MOSSY_LATERIT.get());
    }

    public static void preInitClient() {
        registerEntityRenderers();
        registerEntityModelLayer();
    }

    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(EntityRegistry.WANDERING_GARDENER, WanderingGardenerRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.TERMITE, TermiteRenderer::new);
    }

    public static void registerEntityModelLayer() {
        EntityModelLayerRegistry.register(WanderingGardenerModel.LAYER_LOCATION, WanderingGardenerModel::getTexturedModelData);
        EntityModelLayerRegistry.register(TermiteModel.LAYER_LOCATION, TermiteModel::getTexturedModelData);
    }
}


package satisfy.wildernature.client;

import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.SheepFurModel;
import net.minecraft.client.model.SheepModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import satisfy.wildernature.WilderNature;
import satisfy.wildernature.client.model.*;
import satisfy.wildernature.client.render.entity.*;
import satisfy.wildernature.registry.EntityRegistry;

@Environment(EnvType.CLIENT)
public class WilderNatureClient {

    public static final ModelLayerLocation MOSSY_SHEEP_FUR = new ModelLayerLocation(new ResourceLocation(WilderNature.MOD_ID, "mossy_sheep_"), "fur");
    public static final ModelLayerLocation MOSSY_SHEEP_MODEL_LAYER = new ModelLayerLocation(new ResourceLocation(WilderNature.MOD_ID, "mossy_sheep"), "main");

    public static void preInitClient() {
        registerEntityRenderers();
        registerEntityModelLayer();
    }

    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(EntityRegistry.RED_WOLF, RedWolfRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.PELICAN, PelicanRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.RACCOON, RaccoonRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.SQUIRREL, SquirrelRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.MUDDY_PIG, MuddyPigRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.MOSSY_SHEEP, MossySheepRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.DEER, DeerRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.OWL, OwlRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.BOAR, BoarRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.BISON, BisonRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.TURKEY, TurkeyRenderer::new);
    }

    public static void registerEntityModelLayer() {
        EntityModelLayerRegistry.register(RedWolfModel.LAYER_LOCATION, RedWolfModel::getTexturedModelData);
        EntityModelLayerRegistry.register(PelicanModel.LAYER_LOCATION, PelicanModel::getTexturedModelData);
        EntityModelLayerRegistry.register(RaccoonModel.LAYER_LOCATION, RaccoonModel::getTexturedModelData);
        EntityModelLayerRegistry.register(SquirrelModel.LAYER_LOCATION, SquirrelModel::getTexturedModelData);
        EntityModelLayerRegistry.register(MuddyPigModel.LAYER_LOCATION, MuddyPigModel::getTexturedModelData);
        EntityModelLayerRegistry.register(DeerModel.LAYER_LOCATION, DeerModel::getTexturedModelData);
        EntityModelLayerRegistry.register(MOSSY_SHEEP_MODEL_LAYER, SheepModel::createBodyLayer);
        EntityModelLayerRegistry.register(MOSSY_SHEEP_FUR, SheepFurModel::createFurLayer);
        EntityModelLayerRegistry.register(OwlModel.LAYER_LOCATION, OwlModel::getTexturedModelData);
        EntityModelLayerRegistry.register(BoarModel.LAYER_LOCATION, BoarModel::getTexturedModelData);
        EntityModelLayerRegistry.register(BisonModel.LAYER_LOCATION, BisonModel::getTexturedModelData);
        EntityModelLayerRegistry.register(TurkeyModel.LAYER_LOCATION, TurkeyModel::getTexturedModelData);
    }
}


package satisfy.wildernature.client.render.entity;

import net.minecraft.client.model.SheepModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import satisfy.wildernature.WilderNature;
import satisfy.wildernature.client.WilderNatureClient;
import satisfy.wildernature.entity.SheepEntity;

public class MossySheepRenderer extends MobRenderer<SheepEntity, SheepModel<SheepEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(WilderNature.MOD_ID, "textures/entity/mossy_sheep.png");

    public MossySheepRenderer(EntityRendererProvider.Context context) {
        super(context, new SheepModel<>(context.bakeLayer(WilderNatureClient.MOSSY_SHEEP_MODEL_LAYER)), 0.7f);
        this.addLayer(new MossySheepWoolFeature<>(this, context.getModelSet(), "mossy", WilderNatureClient.MOSSY_SHEEP_FUR));
    }

    @Override
    public ResourceLocation getTextureLocation(SheepEntity entity) {
        return TEXTURE;
    }
}
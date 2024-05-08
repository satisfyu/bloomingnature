package satisfy.wildernature.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import satisfy.wildernature.client.model.DeerModel;
import satisfy.wildernature.entity.DeerEntity;
import satisfy.wildernature.util.WilderNatureIdentifier;


@Environment(value = EnvType.CLIENT)
public class DeerRenderer extends MobRenderer<DeerEntity, DeerModel<DeerEntity>> {
    private static final ResourceLocation TEXTURE = new WilderNatureIdentifier("textures/entity/deer.png");

    public DeerRenderer(EntityRendererProvider.Context context) {
        super(context, new DeerModel(context.bakeLayer(DeerModel.LAYER_LOCATION)), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(DeerEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(DeerEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}



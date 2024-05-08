package satisfy.wildernature.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import satisfy.wildernature.client.model.RaccoonModel;
import satisfy.wildernature.entity.RaccoonEntity;
import satisfy.wildernature.util.WilderNatureIdentifier;


@Environment(value = EnvType.CLIENT)
public class RaccoonRenderer extends MobRenderer<RaccoonEntity, RaccoonModel<RaccoonEntity>> {
    private static final ResourceLocation RACCOON_TEXTURE = new WilderNatureIdentifier("textures/entity/raccoon.png");
    private static final ResourceLocation RACOON_SLEEP_TEXTURE = new WilderNatureIdentifier("textures/entity/raccoon.png");

    public RaccoonRenderer(EntityRendererProvider.Context context) {
        super(context, new RaccoonModel(context.bakeLayer(RaccoonModel.LAYER_LOCATION)), 0.7f);
    }

    protected void setupRotations(RaccoonEntity raccoon, PoseStack poseStack, float f, float g, float h) {
        super.setupRotations(raccoon, poseStack, f, g, h);
    }

    protected float getBob(RaccoonEntity RaccoonEntity, float f) {
        return RaccoonEntity.getTailAngle();
    }


    public @NotNull ResourceLocation getTextureLocation(RaccoonEntity entity) {
        return entity.isSleeping() ? RACOON_SLEEP_TEXTURE : RACCOON_TEXTURE;
    }

    @Override
    public void render(RaccoonEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}


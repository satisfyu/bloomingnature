package satisfy.wildernature.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import satisfy.wildernature.WilderNature;
import satisfy.wildernature.client.model.OwlModel;
import satisfy.wildernature.entity.OwlEntity;

public class OwlRenderer extends MobRenderer<OwlEntity, OwlModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(WilderNature.MOD_ID, "textures/entity/owl.png");

    public OwlRenderer(EntityRendererProvider.Context context) {
        super(context, new OwlModel(context.bakeLayer(OwlModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(OwlEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void renderNameTag(OwlEntity entity, Component component, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        poseStack.pushPose();
        if (entity.isBaby())
            poseStack.translate(0, 0.5F, 0);

        super.renderNameTag(entity, component, poseStack, multiBufferSource, i);

        poseStack.popPose();
    }

    @Override
    protected void setupRotations(OwlEntity owl, PoseStack poseStack, float f, float g, float h) {
        super.setupRotations(owl, poseStack, f, g, h);
        if (owl.isInSittingPose()) poseStack.translate(0, 0F, 0);

        float i = owl.getSwimAmount(h);

        poseStack.translate(0, (i / 7F) / 2F, (i / 7F) / 2F);
        if (i > 0.0F) {
            poseStack.mulPose(Axis.XP.rotationDegrees(Mth.lerp(i, 0, -7.0F)));
        }
        poseStack.scale(0.75F, 0.75F, 0.75F);
    }
}

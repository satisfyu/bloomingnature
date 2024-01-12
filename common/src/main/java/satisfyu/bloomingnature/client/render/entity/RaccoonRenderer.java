package satisfyu.bloomingnature.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import satisfyu.bloomingnature.client.model.RaccoonModel;
import satisfyu.bloomingnature.entity.RaccoonEntity;
import satisfyu.bloomingnature.entity.RedWolfEntity;
import satisfyu.bloomingnature.util.BloomingNatureIdentifier;


@Environment(value = EnvType.CLIENT)
public class RaccoonRenderer extends MobRenderer<RaccoonEntity, RaccoonModel<RaccoonEntity>> {
    private static final ResourceLocation RACCOON_TEXTURE = new BloomingNatureIdentifier("textures/entity/raccoon.png");
    private static final ResourceLocation RACOON_SLEEP_TEXTURE = new BloomingNatureIdentifier("textures/entity/raccoon.png");

    public RaccoonRenderer(EntityRendererProvider.Context context) {
        super(context, new RaccoonModel(context.bakeLayer(RaccoonModel.LAYER_LOCATION)), 0.7f);
    }
    
    protected void setupRotations(RaccoonEntity raccoon, PoseStack poseStack, float f, float g, float h) {
        super.setupRotations(raccoon, poseStack, f, g, h);
        if (raccoon.isPouncing() || raccoon.isFaceplanted()) {
            float i = -Mth.lerp(h, raccoon.xRotO, raccoon.getXRot());
            poseStack.mulPose(Axis.XP.rotationDegrees(i));
        }
    }

    protected float getBob(RaccoonEntity RaccoonEntity, float f) {
        return RaccoonEntity.getTailAngle();
    }


    public ResourceLocation getTextureLocation(RaccoonEntity entity) {
            return entity.isSleeping() ? RACOON_SLEEP_TEXTURE : RACCOON_TEXTURE;
              }
}

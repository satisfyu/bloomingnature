package satisfyu.bloomingnature.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import satisfyu.bloomingnature.BloomingNature;
import satisfyu.bloomingnature.client.model.TurkeyModel;
import satisfyu.bloomingnature.entity.DeerEntity;
import satisfyu.bloomingnature.entity.TurkeyEntity;

public class TurkeyRenderer extends MobRenderer<TurkeyEntity, TurkeyModel<TurkeyEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(BloomingNature.MOD_ID, "textures/entity/turkey.png");
    private static final ResourceLocation TEXTURE_EASTEREGG = new ResourceLocation(BloomingNature.MOD_ID, "textures/entity/turkey_easteregg.png");

    public TurkeyRenderer(EntityRendererProvider.Context context) {
        super(context, new TurkeyModel<>(context.bakeLayer(TurkeyModel.LAYER_LOCATION)), 0.7f);
    }

    protected float getBob(TurkeyEntity pelican, float f) {
        float g = Mth.lerp(f, pelican.oFlap, pelican.flap);
        float h = Mth.lerp(f, pelican.oFlapSpeed, pelican.flapSpeed);
        return (Mth.sin(g) + 1.0F) * h;
    }

    @Override
    public ResourceLocation getTextureLocation(TurkeyEntity entity) {
        if (entity.hasCustomName()) {
            String nameString = ChatFormatting.stripFormatting(entity.getCustomName().getString());
            if (nameString != null && !nameString.isEmpty()) {
                return TEXTURE_EASTEREGG;
            }
        }

        return TEXTURE;
    }

    @Override
    public void render(TurkeyEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}


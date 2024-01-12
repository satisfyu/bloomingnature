package satisfyu.bloomingnature.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Wolf;
import satisfyu.bloomingnature.client.model.RedWolfModel;
import satisfyu.bloomingnature.entity.RedWolfEntity;
import satisfyu.bloomingnature.util.BloomingNatureIdentifier;


@Environment(value = EnvType.CLIENT)
public class RedWolfRenderer extends MobRenderer<RedWolfEntity, RedWolfModel<RedWolfEntity>> {
    private static final ResourceLocation TEXTURE = new BloomingNatureIdentifier("textures/entity/red_wolf.png");

    public RedWolfRenderer(EntityRendererProvider.Context context) {
        super(context, new RedWolfModel(context.bakeLayer(RedWolfModel.LAYER_LOCATION)), 0.7f);
    }

    protected float getBob(RedWolfEntity RedWolfEntity, float f) {
        return RedWolfEntity.getTailAngle();
    }

    @Override
    public ResourceLocation getTextureLocation(RedWolfEntity entity) {
        return TEXTURE;
    }
}

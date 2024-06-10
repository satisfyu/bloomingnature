package net.satisfy.bloomingnature.util;

import de.cristelknight.doapi.api.DoApiAPI;
import de.cristelknight.doapi.api.DoApiPlugin;
import de.cristelknight.doapi.client.render.feature.CustomArmorManager;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.satisfy.bloomingnature.registry.ObjectRegistry;

import java.util.Map;
import java.util.Set;

@DoApiPlugin
public class BloomingNatureDoAPI implements DoApiAPI {

    @Override
    public void registerBlocks(Set<Block> blocks) {
        blocks.add(ObjectRegistry.FLOWER_BOX.get());
        blocks.add(ObjectRegistry.FLOWER_POT_BIG.get());
    }

    @Override
    @SuppressWarnings("deprecation")
    public <T extends LivingEntity> void registerHat(Map<Item, EntityModel<T>> map, EntityModelSet entityModelSet) {
    }

    @Override
    public <T extends LivingEntity> void registerArmor(CustomArmorManager<T> customArmorManager, EntityModelSet entityModelSet) {
    }
}
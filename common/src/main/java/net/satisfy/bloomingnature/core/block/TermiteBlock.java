package net.satisfy.bloomingnature.core.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.satisfy.bloomingnature.core.entity.TermiteEntity;
import net.satisfy.bloomingnature.core.registry.EntityTypeRegistry;

public class TermiteBlock extends Block {

    public TermiteBlock(Block block, BlockBehaviour.Properties properties) {
        super(properties.destroyTime(block.defaultDestroyTime() / 2.0F).explosionResistance(0.75F));
    }

    private void spawnInfestation(ServerLevel serverLevel, BlockPos blockPos) {
        TermiteEntity termiteEntity = new TermiteEntity(EntityTypeRegistry.TERMITE.get(), serverLevel);
        termiteEntity.moveTo((double) blockPos.getX() + 0.4, blockPos.getY(), (double) blockPos.getZ() + 0.5, 0.0F, 0.0F);
        serverLevel.addFreshEntity(termiteEntity);
        termiteEntity.spawnAnim();
    }

    @SuppressWarnings("deprecation")
    public void spawnAfterBreak(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, ItemStack itemStack, boolean bl) {
        super.spawnAfterBreak(blockState, serverLevel, blockPos, itemStack, bl);

        if (serverLevel.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS) &&
                EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, itemStack) == 0) {

            if (serverLevel.random.nextFloat() < 0.5F) {
                int numTermites = serverLevel.random.nextInt(2) + 3;

                for (int i = 0; i < numTermites; i++) {
                    spawnInfestation(serverLevel, blockPos);
                }
            }
        }
    }
}

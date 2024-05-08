package satisfy.wildernature.item;

import de.cristelknight.doapi.common.item.StandardItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import satisfy.wildernature.util.WilderNatureIdentifier;

import java.util.List;

public class WilderNatureStandardItem extends StandardItem {
    public WilderNatureStandardItem(Properties properties) {
        super(properties, new WilderNatureIdentifier("textures/standard/wildernature_standard.png"), () -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1, true, false, true));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> tooltip, TooltipFlag tooltipFlag) {
        tooltip.add(Component.translatable("tooltip.wildernature.thankyou_1").withStyle(ChatFormatting.ITALIC, ChatFormatting.GRAY));
        tooltip.add(Component.empty());
        tooltip.add(Component.translatable("tooltip.wildernature.thankyou_2").withStyle(ChatFormatting.DARK_PURPLE));
        tooltip.add(Component.translatable("tooltip.wildernature.thankyou_4").withStyle(ChatFormatting.BLUE));
        tooltip.add(Component.empty());
        tooltip.add(Component.translatable("tooltip.wildernature.thankyou_3").withStyle(ChatFormatting.GOLD));
    }
}
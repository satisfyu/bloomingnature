package satisfy.wildernature.forge.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;
import satisfy.wildernature.WilderNature;
import satisfy.wildernature.client.WilderNatureClient;

@Mod.EventBusSubscriber(modid = WilderNature.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WilderNatureClientForge {

    @SubscribeEvent
    public static void beforeClientSetup(RegisterEvent event) {
        WilderNatureClient.preInitClient();
    }

}

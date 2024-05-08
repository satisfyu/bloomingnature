package satisfy.wildernature.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import satisfy.wildernature.WilderNature;
import satisfy.wildernature.forge.registry.WilderNatureBiomeModifiers;

@Mod(WilderNature.MOD_ID)
public class WilderNatureForge {
    public WilderNatureForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(WilderNature.MOD_ID, modEventBus);
        WilderNature.init();
        WilderNatureBiomeModifiers.BIOME_MODIFIER_SERIALIZERS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(CompostableRegistry::init);
        WilderNature.commonInit();
    }
}
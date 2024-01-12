package satisfyu.bloomingnature.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import satisfyu.bloomingnature.BloomingNature;
import satisfyu.bloomingnature.registry.CompostableRegistry;

@Mod(BloomingNature.MOD_ID)
public class BloomingNatureForge {
    public BloomingNatureForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(BloomingNature.MOD_ID, modEventBus);
        BloomingNature.init();
        modEventBus.addListener(this::commonSetup);
    }


        private void commonSetup(final FMLCommonSetupEvent event) {
            event.enqueueWork(CompostableRegistry::init);
            BloomingNature.commonInit();
        }
    }
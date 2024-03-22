package satisfy.bloomingnature.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import satisfy.bloomingnature.BloomingNature;
import satisfy.bloomingnature.entity.FlowerPotBigBlockEntity;
import satisfy.bloomingnature.entity.FlowerBoxBlockEntity;

import java.util.function.Supplier;

public class BlockEntityRegistry {

    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BloomingNature.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<FlowerBoxBlockEntity>> FLOWER_BOX_ENTITY = create("flower_box", () -> BlockEntityType.Builder.of(FlowerBoxBlockEntity::new, ObjectRegistry.FLOWER_BOX.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<FlowerPotBigBlockEntity>> FLOWER_POT_BIG_ENTITY = create("flower_pot_big", () -> BlockEntityType.Builder.of(FlowerPotBigBlockEntity::new, ObjectRegistry.FLOWER_POT_BIG.get()).build(null));


    private static <T extends BlockEntityType<?>> RegistrySupplier<T> create(final String path, final Supplier<T> type) {
        return BLOCK_ENTITY_TYPES.register(path, type);
    }

    public static void init() {
        BloomingNature.LOGGER.debug("Registering Mod BlockEntities for " + BloomingNature.MOD_ID);
        BLOCK_ENTITY_TYPES.register();
    }

}

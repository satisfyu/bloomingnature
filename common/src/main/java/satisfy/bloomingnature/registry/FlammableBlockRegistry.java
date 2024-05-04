package satisfy.bloomingnature.registry;

import de.cristelknight.doapi.DoApiCommonEP;
import net.minecraft.world.level.block.Block;

public class FlammableBlockRegistry {

    public static void init() {
        add(5, 20,
                ObjectRegistry.BAOBAB_PLANKS.get(), ObjectRegistry.BAOBAB_SLAB.get(), ObjectRegistry.BAOBAB_STAIRS.get(), ObjectRegistry.BAOBAB_FENCE.get(),
                ObjectRegistry.BAOBAB_FENCE_GATE.get(),
                ObjectRegistry.SWAMP_OAK_PLANKS.get(), ObjectRegistry.SWAMP_OAK_SLAB.get(), ObjectRegistry.SWAMP_OAK_STAIRS.get(),
                ObjectRegistry.SWAMP_OAK_FENCE.get(), ObjectRegistry.SWAMP_OAK_FENCE_GATE.get(),
                ObjectRegistry.SWAMP_CYPRESS_PLANKS.get(), ObjectRegistry.SWAMP_CYPRESS_SLAB.get(), ObjectRegistry.SWAMP_CYPRESS_STAIRS.get(),
                ObjectRegistry.SWAMP_CYPRESS_FENCE.get(), ObjectRegistry.SWAMP_CYPRESS_FENCE_GATE.get(),
                ObjectRegistry.LARCH_PLANKS.get(), ObjectRegistry.LARCH_SLAB.get(), ObjectRegistry.LARCH_STAIRS.get(),
                ObjectRegistry.LARCH_FENCE.get(), ObjectRegistry.LARCH_FENCE_GATE.get(),
                ObjectRegistry.FIR_PLANKS.get(), ObjectRegistry.FIR_SLAB.get(), ObjectRegistry.FIR_STAIRS.get(),
                ObjectRegistry.FIR_FENCE.get(), ObjectRegistry.FIR_FENCE_GATE.get(),
                ObjectRegistry.CHESTNUT_PLANKS.get(), ObjectRegistry.CHESTNUT_SLAB.get(), ObjectRegistry.CHESTNUT_STAIRS.get(),
                ObjectRegistry.CHESTNUT_FENCE.get(), ObjectRegistry.CHESTNUT_FENCE_GATE.get(),
                ObjectRegistry.FAN_PALM_PLANKS.get(), ObjectRegistry.FAN_PALM_SLAB.get(), ObjectRegistry.FAN_PALM_STAIRS.get(),
                ObjectRegistry.FAN_PALM_FENCE.get(), ObjectRegistry.FAN_PALM_FENCE_GATE.get(),
                ObjectRegistry.ASPEN_PLANKS.get(), ObjectRegistry.ASPEN_SLAB.get(), ObjectRegistry.ASPEN_STAIRS.get(),
                ObjectRegistry.ASPEN_FENCE.get(), ObjectRegistry.ASPEN_FENCE_GATE.get(),
                ObjectRegistry.EBONY_PLANKS.get(), ObjectRegistry.EBONY_SLAB.get(), ObjectRegistry.EBONY_STAIRS.get(),
                ObjectRegistry.EBONY_FENCE.get(), ObjectRegistry.EBONY_FENCE_GATE.get()
        );

        add(5, 5,
                ObjectRegistry.SWAMP_OAK_LOG.get(), ObjectRegistry.SWAMP_OAK_WOOD.get(), ObjectRegistry.STRIPPED_SWAMP_OAK_LOG.get(), ObjectRegistry.STRIPPED_SWAMP_OAK_WOOD.get(),
                ObjectRegistry.SWAMP_CYPRESS_LOG.get(), ObjectRegistry.SWAMP_CYPRESS_WOOD.get(), ObjectRegistry.STRIPPED_SWAMP_CYPRESS_LOG.get(), ObjectRegistry.STRIPPED_SWAMP_CYPRESS_WOOD.get(),
                ObjectRegistry.LARCH_LOG.get(), ObjectRegistry.LARCH_WOOD.get(), ObjectRegistry.STRIPPED_LARCH_LOG.get(), ObjectRegistry.STRIPPED_LARCH_WOOD.get(),
                ObjectRegistry.FIR_LOG.get(), ObjectRegistry.FIR_WOOD.get(), ObjectRegistry.STRIPPED_FIR_LOG.get(), ObjectRegistry.STRIPPED_FIR_WOOD.get(),
                ObjectRegistry.CHESTNUT_LOG.get(), ObjectRegistry.CHESTNUT_WOOD.get(), ObjectRegistry.STRIPPED_CHESTNUT_LOG.get(), ObjectRegistry.STRIPPED_CHESTNUT_WOOD.get(),
                ObjectRegistry.FAN_PALM_LOG.get(), ObjectRegistry.FAN_PALM_WOOD.get(), ObjectRegistry.STRIPPED_FAN_PALM_LOG.get(), ObjectRegistry.STRIPPED_FAN_PALM_WOOD.get(),
                ObjectRegistry.ASPEN_LOG.get(), ObjectRegistry.ASPEN_WOOD.get(), ObjectRegistry.STRIPPED_ASPEN_LOG.get(), ObjectRegistry.STRIPPED_ASPEN_WOOD.get(),
                ObjectRegistry.EBONY_LOG.get(), ObjectRegistry.EBONY_WOOD.get(), ObjectRegistry.STRIPPED_EBONY_LOG.get(), ObjectRegistry.STRIPPED_EBONY_WOOD.get(),
                ObjectRegistry.BAOBAB_LOG.get(), ObjectRegistry.BAOBAB_WOOD.get(), ObjectRegistry.STRIPPED_BAOBAB_LOG.get(), ObjectRegistry.STRIPPED_BAOBAB_WOOD.get()

        );

        add(30, 60,
                ObjectRegistry.BAOBAB_LEAVES.get(),
                ObjectRegistry.SWAMP_OAK_LEAVES.get(),
                ObjectRegistry.SWAMP_CYPRESS_LEAVES.get(),
                ObjectRegistry.LARCH_LEAVES.get(),
                ObjectRegistry.FIR_LEAVES.get(),
                ObjectRegistry.CHESTNUT_LEAVES.get(),
                ObjectRegistry.FAN_PALM_LEAVES.get(),
                ObjectRegistry.ASPEN_LEAVES.get(),
                ObjectRegistry.EBONY_LEAVES.get(),
                ObjectRegistry.ORANGE_LEAVES.get()

        );
    }

    private static void add(int burnOdd, int igniteOdd, Block... blocks) {
        DoApiCommonEP.addFlammable(burnOdd, igniteOdd, blocks);
    }

}

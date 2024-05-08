package satisfy.bloomingnature.registry;

import de.cristelknight.doapi.common.util.datafixer.DataFixers;
import de.cristelknight.doapi.common.util.datafixer.StringPairs;
import satisfy.bloomingnature.BloomingNature;

public class DataFixerRegistry {

    public static void init() {
        StringPairs p = DataFixers.getOrCreate(BloomingNature.MOD_ID);
        p.add("palm_log", "fan_palm_log");
        p.add("palm_wood", "fan_palm_wood");
        p.add("stripped_palm_log", "stripped_fan_palm_log");
        p.add("stripped_palm_wood", "stripped_fan_palm_wood");
        p.add("palm_planks", "fan_palm_planks");
        p.add("palm_stairs", "fan_palm_stairs");
        p.add("palm_slab", "fan_palm_slab");
        p.add("palm_pressure_plate", "fan_palm_pressure_plate");
        p.add("palm_button", "fan_palm_button");
        p.add("palm_trapdoor", "fan_palm_trapdoor");
        p.add("palm_door", "fan_palm_door");
        p.add("palm_fence", "fan_palm_fence");
        p.add("palm_fence_gate", "fan_palm_fence_gate");
        p.add("palm_window", "fan_palm_window");
        p.add("palm_leaves", "fan_palm_leaves");
        p.add("palm_sapling", "fan_palm_sprout");
    }
}

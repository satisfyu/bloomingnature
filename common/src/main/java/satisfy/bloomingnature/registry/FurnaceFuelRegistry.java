package satisfy.bloomingnature.registry;

import dev.architectury.registry.fuel.FuelRegistry;

import static satisfy.bloomingnature.registry.BoatsAndSignsRegistry.*;
import static satisfy.bloomingnature.registry.ObjectRegistry.*;

public class FurnaceFuelRegistry {

	private static final int BOAT_BURN_TIME = 200;
	private static final int BUTTON_BURN_TIME = 100;
	private static final int DOOR_BURN_TIME = 200;
	private static final int FENCE_BURN_TIME = 300;
	private static final int FENCE_GATE_BURN_TIME = 300;
	private static final int HANGING_SIGN_BURN_TIME = 800;
	private static final int LOG_BURN_TIME = 300;
	private static final int WOOD_BURN_TIME = 300;
	private static final int PLANKS_BURN_TIME = 300;
	private static final int PRESSURE_PLATE_BURN_TIME = 300;
	private static final int SAPLING_BURN_TIME = 100;
	private static final int SIGN_BURN_TIME = 200;
	private static final int SLAB_BURN_TIME = 150;
	private static final int STAIRS_BURN_TIME = 300;
	private static final int TRAPDOOR_BURN_TIME = 300;
	private static final int WINDOW_BURN_TIME = 200;

	public static void init()
	{
		registerFuelSources();
	}

	private static void registerFuelSources()
	{
		// Boat
		FuelRegistry.register(BOAT_BURN_TIME,
			ASPEN_BOAT.get(), ASPEN_CHEST_BOAT.get(),
			BAOBAB_BOAT.get(), BAOBAB_CHEST_BOAT.get(),
			CHESTNUT_BOAT.get(), CHESTNUT_CHEST_BOAT.get(),
			EBONY_BOAT.get(), EBONY_CHEST_BOAT.get(),
			FAN_PALM_BOAT.get(), FAN_PALM_CHEST_BOAT.get(),
			LARCH_BOAT.get(), LARCH_CHEST_BOAT.get(),
			SWAMP_CYPRESS_BOAT.get(), SWAMP_CYPRESS_CHEST_BOAT.get(),
			SWAMP_OAK_BOAT.get(), SWAMP_OAK_CHEST_BOAT.get());

		// Button
		FuelRegistry.register(BUTTON_BURN_TIME,
			ASPEN_BUTTON.get(),
			BAOBAB_BUTTON.get(),
			CHESTNUT_BUTTON.get(),
			EBONY_BUTTON.get(),
			FAN_PALM_BUTTON.get(),
			FIR_BUTTON.get(),
			LARCH_BUTTON.get(),
			SWAMP_CYPRESS_BUTTON.get(),
			SWAMP_OAK_BUTTON.get());

		// Door
		FuelRegistry.register(DOOR_BURN_TIME,
			ASPEN_DOOR.get(),
			BAOBAB_DOOR.get(),
			CHESTNUT_DOOR.get(),
			EBONY_DOOR.get(),
			FAN_PALM_DOOR.get(),
			FIR_DOOR.get(),
			LARCH_DOOR.get(),
			SWAMP_CYPRESS_DOOR.get(),
			SWAMP_OAK_DOOR.get());

		// Fence
		FuelRegistry.register(FENCE_BURN_TIME,
			ASPEN_FENCE.get(),
			BAOBAB_FENCE.get(),
			CHESTNUT_FENCE.get(),
			EBONY_FENCE.get(),
			FAN_PALM_FENCE.get(),
			FIR_FENCE.get(),
			LARCH_FENCE.get(),
			SWAMP_CYPRESS_FENCE.get(),
			SWAMP_OAK_FENCE.get());

		// Fence Gate
		FuelRegistry.register(FENCE_GATE_BURN_TIME,
			ASPEN_FENCE_GATE.get(),
			BAOBAB_FENCE_GATE.get(),
			CHESTNUT_FENCE_GATE.get(),
			EBONY_FENCE_GATE.get(),
			FAN_PALM_FENCE_GATE.get(),
			FIR_FENCE_GATE.get(),
			LARCH_FENCE_GATE.get(),
			SWAMP_CYPRESS_FENCE_GATE.get(),
			SWAMP_OAK_FENCE_GATE.get());

		// Hanging Sign
		FuelRegistry.register(HANGING_SIGN_BURN_TIME,
			ASPEN_HANGING_SIGN_ITEM.get(),
			BAOBAB_HANGING_SIGN_ITEM.get(),
			CHESTNUT_HANGING_SIGN_ITEM.get(),
			EBONY_HANGING_SIGN_ITEM.get(),
			FAN_PALM_HANGING_SIGN_ITEM.get(),
			FIR_HANGING_SIGN_ITEM.get(),
			LARCH_HANGING_SIGN_ITEM.get(),
			SWAMP_CYPRESS_HANGING_SIGN_ITEM.get(),
			SWAMP_OAK_HANGING_SIGN_ITEM.get());

		// Log
		FuelRegistry.register(LOG_BURN_TIME,
			ASPEN_LOG.get(), STRIPPED_ASPEN_LOG.get(),
			BAOBAB_LOG.get(), STRIPPED_BAOBAB_LOG.get(),
			CHESTNUT_LOG.get(), STRIPPED_CHESTNUT_LOG.get(),
			EBONY_LOG.get(), STRIPPED_EBONY_LOG.get(),
			FAN_PALM_LOG.get(), STRIPPED_FAN_PALM_LOG.get(),
			FIR_LOG.get(), STRIPPED_FIR_LOG.get(),
			LARCH_LOG.get(), STRIPPED_LARCH_LOG.get(),
			SWAMP_CYPRESS_LOG.get(), STRIPPED_SWAMP_CYPRESS_LOG.get(),
			SWAMP_OAK_LOG.get(), STRIPPED_SWAMP_OAK_LOG.get());

		// Wood
		FuelRegistry.register(WOOD_BURN_TIME,
			ASPEN_WOOD.get(), STRIPPED_ASPEN_WOOD.get(),
			BAOBAB_WOOD.get(), STRIPPED_BAOBAB_WOOD.get(),
			CHESTNUT_WOOD.get(), STRIPPED_CHESTNUT_WOOD.get(),
			EBONY_WOOD.get(), STRIPPED_EBONY_WOOD.get(),
			FAN_PALM_WOOD.get(), STRIPPED_FAN_PALM_WOOD.get(),
			FIR_WOOD.get(), STRIPPED_FIR_WOOD.get(),
			LARCH_WOOD.get(), STRIPPED_LARCH_WOOD.get(),
			SWAMP_CYPRESS_WOOD.get(), STRIPPED_SWAMP_CYPRESS_WOOD.get(),
			SWAMP_OAK_WOOD.get(), STRIPPED_SWAMP_OAK_WOOD.get());

		// Planks
		FuelRegistry.register(PLANKS_BURN_TIME,
			ASPEN_PLANKS.get(),
			BAOBAB_PLANKS.get(),
			CHESTNUT_PLANKS.get(),
			EBONY_PLANKS.get(),
			FAN_PALM_PLANKS.get(),
			FIR_PLANKS.get(),
			LARCH_PLANKS.get(),
			SWAMP_CYPRESS_PLANKS.get(),
			SWAMP_OAK_PLANKS.get());

		// Pressure Plate
		FuelRegistry.register(PRESSURE_PLATE_BURN_TIME,
			ASPEN_PRESSURE_PLATE.get(),
			BAOBAB_PRESSURE_PLATE.get(),
			CHESTNUT_PRESSURE_PLATE.get(),
			EBONY_PRESSURE_PLATE.get(),
			FAN_PALM_PRESSURE_PLATE.get(),
			FIR_PRESSURE_PLATE.get(),
			LARCH_PRESSURE_PLATE.get(),
			SWAMP_CYPRESS_PRESSURE_PLATE.get(),
			SWAMP_OAK_PRESSURE_PLATE.get());

		// Sapling
		FuelRegistry.register(SAPLING_BURN_TIME,
			ASPEN_SAPLING.get(),
			BAOBAB_SAPLING.get(),
			BEACH_BUSH.get(),
			BEACH_BUSH_TALL.get(),
			BEACH_GRASS.get(),
			CHESTNUT_SAPLING.get(),
			EBONY_SAPLING.get(),
			FAN_PALM_SPROUT.get(),
			FIR_SAPLING.get(),
			LARCH_SAPLING.get(),
			SWAMP_CYPRESS_SAPLING.get(),
			SWAMP_OAK_SAPLING.get());

		// Sign
		FuelRegistry.register(SIGN_BURN_TIME,
			ASPEN_SIGN.get(),
			BAOBAB_SIGN.get(),
			CHESTNUT_SIGN.get(),
			EBONY_SIGN.get(),
			FAN_PALM_SIGN.get(),
			FIR_SIGN.get(),
			LARCH_SIGN.get(),
			SWAMP_CYPRESS_SIGN.get(),
			SWAMP_OAK_SIGN.get());

		// Slab
		FuelRegistry.register(SLAB_BURN_TIME,
			ASPEN_SLAB.get(),
			BAOBAB_SLAB.get(),
			CHESTNUT_SLAB.get(),
			EBONY_SLAB.get(),
			FAN_PALM_SLAB.get(),
			FIR_SLAB.get(),
			LARCH_SLAB.get(),
			SWAMP_CYPRESS_SLAB.get(),
			SWAMP_OAK_SLAB.get());

		// Stairs
		FuelRegistry.register(STAIRS_BURN_TIME,
			ASPEN_STAIRS.get(),
			BAOBAB_STAIRS.get(),
			CHESTNUT_STAIRS.get(),
			EBONY_STAIRS.get(),
			FAN_PALM_STAIRS.get(),
			FIR_STAIRS.get(),
			LARCH_STAIRS.get(),
			SWAMP_CYPRESS_STAIRS.get(),
			SWAMP_OAK_STAIRS.get());
		
		// Trap Door
		FuelRegistry.register(TRAPDOOR_BURN_TIME,
			ASPEN_TRAPDOOR.get(),
			BAOBAB_TRAPDOOR.get(),
			CHESTNUT_TRAPDOOR.get(),
			EBONY_TRAPDOOR.get(),
			FAN_PALM_TRAPDOOR.get(),
			FIR_TRAPDOOR.get(),
			LARCH_TRAPDOOR.get(),
			SWAMP_CYPRESS_TRAPDOOR.get(),
			SWAMP_OAK_TRAPDOOR.get());

		// Window
		FuelRegistry.register(WINDOW_BURN_TIME,
			ASPEN_WINDOW.get(),
			BAOBAB_WINDOW.get(),
			CHESTNUT_WINDOW.get(),
			EBONY_WINDOW.get(),
			FAN_PALM_WINDOW.get(),
			FIR_WINDOW.get(),
			LARCH_WINDOW.get(),
			SWAMP_CYPRESS_WINDOW.get(),
			SWAMP_OAK_WINDOW.get());
	}
}

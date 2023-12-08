package satisfyu.bloomingnature.registry;


import de.cristelknight.doapi.DoApiExpectPlatform;
import de.cristelknight.doapi.terraform.boat.TerraformBoatType;
import de.cristelknight.doapi.terraform.boat.item.TerraformBoatItemHelper;
import de.cristelknight.doapi.terraform.sign.TerraformSignHelper;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import satisfyu.bloomingnature.util.BloomingNatureIdentifier;

public class BoatsAndSignsRegistry {
    public static ResourceLocation ASPEN_BOAT_TYPE = new BloomingNatureIdentifier("aspen");
    public static ResourceLocation LARCH_BOAT_TYPE = new BloomingNatureIdentifier("larch");
    public static ResourceLocation SWAMP_OAK_BOAT_TYPE = new BloomingNatureIdentifier("swamp_oak");
    public static ResourceLocation BAOBAB_BOAT_TYPE = new BloomingNatureIdentifier("baobab");

    public static final ResourceLocation ASPEN_SIGN_TEXTURE = new BloomingNatureIdentifier("entity/signs/aspen");
    public static final ResourceLocation LARCH_SIGN_TEXTURE = new BloomingNatureIdentifier("entity/signs/larch");
    public static final ResourceLocation SWAMP_OAK_SIGN_TEXTURE = new BloomingNatureIdentifier("entity/signs/swamp_oak");
    public static final ResourceLocation BAOBAB_SIGN_TEXTURE = new BloomingNatureIdentifier("entity/signs/baobab");

    public static final RegistrySupplier<Block> ASPEN_SIGN = ObjectRegistry.registerWithoutItem("aspen_sign", () -> TerraformSignHelper.getSign(ASPEN_SIGN_TEXTURE));
    public static final RegistrySupplier<Block> ASPEN_WALL_SIGN = ObjectRegistry.registerWithoutItem("aspen_wall_sign", () -> TerraformSignHelper.getWallSign(ASPEN_SIGN_TEXTURE));
    public static final RegistrySupplier<Item> ASPEN_SIGN_ITEM = ObjectRegistry.registerItem("aspen_sign", () -> new SignItem(ObjectRegistry.getSettings().stacksTo(16), ASPEN_SIGN.get(), ASPEN_WALL_SIGN.get()));
    public static final RegistrySupplier<Block> LARCH_SIGN = ObjectRegistry.registerWithoutItem("larch_sign", () -> TerraformSignHelper.getSign(LARCH_SIGN_TEXTURE));
    public static final RegistrySupplier<Block> LARCH_WALL_SIGN = ObjectRegistry.registerWithoutItem("larch_wall_sign", () -> TerraformSignHelper.getWallSign(LARCH_SIGN_TEXTURE));
    public static final RegistrySupplier<Item> LARCH_SIGN_ITEM = ObjectRegistry.registerItem("larch_sign", () -> new SignItem(ObjectRegistry.getSettings().stacksTo(16), LARCH_SIGN.get(), LARCH_WALL_SIGN.get()));
    public static final RegistrySupplier<Block> SWAMP_OAK_SIGN = ObjectRegistry.registerWithoutItem("swamp_oak_sign", () -> TerraformSignHelper.getSign(SWAMP_OAK_SIGN_TEXTURE));
    public static final RegistrySupplier<Block> SWAMP_OAK_WALL_SIGN = ObjectRegistry.registerWithoutItem("swamp_oak_wall_sign", () -> TerraformSignHelper.getWallSign(SWAMP_OAK_SIGN_TEXTURE));
    public static final RegistrySupplier<Item> SWAMP_OAK_SIGN_ITEM = ObjectRegistry.registerItem("swamp_oak_sign", () -> new SignItem(ObjectRegistry.getSettings().stacksTo(16), SWAMP_OAK_SIGN.get(), SWAMP_OAK_WALL_SIGN.get()));
    public static final RegistrySupplier<Block> BAOBAB_SIGN = ObjectRegistry.registerWithoutItem("baobab_sign", () -> TerraformSignHelper.getSign(BAOBAB_SIGN_TEXTURE));
    public static final RegistrySupplier<Block> BAOBAB_WALL_SIGN = ObjectRegistry.registerWithoutItem("baobab_wall_sign", () -> TerraformSignHelper.getWallSign(BAOBAB_SIGN_TEXTURE));
    public static final RegistrySupplier<Item> BAOBAB_SIGN_ITEM = ObjectRegistry.registerItem("baobab_sign", () -> new SignItem(ObjectRegistry.getSettings().stacksTo(16), BAOBAB_SIGN.get(), BAOBAB_WALL_SIGN.get()));

    public static final ResourceLocation ASPEN_HANGING_SIGN_TEXTURE = new BloomingNatureIdentifier("entity/signs/hanging/aspen");
    public static final ResourceLocation ASPEN_HANGING_SIGN_GUI_TEXTURE = new BloomingNatureIdentifier("textures/gui/hanging_signs/aspen");
    public static final ResourceLocation LARCH_HANGING_SIGN_TEXTURE = new BloomingNatureIdentifier("entity/signs/hanging/larch");
    public static final ResourceLocation LARCH_HANGING_SIGN_GUI_TEXTURE = new BloomingNatureIdentifier("textures/gui/hanging_signs/larch");
    public static final ResourceLocation SWAMP_OAK_HANGING_SIGN_TEXTURE = new BloomingNatureIdentifier("entity/signs/hanging/swamp_oak");
    public static final ResourceLocation SWAMP_OAK_HANGING_SIGN_GUI_TEXTURE = new BloomingNatureIdentifier("textures/gui/hanging_signs/swamp_oak");
    public static final ResourceLocation BAOBAB_HANGING_SIGN_TEXTURE = new BloomingNatureIdentifier("entity/signs/hanging/baobab");
    public static final ResourceLocation BAOBAB_HANGING_SIGN_GUI_TEXTURE = new BloomingNatureIdentifier("textures/gui/hanging_signs/baobab");


    public static final RegistrySupplier<Block> ASPEN_HANGING_SIGN = ObjectRegistry.registerWithoutItem("aspen_hanging_sign", () -> TerraformSignHelper.getHangingSign(ASPEN_HANGING_SIGN_TEXTURE, ASPEN_HANGING_SIGN_GUI_TEXTURE));
    public static final RegistrySupplier<Block> ASPEN_WALL_HANGING_SIGN = ObjectRegistry.registerWithoutItem("aspen_wall_hanging_sign", () -> TerraformSignHelper.getWallHangingSign(ASPEN_HANGING_SIGN_TEXTURE, ASPEN_HANGING_SIGN_GUI_TEXTURE));
    public static final RegistrySupplier<Item> ASPEN_HANGING_SIGN_ITEM = ObjectRegistry.registerItem("aspen_hanging_sign", () -> new HangingSignItem(ASPEN_HANGING_SIGN.get(), ASPEN_WALL_HANGING_SIGN.get(), ObjectRegistry.getSettings().stacksTo(16)));
    public static final RegistrySupplier<Block> LARCH_HANGING_SIGN = ObjectRegistry.registerWithoutItem("larch_hanging_sign", () -> TerraformSignHelper.getHangingSign(LARCH_HANGING_SIGN_TEXTURE, LARCH_HANGING_SIGN_GUI_TEXTURE));
    public static final RegistrySupplier<Block> LARCH_WALL_HANGING_SIGN = ObjectRegistry.registerWithoutItem("larch_wall_hanging_sign", () -> TerraformSignHelper.getWallHangingSign(LARCH_HANGING_SIGN_TEXTURE, LARCH_HANGING_SIGN_GUI_TEXTURE));
    public static final RegistrySupplier<Item> LARCH_HANGING_SIGN_ITEM = ObjectRegistry.registerItem("larch_hanging_sign", () -> new HangingSignItem(LARCH_HANGING_SIGN.get(), LARCH_WALL_HANGING_SIGN.get(), ObjectRegistry.getSettings().stacksTo(16)));
    public static final RegistrySupplier<Block> SWAMP_OAK_HANGING_SIGN = ObjectRegistry.registerWithoutItem("swamp_oak_hanging_sign", () -> TerraformSignHelper.getHangingSign(SWAMP_OAK_HANGING_SIGN_TEXTURE, SWAMP_OAK_HANGING_SIGN_GUI_TEXTURE));
    public static final RegistrySupplier<Block> SWAMP_OAK_WALL_HANGING_SIGN = ObjectRegistry.registerWithoutItem("swamp_oak_wall_hanging_sign", () -> TerraformSignHelper.getWallHangingSign(SWAMP_OAK_HANGING_SIGN_TEXTURE, SWAMP_OAK_HANGING_SIGN_GUI_TEXTURE));
    public static final RegistrySupplier<Item> SWAMP_OAK_HANGING_SIGN_ITEM = ObjectRegistry.registerItem("swamp_oak_hanging_sign", () -> new HangingSignItem(SWAMP_OAK_HANGING_SIGN.get(), SWAMP_OAK_WALL_HANGING_SIGN.get(), ObjectRegistry.getSettings().stacksTo(16)));
    public static final RegistrySupplier<Block> BAOBAB_HANGING_SIGN = ObjectRegistry.registerWithoutItem("baobab_hanging_sign", () -> TerraformSignHelper.getHangingSign(BAOBAB_HANGING_SIGN_TEXTURE, BAOBAB_HANGING_SIGN_GUI_TEXTURE));
    public static final RegistrySupplier<Block> BAOBAB_WALL_HANGING_SIGN = ObjectRegistry.registerWithoutItem("baobab_wall_hanging_sign", () -> TerraformSignHelper.getWallHangingSign(BAOBAB_HANGING_SIGN_TEXTURE, BAOBAB_HANGING_SIGN_GUI_TEXTURE));
    public static final RegistrySupplier<Item> BAOBAB_HANGING_SIGN_ITEM = ObjectRegistry.registerItem("baobab_hanging_sign", () -> new HangingSignItem(BAOBAB_HANGING_SIGN.get(), BAOBAB_WALL_HANGING_SIGN.get(), ObjectRegistry.getSettings().stacksTo(16)));



    public static RegistrySupplier<Item> ASPEN_BOAT = TerraformBoatItemHelper.registerBoatItem(ObjectRegistry.ITEMS, "aspen_boat", ASPEN_BOAT_TYPE, false);
    public static RegistrySupplier<Item> ASPEN_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ObjectRegistry.ITEMS, "aspen_chest_boat", ASPEN_BOAT_TYPE, true);
    public static RegistrySupplier<Item> LARCH_BOAT = TerraformBoatItemHelper.registerBoatItem(ObjectRegistry.ITEMS, "larch_boat", LARCH_BOAT_TYPE, false);
    public static RegistrySupplier<Item> LARCH_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ObjectRegistry.ITEMS, "larch_chest_boat", LARCH_BOAT_TYPE, true);
    public static RegistrySupplier<Item> SWAMP_OAK_BOAT = TerraformBoatItemHelper.registerBoatItem(ObjectRegistry.ITEMS, "swamp_oak_boat", SWAMP_OAK_BOAT_TYPE, false);
    public static RegistrySupplier<Item> SWAMP_OAK_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ObjectRegistry.ITEMS, "swamp_oak_chest_boat", SWAMP_OAK_BOAT_TYPE, true);
    public static RegistrySupplier<Item> BAOBAB_BOAT = TerraformBoatItemHelper.registerBoatItem(ObjectRegistry.ITEMS, "baobab_boat", BAOBAB_BOAT_TYPE, false);
    public static RegistrySupplier<Item> BAOBAB_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ObjectRegistry.ITEMS, "baobab_chest_boat", BAOBAB_BOAT_TYPE, true);


    public static void init() {
        DoApiExpectPlatform.registerBoatType(LARCH_BOAT_TYPE, new TerraformBoatType.Builder().item(LARCH_BOAT).chestItem(LARCH_CHEST_BOAT).build());
    }
}
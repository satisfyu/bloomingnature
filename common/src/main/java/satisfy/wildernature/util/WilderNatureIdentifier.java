package satisfy.wildernature.util;

import net.minecraft.resources.ResourceLocation;
import satisfy.wildernature.WilderNature;

@SuppressWarnings("unused")
public class WilderNatureIdentifier extends ResourceLocation {
    public WilderNatureIdentifier(String path) {
        super(WilderNature.MOD_ID, path);
    }

    public static String asString(String path) {
        return (WilderNature.MOD_ID + ":" + path);
    }
}

package net.satisfy.bloomingnature.util;

import net.minecraft.resources.ResourceLocation;
import net.satisfy.bloomingnature.BloomingNature;

@SuppressWarnings("unused")
public class BloomingNatureIdentifier extends ResourceLocation {
    public BloomingNatureIdentifier(String path) {
        super(BloomingNature.MOD_ID, path);
    }

    public static String asString(String path) {
        return (BloomingNature.MOD_ID + ":" + path);
    }
}

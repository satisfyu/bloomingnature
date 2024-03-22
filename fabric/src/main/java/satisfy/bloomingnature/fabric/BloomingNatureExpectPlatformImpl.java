package satisfy.bloomingnature.fabric;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class BloomingNatureExpectPlatformImpl {
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}

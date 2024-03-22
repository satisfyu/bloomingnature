package satisfy.bloomingnature;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.nio.file.Path;

public class BloomingNatureExpectPlatform {

    @ExpectPlatform
    public static Path getConfigDirectory() {
        throw new AssertionError();
    }
}

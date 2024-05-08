package satisfy.wildernature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import satisfy.wildernature.registry.EntityRegistry;
import satisfy.wildernature.registry.ObjectRegistry;
import satisfy.wildernature.registry.SoundRegistry;
import satisfy.wildernature.registry.TabRegistry;

public class WilderNature {
    public static final String MOD_ID = "wildernature";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static void init() {
        ObjectRegistry.init();
        EntityRegistry.init();
        TabRegistry.init();
        SoundRegistry.init();
    }

    public static void commonInit() {
    }
}


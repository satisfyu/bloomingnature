package satisfy.wildernature.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import satisfy.wildernature.client.WilderNatureClient;

public class WilderNatureClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        WilderNatureClient.preInitClient();
    }
}

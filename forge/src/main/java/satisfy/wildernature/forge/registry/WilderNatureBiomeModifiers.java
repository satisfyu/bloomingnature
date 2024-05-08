package satisfy.wildernature.forge.registry;

import com.mojang.serialization.Codec;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import satisfy.wildernature.WilderNature;
import satisfy.wildernature.forge.world.AddAnimalsBiomeModifier;

public class WilderNatureBiomeModifiers {

    public static DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, WilderNature.MOD_ID);

    public static RegistryObject<Codec<AddAnimalsBiomeModifier>> ADD_ANIMALS_CODEC = BIOME_MODIFIER_SERIALIZERS.register("add_animals", () -> Codec.unit(AddAnimalsBiomeModifier::new));
}


package satisfyu.bloomingnature.forge.registry;

import com.mojang.serialization.Codec;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import satisfyu.bloomingnature.BloomingNature;
import satisfyu.bloomingnature.forge.world.AddAnimalsBiomeModifier;
import satisfyu.bloomingnature.registry.EntityRegistry;
import satisfyu.bloomingnature.registry.TagsRegistry;

public class BloomingNatureBiomeModifiers {

    public static DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, BloomingNature.MOD_ID);

    public static RegistryObject<Codec<AddAnimalsBiomeModifier>> ADD_ANIMALS_CODEC = BIOME_MODIFIER_SERIALIZERS.register("add_animals", () -> Codec.unit(AddAnimalsBiomeModifier::new));
}


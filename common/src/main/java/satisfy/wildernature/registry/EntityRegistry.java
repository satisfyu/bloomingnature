package satisfy.wildernature.registry;

import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import satisfy.wildernature.WilderNature;
import satisfy.wildernature.entity.*;
import satisfy.wildernature.util.WilderNatureIdentifier;

import java.util.function.Supplier;

public class EntityRegistry {
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(WilderNature.MOD_ID, Registries.ENTITY_TYPE);

    public static final RegistrySupplier<EntityType<RedWolfEntity>> RED_WOLF = create("red_wolf",
            () -> EntityType.Builder.of(RedWolfEntity::new, MobCategory.CREATURE)
                    .sized(0.4f, 1.5f)
                    .clientTrackingRange(10)
                    .build(new WilderNatureIdentifier("red_wolf").toString()));

    public static final RegistrySupplier<EntityType<PelicanEntity>> PELICAN = create("pelican",
            () -> EntityType.Builder.of(PelicanEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f)
                    .build(new WilderNatureIdentifier("pelican").toString())
    );

    public static final RegistrySupplier<EntityType<RaccoonEntity>> RACCOON = create("raccoon",
            () -> EntityType.Builder.of(RaccoonEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f)
                    .build(new WilderNatureIdentifier("raccoon").toString())
    );

    public static final RegistrySupplier<EntityType<MossySheepEntity>> MOSSY_SHEEP = create("mossy_sheep",
            () -> EntityType.Builder.of(MossySheepEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f)
                    .build(new ResourceLocation(WilderNature.MOD_ID, "mossy_sheep").toString())
    );

    public static final RegistrySupplier<EntityType<SquirrelEntity>> SQUIRREL = create("squirrel",
            () -> EntityType.Builder.of(SquirrelEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f)
                    .build(new WilderNatureIdentifier("raccoon").toString())
    );

    public static final RegistrySupplier<EntityType<MuddyPigEntity>> MUDDY_PIG = create("muddy_pig",
            () -> EntityType.Builder.of(MuddyPigEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f)
                    .build(new WilderNatureIdentifier("muddy_pig").toString())
    );

    public static final RegistrySupplier<EntityType<TurkeyEntity>> TURKEY = create("turkey",
            () -> EntityType.Builder.of(TurkeyEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f)
                    .build(new WilderNatureIdentifier("turkey").toString())
    );

    public static final RegistrySupplier<EntityType<DeerEntity>> DEER = create("deer",
            () -> EntityType.Builder.of(DeerEntity::new, MobCategory.CREATURE)
                    .build(new WilderNatureIdentifier("deer").toString())
    );

    public static final RegistrySupplier<EntityType<OwlEntity>> OWL = create("owl",
            () -> EntityType.Builder.of(OwlEntity::new, MobCategory.CREATURE)
                    .build(new WilderNatureIdentifier("owl").toString())
    );

    public static final RegistrySupplier<EntityType<BoarEntity>> BOAR = create("boar",
            () -> EntityType.Builder.of(BoarEntity::new, MobCategory.CREATURE)
                    .build(new WilderNatureIdentifier("boar").toString())
    );

    public static final RegistrySupplier<EntityType<BisonEntity>> BISON = create("bison",
            () -> EntityType.Builder.of(BisonEntity::new, MobCategory.CREATURE)
                    .build(new WilderNatureIdentifier("bison").toString())
    );


    public static <T extends EntityType<?>> RegistrySupplier<T> create(final String path, final Supplier<T> type) {
        return ENTITY_TYPES.register(new WilderNatureIdentifier(path), type);
    }

    public static void init() {
        WilderNature.LOGGER.debug("Registering Entities for " + WilderNature.MOD_ID);
        ENTITY_TYPES.register();
        EntityAttributeRegistry.register(MOSSY_SHEEP, SheepEntity::createMobAttributes);
        EntityAttributeRegistry.register(DEER, DeerEntity::createMobAttributes);
        EntityAttributeRegistry.register(PELICAN, PelicanEntity::createMobAttributes);
        EntityAttributeRegistry.register(RED_WOLF, RedWolfEntity::createMobAttributes);
        EntityAttributeRegistry.register(RACCOON, RaccoonEntity::createMobAttributes);
        EntityAttributeRegistry.register(SQUIRREL, SquirrelEntity::createMobAttributes);
        EntityAttributeRegistry.register(MUDDY_PIG, MuddyPigEntity::createMobAttributes);
        EntityAttributeRegistry.register(OWL, OwlEntity::createMobAttributes);
        EntityAttributeRegistry.register(BOAR, BoarEntity::createMobAttributes);
        EntityAttributeRegistry.register(BISON, BisonEntity::createMobAttributes);
        EntityAttributeRegistry.register(TURKEY, TurkeyEntity::createMobAttributes);
    }
}

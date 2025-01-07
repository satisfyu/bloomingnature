package net.satisfy.bloomingnature.core.registry;

import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.satisfy.bloomingnature.BloomingNature;
import net.satisfy.bloomingnature.core.block.entity.*;
import net.satisfy.bloomingnature.core.entity.TermiteEntity;
import net.satisfy.bloomingnature.core.entity.WanderingGardenerEntity;
import net.satisfy.bloomingnature.core.util.BloomingNatureIdentifier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;

public class EntityTypeRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BloomingNature.MOD_ID, Registries.BLOCK_ENTITY_TYPE);
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BloomingNature.MOD_ID, Registries.ENTITY_TYPE);
    private static final List<RegistrySupplier<Block>> SIGN_BLOCKS = new ArrayList<>();
    private static final List<RegistrySupplier<Block>> HANGING_SIGN_BLOCKS = new ArrayList<>();

    public static final RegistrySupplier<EntityType<WanderingGardenerEntity>> WANDERING_GARDENER = registerEntity("wandering_gardener", () -> EntityType.Builder.of(WanderingGardenerEntity::new, MobCategory.CREATURE).sized(0.6f, 1.95f).clientTrackingRange(10).build(new BloomingNatureIdentifier("wandering_gardener").toString()));
    public static final RegistrySupplier<EntityType<TermiteEntity>> TERMITE = registerEntity("termite", () -> EntityType.Builder.of(TermiteEntity::new, MobCategory.MONSTER).build(new BloomingNatureIdentifier("termite").toString()));

    public static void addSignBlocks(RegistrySupplier<Block> sign, RegistrySupplier<Block> wallSign) {
        SIGN_BLOCKS.add(sign);
        SIGN_BLOCKS.add(wallSign);
    }

    public static void addHangingSignBlocks(RegistrySupplier<Block> hangingSign, RegistrySupplier<Block> wallHangingSign) {
        HANGING_SIGN_BLOCKS.add(hangingSign);
        HANGING_SIGN_BLOCKS.add(wallHangingSign);
    }

    public static final RegistrySupplier<BlockEntityType<ModSignBlockEntity>> MOD_SIGN = BLOCK_ENTITY_TYPES.register("mod_sign", () -> BlockEntityType.Builder.of(ModSignBlockEntity::new, SIGN_BLOCKS.stream().map(RegistrySupplier::get).toArray(Block[]::new)).build(null));

    public static final RegistrySupplier<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN = BLOCK_ENTITY_TYPES.register("mod_hanging_sign", () -> BlockEntityType.Builder.of(ModHangingSignBlockEntity::new, HANGING_SIGN_BLOCKS.stream().map(RegistrySupplier::get).toArray(Block[]::new)).build(null));


    public static final RegistrySupplier<BlockEntityType<StorageBlockEntity>> STORAGE_ENTITY = registerBlockEntity("storage", () -> BlockEntityType.Builder.of(StorageBlockEntity::new, StorageTypeRegistry.registerBlocks(new HashSet<>()).toArray(new Block[0])).build(null));
    public static final RegistrySupplier<BlockEntityType<FlowerPotBigBlockEntity>> FLOWER_POT_BIG_ENTITY = registerBlockEntity("flower_pot_big", () -> BlockEntityType.Builder.of(FlowerPotBigBlockEntity::new, StorageTypeRegistry.registerBlocks(new HashSet<>()).toArray(new Block[0])).build(null));
    public static final RegistrySupplier<BlockEntityType<CompletionistBannerEntity>> BLOOMINGNATURE_BANNER = registerBlockEntity("bloomingnature_banner", () -> BlockEntityType.Builder.of(CompletionistBannerEntity::new, ObjectRegistry.BLOOMINGNATURE_STANDARD.get(), ObjectRegistry.BLOOMINGNATURE_WALL_STANDARD.get()).build(null));

    public static <T extends EntityType<?>> RegistrySupplier<T> registerEntity(final String path, final Supplier<T> type) {
        return ENTITY_TYPES.register(new BloomingNatureIdentifier(path), type);
    }

    private static <T extends BlockEntityType<?>> RegistrySupplier<T> registerBlockEntity(final String path, final Supplier<T> type) {
        return BLOCK_ENTITY_TYPES.register(new BloomingNatureIdentifier(path), type);
    }

    static void registerAttributes() {
        EntityAttributeRegistry.register(WANDERING_GARDENER, WanderingGardenerEntity::createMobAttributes);
        EntityAttributeRegistry.register(TERMITE, TermiteEntity::createMobAttributes);
    }

    public static void init() {
        ENTITY_TYPES.register();
        BLOCK_ENTITY_TYPES.register();
        registerAttributes();
    }
}

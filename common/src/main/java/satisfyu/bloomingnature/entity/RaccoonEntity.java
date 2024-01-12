package satisfyu.bloomingnature.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import satisfyu.bloomingnature.registry.EntityRegistry;
import satisfyu.bloomingnature.registry.SoundRegistry;

import java.util.Optional;

public class RaccoonEntity extends Fox {
    public RaccoonEntity(EntityType<? extends Fox> entityType, Level world) {
        super(entityType, world);
    }
    private static final Ingredient FOOD_ITEMS;
    private static final EntityDataAccessor<Integer> DATA_TYPE_ID;
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID;
    private static final int FLAG_SITTING = 1;
    public static final int FLAG_CROUCHING = 4;
    public static final int FLAG_INTERESTED = 8;
    public static final int FLAG_POUNCING = 16;
    private static final int FLAG_SLEEPING = 32;
    private static final int FLAG_FACEPLANTED = 64;
    private static final int FLAG_DEFENDING = 128;
    private int ticksSinceEaten;

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_TYPE_ID, 0);
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    public static AttributeSupplier.Builder createMobAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.20000001192092896).add(Attributes.MAX_HEALTH, 10.0).add(Attributes.ATTACK_DAMAGE, 1.5);
    }

    public void aiStep() {
        if (!this.level().isClientSide && this.isAlive() && this.isEffectiveAi()) {
            ++this.ticksSinceEaten;
            ItemStack itemStack = this.getItemBySlot(EquipmentSlot.MAINHAND);
            if (this.isFood(itemStack)) {
                if (this.ticksSinceEaten > 600) {
                    ItemStack itemStack2 = itemStack.finishUsingItem(this.level(), this);
                    if (!itemStack2.isEmpty()) {
                        this.setItemSlot(EquipmentSlot.MAINHAND, itemStack2);
                    }

                    this.ticksSinceEaten = 0;
                } else if (this.ticksSinceEaten > 560 && this.random.nextFloat() < 0.1F) {
                    this.playSound(this.getEatingSound(itemStack), 1.0F, 1.0F);
                    this.level().broadcastEntityEvent(this, (byte)45);
                }
            }

            LivingEntity livingEntity = this.getTarget();
            if (livingEntity == null || !livingEntity.isAlive()) {
                this.setIsCrouching(false);
                this.setIsInterested(false);
            }
        }

        if (this.isSleeping() || this.isImmobile()) {
            this.jumping = false;
            this.xxa = 0.0F;
            this.zza = 0.0F;
        }

        super.aiStep();
        if (this.isDefending() && this.random.nextFloat() < 0.05F) {
            this.playSound(SoundEvents.FOX_AGGRO, 1.0F, 1.0F);
        }
    }

    public float getTailAngle() {
        return (0.55F - (this.getMaxHealth() - this.getHealth()) * 0.02F) * 3.1415927F;
    }



    @Override
    protected float getStandingEyeHeight(Pose pose, EntityDimensions entityDimensions) {
        return this.isBaby() ? entityDimensions.height * 0.4F : entityDimensions.height * 0.5F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.RACCOON_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundRegistry.RACCOON_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.RACCOON_DEATH.get();
    }



    @Nullable
    public RaccoonEntity getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return EntityRegistry.RACCOON.get().create(serverLevel);
    }



    public boolean isSitting() {
        return this.getFlag(1);
    }

    public void setSitting(boolean bl) {
        this.setFlag(1, bl);
    }

    public boolean isFaceplanted() {
        return this.getFlag(64);
    }

    boolean isDefending() {
        return this.getFlag(128);
    }

    public boolean isSleeping() {
        return this.getFlag(32);
    }


    private void setFlag(int i, boolean bl) {
        if (bl) {
            this.entityData.set(DATA_FLAGS_ID, (byte)((Byte)this.entityData.get(DATA_FLAGS_ID) | i));
        } else {
            this.entityData.set(DATA_FLAGS_ID, (byte)((Byte)this.entityData.get(DATA_FLAGS_ID) & ~i));
        }
    }

    private boolean getFlag(int i) {
        return ((Byte)this.entityData.get(DATA_FLAGS_ID) & i) != 0;
    }


    @Override
    public boolean isFood(ItemStack itemStack) {
        return FOOD_ITEMS.test(itemStack);
    }

    static {
        DATA_TYPE_ID = SynchedEntityData.defineId(RaccoonEntity.class, EntityDataSerializers.INT);
        DATA_FLAGS_ID = SynchedEntityData.defineId(RaccoonEntity.class, EntityDataSerializers.BYTE);
        FOOD_ITEMS = Ingredient.of(Items.APPLE, Items.BEETROOT, Items.SWEET_BERRIES, Items.POTATO, Items.COOKED_COD, Items.COOKED_SALMON, Items.CARROT);
    }
}
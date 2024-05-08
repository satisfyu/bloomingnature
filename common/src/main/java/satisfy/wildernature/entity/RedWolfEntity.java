package satisfy.wildernature.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import satisfy.wildernature.registry.EntityRegistry;
import satisfy.wildernature.registry.SoundRegistry;

public class RedWolfEntity extends Wolf {
    public RedWolfEntity(EntityType<? extends Wolf> entityType, Level world) {
        super(entityType, world);
    }

    public static AttributeSupplier.Builder createMobAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.30000001192092896).add(Attributes.MAX_HEALTH, 12.0).add(Attributes.ATTACK_DAMAGE, 3.0);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if (this.isAngry()) {
            return SoundRegistry.RED_WOLF_AGGRO.get();
        } else if (this.random.nextInt(3) == 0) {
            return this.isTame() && this.getHealth() < 10.0F ? SoundEvents.WOLF_WHINE : SoundEvents.WOLF_PANT;
        } else {
            return SoundRegistry.RED_WOLF_AMBIENT.get();
        }
    }


    @Nullable
    public RedWolfEntity getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return EntityRegistry.RED_WOLF.get().create(serverLevel);
    }


    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundRegistry.RED_WOLF_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.RED_WOLF_DEATH.get();
    }

    protected float getSoundVolume() {
        return 0.3F;
    }


    public int getMaxHeadXRot() {
        return this.isInSittingPose() ? 16 : super.getMaxHeadXRot();
    }


    public float getTailAngle() {
        if (this.isAngry()) {
            return 1.5393804F;
        } else {
            return this.isTame() ? (0.55F - (this.getMaxHealth() - this.getHealth()) * 0.02F) * 3.1415927F : 0.62831855F;
        }
    }
}
package satisfy.bloomingnature.entity;


import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import satisfy.bloomingnature.registry.ObjectRegistry;

public class TermiteEntity extends Silverfish {
    public TermiteEntity(EntityType<? extends Silverfish> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createMobAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.19000001192092896).add(Attributes.MAX_HEALTH, 1.0).add(Attributes.ATTACK_DAMAGE, 1.1);
    }

    public static boolean checkSpawnRules(EntityType<OwlEntity> termiteEntityEntityType, ServerLevelAccessor level, MobSpawnType mobSpawnType, BlockPos pos, RandomSource randomSource)
    {
        BlockState state = level.getBlockState(pos.below());

        return ((state.is(ObjectRegistry.TERMITE_MOUND.get()))) && level.getRawBrightness(pos, 0) > 2;
    }
}
package mod.acgaming.dpt.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

import mod.acgaming.dpt.config.DPTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Potion.class)
public abstract class DPTInstantDamageMixin
{
    @ModifyArg(method = "affectEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;attackEntityFrom(Lnet/minecraft/util/DamageSource;F)Z"))
    private float dptInstantDamageAffectOld(float damageAmount)
    {
        return DPTConfig.instantDamageDisableExpScaling ? 0.0F : damageAmount;
    }

    @Inject(method = "affectEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;attackEntityFrom(Lnet/minecraft/util/DamageSource;F)Z", ordinal = 0))
    private void dptInstantDamageAffectDirectNew(Entity source, Entity indirectSource, EntityLivingBase entityLivingBase, int amplifier, double health, CallbackInfo ci)
    {
        if (!DPTConfig.instantDamageDisableExpScaling) return;
        int level = amplifier + 1;
        float newDamage = (float) (level * DPTConfig.instantDamageAmount);
        entityLivingBase.attackEntityFrom(DamageSource.MAGIC, newDamage);
    }

    @Inject(method = "affectEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;attackEntityFrom(Lnet/minecraft/util/DamageSource;F)Z", ordinal = 1))
    private void dptInstantDamageAffectIndirectNew(Entity source, Entity indirectSource, EntityLivingBase entityLivingBase, int amplifier, double health, CallbackInfo ci)
    {
        if (!DPTConfig.instantDamageDisableExpScaling) return;
        int level = amplifier + 1;
        float newDamage = (float) (level * DPTConfig.instantDamageAmount);
        entityLivingBase.attackEntityFrom(DamageSource.causeIndirectMagicDamage(source, indirectSource), newDamage);
    }

    @ModifyArg(method = "performEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;attackEntityFrom(Lnet/minecraft/util/DamageSource;F)Z", ordinal = 2))
    private float dptInstantDamagePerformOld(float damageAmount)
    {
        return DPTConfig.instantDamageDisableExpScaling ? 0.0F : damageAmount;
    }

    @Inject(method = "performEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;attackEntityFrom(Lnet/minecraft/util/DamageSource;F)Z", ordinal = 2))
    private void dptInstantDamagePerformNew(EntityLivingBase entityLivingBase, int amplifier, CallbackInfo ci)
    {
        if (!DPTConfig.instantDamageDisableExpScaling) return;
        int level = amplifier + 1;
        float newDamage = (float) (level * DPTConfig.instantDamageAmount);
        entityLivingBase.attackEntityFrom(DamageSource.MAGIC, newDamage);
    }
}

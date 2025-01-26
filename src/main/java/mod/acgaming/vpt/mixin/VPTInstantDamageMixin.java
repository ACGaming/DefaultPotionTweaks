package mod.acgaming.vpt.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

import mod.acgaming.vpt.config.VPTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Potion.class)
public abstract class VPTInstantDamageMixin
{
    @ModifyArg(method = "affectEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;attackEntityFrom(Lnet/minecraft/util/DamageSource;F)Z"))
    private float vptInstantDamageAffectOld(float damageAmount)
    {
        return VPTConfig.instantDamageDisableExpScaling ? 0.0F : damageAmount;
    }

    @Inject(method = "affectEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;attackEntityFrom(Lnet/minecraft/util/DamageSource;F)Z", ordinal = 0))
    private void vptInstantDamageAffectDirectNew(Entity source, Entity indirectSource, EntityLivingBase entityLivingBase, int amplifier, double health, CallbackInfo ci)
    {
        if (!VPTConfig.instantDamageDisableExpScaling) return;
        int level = amplifier + 1;
        float newDamage = (float) (level * VPTConfig.instantDamageAmount);
        entityLivingBase.attackEntityFrom(DamageSource.MAGIC, newDamage);
    }

    @Inject(method = "affectEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;attackEntityFrom(Lnet/minecraft/util/DamageSource;F)Z", ordinal = 1))
    private void vptInstantDamageAffectIndirectNew(Entity source, Entity indirectSource, EntityLivingBase entityLivingBase, int amplifier, double health, CallbackInfo ci)
    {
        if (!VPTConfig.instantDamageDisableExpScaling) return;
        int level = amplifier + 1;
        float newDamage = (float) (level * VPTConfig.instantDamageAmount);
        entityLivingBase.attackEntityFrom(DamageSource.causeIndirectMagicDamage(source, indirectSource), newDamage);
    }

    @ModifyArg(method = "performEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;attackEntityFrom(Lnet/minecraft/util/DamageSource;F)Z", ordinal = 2))
    private float vptInstantDamagePerformOld(float damageAmount)
    {
        return VPTConfig.instantDamageDisableExpScaling ? 0.0F : damageAmount;
    }

    @Inject(method = "performEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;attackEntityFrom(Lnet/minecraft/util/DamageSource;F)Z", ordinal = 2))
    private void vptInstantDamagePerformNew(EntityLivingBase entityLivingBase, int amplifier, CallbackInfo ci)
    {
        if (!VPTConfig.instantDamageDisableExpScaling) return;
        int level = amplifier + 1;
        float newDamage = (float) (level * VPTConfig.instantDamageAmount);
        entityLivingBase.attackEntityFrom(DamageSource.MAGIC, newDamage);
    }
}

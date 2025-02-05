package mod.acgaming.dpt.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

import mod.acgaming.dpt.config.DPTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Potion.class)
public abstract class DPTInstantHealthMixin
{
    @ModifyArg(method = "affectEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;heal(F)V"))
    private float dptInstantHealthAffectOld(float healAmount)
    {
        return DPTConfig.instantHealthDisableExpScaling ? 0.0F : healAmount;
    }

    @Inject(method = "affectEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;heal(F)V"))
    private void dptInstantHealthAffectNew(Entity source, Entity indirectSource, EntityLivingBase entityLivingBase, int amplifier, double health, CallbackInfo ci)
    {
        if (!DPTConfig.instantHealthDisableExpScaling) return;
        int level = amplifier + 1;
        float newHealth = (float) (level * DPTConfig.instantHealthAmount);
        entityLivingBase.heal(newHealth);
    }

    @ModifyArg(method = "performEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;heal(F)V", ordinal = 1))
    private float dptInstantHealthPerformOld(float healAmount)
    {
        return DPTConfig.instantHealthDisableExpScaling ? 0.0F : healAmount;
    }

    @Inject(method = "performEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;heal(F)V", ordinal = 1))
    private void dptInstantHealthPerformNew(EntityLivingBase entityLivingBase, int amplifier, CallbackInfo ci)
    {
        if (!DPTConfig.instantHealthDisableExpScaling) return;
        int level = amplifier + 1;
        float newHealth = (float) (level * DPTConfig.instantHealthAmount);
        entityLivingBase.heal(newHealth);
    }
}

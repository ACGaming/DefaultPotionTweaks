package mod.acgaming.vpt.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

import mod.acgaming.vpt.config.VPTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Potion.class)
public abstract class VPTInstantHealthMixin
{
    @ModifyArg(method = "affectEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;heal(F)V"))
    private float vptInstantHealthAffectOld(float healAmount)
    {
        return VPTConfig.instantHealthDisableExpScaling ? 0.0F : healAmount;
    }

    @Inject(method = "affectEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;heal(F)V"))
    private void vptInstantHealthAffectNew(Entity source, Entity indirectSource, EntityLivingBase entityLivingBase, int amplifier, double health, CallbackInfo ci)
    {
        if (!VPTConfig.instantHealthDisableExpScaling) return;
        int level = amplifier + 1;
        float newHealth = (float) (level * VPTConfig.instantHealthAmount);
        entityLivingBase.heal(newHealth);
    }

    @ModifyArg(method = "performEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;heal(F)V", ordinal = 1))
    private float vptInstantHealthPerformOld(float healAmount)
    {
        return VPTConfig.instantHealthDisableExpScaling ? 0.0F : healAmount;
    }

    @Inject(method = "performEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;heal(F)V", ordinal = 1))
    private void vptInstantHealthPerformNew(EntityLivingBase entityLivingBase, int amplifier, CallbackInfo ci)
    {
        if (!VPTConfig.instantHealthDisableExpScaling) return;
        int level = amplifier + 1;
        float newHealth = (float) (level * VPTConfig.instantHealthAmount);
        entityLivingBase.heal(newHealth);
    }
}

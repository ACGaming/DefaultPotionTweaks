package mod.acgaming.dpt.mixin;

import net.minecraft.potion.Potion;

import mod.acgaming.dpt.config.DPTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Potion.class)
public abstract class DPTStrengthFlatDamageMixin
{
    @ModifyConstant(method = "registerPotions", constant = @Constant(doubleValue = 3.0D))
    private static double dptStrengthFlatDamage(double constant)
    {
        return DPTConfig.strengthDisableFlatDamage ? DPTConfig.strengthAttackDamageFactor : constant;
    }

    @ModifyArgs(method = "registerPotions", at = @At(value = "INVOKE", target = "Lnet/minecraft/potion/Potion;registerPotionAttributeModifier(Lnet/minecraft/entity/ai/attributes/IAttribute;Ljava/lang/String;DI)Lnet/minecraft/potion/Potion;", ordinal = 4))
    private static void dptStrengthDamage(Args args)
    {
        if (DPTConfig.strengthDisableFlatDamage)
        {
            args.set(2, DPTConfig.strengthAttackDamageFactor);
            args.set(3, 2);
        }
    }
}

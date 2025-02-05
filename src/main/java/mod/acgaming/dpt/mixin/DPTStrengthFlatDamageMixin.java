package mod.acgaming.dpt.mixin;

import net.minecraft.potion.Potion;

import mod.acgaming.dpt.config.DPTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Potion.class)
public abstract class DPTStrengthFlatDamageMixin
{
    @ModifyConstant(method = "registerPotions", constant = @Constant(doubleValue = 3.0D))
    private static double dptStrengthFlatDamage(double constant)
    {
        return DPTConfig.strengthDisableFlatDamage ? 0.0D : constant;
    }
}

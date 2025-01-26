package mod.acgaming.vpt.mixin;

import net.minecraft.potion.Potion;

import mod.acgaming.vpt.config.VPTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Potion.class)
public abstract class VPTStrengthFlatDamageMixin
{
    @ModifyConstant(method = "registerPotions", constant = @Constant(doubleValue = 3.0D))
    private static double vptStrengthFlatDamage(double constant)
    {
        return VPTConfig.strengthDisableFlatDamage ? 0.0D : constant;
    }
}

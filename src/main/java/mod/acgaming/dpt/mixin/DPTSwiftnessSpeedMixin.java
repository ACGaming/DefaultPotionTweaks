package mod.acgaming.dpt.mixin;

import net.minecraft.potion.Potion;

import mod.acgaming.dpt.config.DPTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Potion.class)
public abstract class DPTSwiftnessSpeedMixin
{
    @ModifyConstant(method = "registerPotions", constant = @Constant(doubleValue = 0.20000000298023224D))
    private static double dptSwiftnessSpeed(double constant)
    {
        return DPTConfig.swiftnessSpeedIncrease;
    }
}

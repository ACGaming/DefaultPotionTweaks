package mod.acgaming.vpt.mixin;

import net.minecraft.potion.Potion;

import mod.acgaming.vpt.config.VPTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Potion.class)
public abstract class VPTSwiftnessSpeedMixin
{
    @ModifyConstant(method = "registerPotions", constant = @Constant(doubleValue = 0.20000000298023224D))
    private static double vptSwiftnessSpeed(double constant)
    {
        return VPTConfig.swiftnessSpeedIncrease;
    }
}

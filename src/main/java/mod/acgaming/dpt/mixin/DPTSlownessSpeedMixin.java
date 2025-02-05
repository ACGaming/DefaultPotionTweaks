package mod.acgaming.dpt.mixin;

import net.minecraft.potion.Potion;

import mod.acgaming.dpt.config.DPTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Potion.class)
public abstract class DPTSlownessSpeedMixin
{
    @ModifyConstant(method = "registerPotions", constant = @Constant(doubleValue = -0.15000000596046448D))
    private static double dptSlownessSpeed(double constant)
    {
        return -DPTConfig.slownessSpeedDecrease;
    }
}

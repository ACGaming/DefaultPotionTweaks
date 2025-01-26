package mod.acgaming.vpt.mixin;

import net.minecraft.potion.Potion;

import mod.acgaming.vpt.config.VPTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Potion.class)
public abstract class VPTSlownessSpeedMixin
{
    @ModifyConstant(method = "registerPotions", constant = @Constant(doubleValue = -0.15000000596046448D))
    private static double vptSlownessSpeed(double constant)
    {
        return -VPTConfig.slownessSpeedDecrease;
    }
}

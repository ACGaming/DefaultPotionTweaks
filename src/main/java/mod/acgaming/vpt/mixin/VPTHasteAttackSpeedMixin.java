package mod.acgaming.vpt.mixin;

import net.minecraft.potion.Potion;

import mod.acgaming.vpt.config.VPTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Potion.class)
public abstract class VPTHasteAttackSpeedMixin
{
    @ModifyConstant(method = "registerPotions", constant = @Constant(doubleValue = 0.10000000149011612D))
    private static double vptHasteAttackSpeed(double constant)
    {
        return VPTConfig.hasteAttackSpeed;
    }
}

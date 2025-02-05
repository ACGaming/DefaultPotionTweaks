package mod.acgaming.dpt.mixin;

import net.minecraft.potion.Potion;

import mod.acgaming.dpt.config.DPTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Potion.class)
public abstract class DPTHasteAttackSpeedMixin
{
    @ModifyConstant(method = "registerPotions", constant = @Constant(doubleValue = 0.10000000149011612D))
    private static double dptHasteAttackSpeed(double constant)
    {
        return DPTConfig.hasteAttackSpeed;
    }
}

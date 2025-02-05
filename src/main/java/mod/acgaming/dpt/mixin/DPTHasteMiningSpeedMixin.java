package mod.acgaming.dpt.mixin;

import net.minecraft.entity.player.EntityPlayer;

import mod.acgaming.dpt.config.DPTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityPlayer.class)
public abstract class DPTHasteMiningSpeedMixin
{
    @ModifyConstant(method = "getDigSpeed(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/math/BlockPos;)F", constant = @Constant(floatValue = 0.2F), remap = false)
    private float dptHasteMiningSpeed(float constant)
    {
        return (float) DPTConfig.hasteMiningSpeedFactor;
    }
}

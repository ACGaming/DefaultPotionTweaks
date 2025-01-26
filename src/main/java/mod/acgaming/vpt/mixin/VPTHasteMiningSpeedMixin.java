package mod.acgaming.vpt.mixin;

import net.minecraft.entity.player.EntityPlayer;

import mod.acgaming.vpt.config.VPTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityPlayer.class)
public abstract class VPTHasteMiningSpeedMixin
{
    @ModifyConstant(method = "getDigSpeed(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/math/BlockPos;)F", constant = @Constant(floatValue = 0.2F), remap = false)
    private float vptHasteMiningSpeed(float constant)
    {
        return (float) VPTConfig.hasteMiningSpeedFactor;
    }
}

package mod.acgaming.vpt.event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import mod.acgaming.vpt.VanillaPotionTweaks;
import mod.acgaming.vpt.config.VPTConfig;

@Mod.EventBusSubscriber(modid = VanillaPotionTweaks.MOD_ID)
public class VPTStrengthDamageFactor
{
    @SubscribeEvent
    public static void vptStrengthDamageFactor(LivingDamageEvent event)
    {
        if (VPTConfig.strengthDisableFlatDamage && event.getSource().getTrueSource() instanceof EntityLivingBase)
        {
            EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
            PotionEffect strength = attacker.getActivePotionEffect(MobEffects.STRENGTH);
            if (strength != null)
            {
                float damage = event.getAmount();
                int level = strength.getAmplifier() + 1;
                damage *= level * (float) VPTConfig.strengthAttackDamageFactor;
                event.setAmount(damage);
            }
        }
    }
}

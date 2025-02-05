package mod.acgaming.dpt.event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import mod.acgaming.dpt.DefaultPotionTweaks;
import mod.acgaming.dpt.config.DPTConfig;

@Mod.EventBusSubscriber(modid = DefaultPotionTweaks.MOD_ID)
public class DPTStrengthDamageFactor
{
    @SubscribeEvent
    public static void dptStrengthDamageFactor(LivingDamageEvent event)
    {
        if (DPTConfig.strengthDisableFlatDamage && event.getSource().getTrueSource() instanceof EntityLivingBase)
        {
            EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
            PotionEffect strength = attacker.getActivePotionEffect(MobEffects.STRENGTH);
            if (strength != null)
            {
                float damage = event.getAmount();
                int level = strength.getAmplifier() + 1;
                damage *= level * (float) DPTConfig.strengthAttackDamageFactor;
                event.setAmount(damage);
            }
        }
    }
}

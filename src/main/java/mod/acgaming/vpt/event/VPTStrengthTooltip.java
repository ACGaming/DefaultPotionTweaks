package mod.acgaming.vpt.event;

import java.util.List;

import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import mod.acgaming.vpt.VanillaPotionTweaks;
import mod.acgaming.vpt.config.VPTConfig;

@Mod.EventBusSubscriber(modid = VanillaPotionTweaks.MOD_ID, value = Side.CLIENT)
public class VPTStrengthTooltip
{
    @SubscribeEvent
    public static void vptStrengthTooltip(ItemTooltipEvent event)
    {
        if (VPTConfig.strengthDisableFlatDamage)
        {
            List<PotionEffect> effectList = PotionUtils.getEffectsFromStack(event.getItemStack());
            if (!effectList.isEmpty())
            {
                for (PotionEffect effect : effectList)
                {
                    if (effect.getPotion() == MobEffects.STRENGTH)
                    {
                        for (int i = 0; i < event.getToolTip().size(); i++)
                        {
                            if (event.getToolTip().get(i).contains(I18n.translateToLocal("potion.whenDrank")))
                            {
                                int level = effect.getAmplifier() + 1;
                                double factor = level * (VPTConfig.strengthAttackDamageFactor - 1);
                                if (factor > 0.0D)
                                {
                                    event.getToolTip().add(i + 1, TextFormatting.BLUE + I18n.translateToLocalFormatted("attribute.modifier.plus." + 0, ItemStack.DECIMALFORMAT.format(factor * 100.0D) + "%", I18n.translateToLocal("attribute.name.generic.attackDamage")));
                                }
                                else if (factor < 0.0D)
                                {
                                    event.getToolTip().add(i + 1, TextFormatting.RED + I18n.translateToLocalFormatted("attribute.modifier.take." + 0, ItemStack.DECIMALFORMAT.format(factor * -100.0D) + "%", I18n.translateToLocal("attribute.name.generic.attackDamage")));
                                }
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}

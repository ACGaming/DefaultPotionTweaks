package mod.acgaming.dpt.potion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import mod.acgaming.dpt.DefaultPotionTweaks;
import mod.acgaming.dpt.config.DPTConfig;

public class DPTMasteryPotion extends Potion
{
    public static final ResourceLocation MASTERY_ICON = new ResourceLocation(DefaultPotionTweaks.MOD_ID, "textures/gui/mastery_icon.png");

    public DPTMasteryPotion()
    {
        super(false, 14270531);
        this.setPotionName("effect." + DefaultPotionTweaks.MOD_ID + "." + "mastery");
        this.setRegistryName(DefaultPotionTweaks.MOD_ID, "mastery");
        this.setEffectiveness(1.5D);
        this.setBeneficial();
        this.registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED, "2d8d4ea8-5d87-4b4d-ac79-c80d3e0186e4", DPTConfig.masteryAttackSpeed, 2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderInventoryEffect(PotionEffect effect, Gui gui, int x, int y, float z)
    {
        Minecraft.getMinecraft().renderEngine.bindTexture(MASTERY_ICON);
        Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderHUDEffect(PotionEffect effect, Gui gui, int x, int y, float z, float alpha)
    {
        Minecraft.getMinecraft().renderEngine.bindTexture(MASTERY_ICON);
        Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
    }
}

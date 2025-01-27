package mod.acgaming.vpt.potion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import mod.acgaming.vpt.VanillaPotionTweaks;
import mod.acgaming.vpt.config.VPTConfig;

public class VPTMasteryPotion extends Potion
{
    public static final ResourceLocation MASTERY_ICON = new ResourceLocation(VanillaPotionTweaks.MOD_ID, "textures/gui/mastery_icon.png");

    public VPTMasteryPotion()
    {
        super(false, 14270531);
        this.setPotionName("effect." + VanillaPotionTweaks.MOD_ID + "." + "mastery");
        this.setRegistryName(VanillaPotionTweaks.MOD_ID, "mastery");
        this.setEffectiveness(1.5D);
        this.setBeneficial();
        this.registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED, "2d8d4ea8-5d87-4b4d-ac79-c80d3e0186e4", VPTConfig.masteryAttackSpeed, 2);
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

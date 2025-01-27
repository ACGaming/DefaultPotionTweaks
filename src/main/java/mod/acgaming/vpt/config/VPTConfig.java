package mod.acgaming.vpt.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.cleanroommc.configanytime.ConfigAnytime;
import mod.acgaming.vpt.VanillaPotionTweaks;

@Config(modid = VanillaPotionTweaks.MOD_ID, name = "VanillaPotionTweaks")
public class VPTConfig
{
    @Config.RequiresMcRestart
    @Config.Name("Haste: Attack Speed Increase")
    @Config.Comment("Sets the attack speed increase per level when a Haste potion effect is active")
    public static double hasteAttackSpeed = 0.1D;

    @Config.Name("Haste: Mining Speed Factor")
    @Config.Comment("Sets the factor of increasing mining speed per level when a Haste potion effect is active")
    public static double hasteMiningSpeedFactor = 0.2D;

    @Config.Name("Instant Damage: Disable Exponential Scaling")
    @Config.Comment("Disables the exponential damage increase when an Instant Damage potion effect is active")
    public static boolean instantDamageDisableExpScaling = true;

    @Config.Name("Instant Damage: Linear Damage")
    @Config.Comment("Sets the amount of damage per level when an Instant Damage potion effect is active")
    public static double instantDamageAmount = 2.0D;

    @Config.Name("Instant Health: Disable Exponential Scaling")
    @Config.Comment("Disables the exponential health increase when an Instant Health potion effect is active")
    public static boolean instantHealthDisableExpScaling = true;

    @Config.Name("Instant Health: Linear Health")
    @Config.Comment("Sets the amount of health per level when an Instant Health potion effect is active")
    public static double instantHealthAmount = 2.0D;

    @Config.RequiresMcRestart
    @Config.Name("Mastery: Attack Speed Increase")
    @Config.Comment("Sets the attack speed increase per level when a Mastery potion effect is active")
    public static double masteryAttackSpeed = 0.1D;

    @Config.RequiresMcRestart
    @Config.Name("Slowness: Speed Decrease")
    @Config.Comment("Sets the speed decrease per level when a Slowness potion effect is active")
    public static double slownessSpeedDecrease = 0.15D;

    @Config.RequiresMcRestart
    @Config.Name("Strength: Disable Flat Damage Increase")
    @Config.Comment("Disables the flat damage increase when a Strength potion effect is active")
    public static boolean strengthDisableFlatDamage = true;

    @Config.Name("Strength: Attack Damage Factor")
    @Config.Comment("Sets the factor of increasing attack damage per level when a Strength potion effect is active")
    public static double strengthAttackDamageFactor = 1.2D;

    @Config.RequiresMcRestart
    @Config.Name("Swiftness: Speed Increase")
    @Config.Comment("Sets the speed increase per level when a Swiftness potion effect is active")
    public static double swiftnessSpeedIncrease = 0.2D;

    static
    {
        ConfigAnytime.register(VPTConfig.class);
    }

    @Mod.EventBusSubscriber(modid = VanillaPotionTweaks.MOD_ID)
    public static class EventHandler
    {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
        {
            if (event.getModID().equals(VanillaPotionTweaks.MOD_ID))
            {
                ConfigManager.sync(VanillaPotionTweaks.MOD_ID, Config.Type.INSTANCE);
            }
        }
    }
}

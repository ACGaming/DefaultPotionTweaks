package mod.acgaming.vpt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import mod.acgaming.vpt.potion.VPTMasteryPotion;

@Mod.EventBusSubscriber
@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION, dependencies = "required-after:mixinbooter;required-after:configanytime")
public class VanillaPotionTweaks
{
    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    @SubscribeEvent
    public static void registerPotion(RegistryEvent.Register<Potion> event)
    {
        event.getRegistry().register(new VPTMasteryPotion());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        LOGGER.info(Tags.MOD_NAME + " initializing...");
    }
}

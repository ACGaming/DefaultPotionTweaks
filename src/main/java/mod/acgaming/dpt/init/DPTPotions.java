package mod.acgaming.dpt.init;

import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import mod.acgaming.dpt.potion.DPTMasteryPotion;

@Mod.EventBusSubscriber
public class DPTPotions
{
    @SubscribeEvent
    public static void registerPotion(RegistryEvent.Register<Potion> event)
    {
        event.getRegistry().register(new DPTMasteryPotion());
    }
}

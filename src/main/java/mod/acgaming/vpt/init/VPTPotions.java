package mod.acgaming.vpt.init;

import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import mod.acgaming.vpt.potion.VPTMasteryPotion;

@Mod.EventBusSubscriber
public class VPTPotions
{
    @SubscribeEvent
    public static void registerPotion(RegistryEvent.Register<Potion> event)
    {
        event.getRegistry().register(new VPTMasteryPotion());
    }
}

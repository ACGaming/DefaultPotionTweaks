package mod.acgaming.dpt.core;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import mod.acgaming.dpt.DefaultPotionTweaks;
import zone.rong.mixinbooter.IEarlyMixinLoader;

@IFMLLoadingPlugin.Name("DPTCore")
@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
@IFMLLoadingPlugin.SortingIndex(Integer.MIN_VALUE)
public class DPTLoadingPlugin implements IFMLLoadingPlugin, IEarlyMixinLoader
{
    static
    {
        DefaultPotionTweaks.LOGGER.info(DefaultPotionTweaks.MOD_NAME + " Core initializing...");
    }

    @Override
    public String[] getASMTransformerClass()
    {
        return new String[0];
    }

    @Override
    public String getModContainerClass()
    {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data)
    {

    }

    @Override
    public String getAccessTransformerClass()
    {
        return null;
    }

    @Override
    public List<String> getMixinConfigs()
    {
        return Collections.singletonList("mixins.dpt.json");
    }
}

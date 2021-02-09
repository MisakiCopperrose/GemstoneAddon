package terfret.gemstoneaddon;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terfret.gemstoneaddon.core.init.ItemInit;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GemstoneAddon.MOD_ID)
public class GemstoneAddon {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    //Mod id that's publicly available in all files for linking in registers etc
    public static final String MOD_ID = "gemstone-addon";
    //Creative item tab
    public static final ItemGroup GEMSTONE_ADDON_GROUP = new GemstoneGroupTable("gemstone_addon_tab");

    public GemstoneAddon() {
        // Use bus var for mod loading
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        // Register the items to the mod event bus
        ItemInit.ITEMS.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    public static class GemstoneGroupTable extends ItemGroup {

        public GemstoneGroupTable(String label){
            super(label);
        }

        @Override
        public ItemStack createIcon(){
            return ItemInit.RUBY.get().getDefaultInstance();
        }
    }

}

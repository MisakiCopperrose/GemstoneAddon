package com.tertfret.gemstone_addon.core;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

import com.tertfret.gemstone_addon.core.registry.GAArmor;
import com.tertfret.gemstone_addon.core.registry.GABlocks;
import com.tertfret.gemstone_addon.core.registry.GAItems;
import com.tertfret.gemstone_addon.core.registry.GATools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("gemstone_addon")
public final class GemstoneAddon {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "gemstone_addon";

    public GemstoneAddon() {
        // Registry handlers
        GAArmor.init();
        GABlocks.init();
        GAItems.init();
        GATools.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        LOGGER.debug("Registry done!");
    }

    public static final ItemGroup TAB = new ItemGroup("gemstoneAddonTab") {

        // Creative menu tab
        @Override
        public ItemStack createIcon() {
            return new ItemStack(GAItems.RUBY.get());
        }
    };
}

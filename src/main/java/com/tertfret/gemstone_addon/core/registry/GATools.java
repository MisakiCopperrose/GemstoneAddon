package com.tertfret.gemstone_addon.core.registry;

import com.tertfret.gemstone_addon.common.tools.AmethystItemTier;
import com.tertfret.gemstone_addon.common.tools.TopazItemTier;
import com.tertfret.gemstone_addon.core.GemstoneAddon;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GATools {

        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
                        GemstoneAddon.MOD_ID);

        public static void init() {
                ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }

        // Topaz tools
        // Base damage is 1, anything added here is added up with the mod item tier
        // damage, so in this case 1 (base) + 3 (tier) + 2 (added in RH) = 6 damage
        public static final RegistryObject<SwordItem> TOPAZ_SWORD = ITEMS.register("topaz_sword", () ->
        // First thing defines item tier, then extra damage, then attack speed, last is
        // creative tab
        new SwordItem(TopazItemTier.TOPAZ, 2, -2.4f, new Item.Properties().group(GemstoneAddon.TAB)));

        public static final RegistryObject<PickaxeItem> TOPAZ_PICKAXE = ITEMS.register("topaz_pickaxe",
                        () -> new PickaxeItem(TopazItemTier.TOPAZ, 0, -2.8f,
                                        new Item.Properties().group(GemstoneAddon.TAB)));

        public static final RegistryObject<AxeItem> TOPAZ_AXE = ITEMS.register("topaz_axe",
                        () -> new AxeItem(TopazItemTier.TOPAZ, 5, -3.1f,
                                        new Item.Properties().group(GemstoneAddon.TAB)));

        public static final RegistryObject<HoeItem> TOPAZ_HOE = ITEMS.register("topaz_hoe",
                        () -> new HoeItem(TopazItemTier.TOPAZ, -3, -1.0f,
                                        new Item.Properties().group(GemstoneAddon.TAB)));

        public static final RegistryObject<ShovelItem> TOPAZ_SHOVEL = ITEMS.register("topaz_shovel",
                        () -> new ShovelItem(TopazItemTier.TOPAZ, 0, -3.0f,
                                        new Item.Properties().group(GemstoneAddon.TAB)));

        // Amethyst tools
        public static final RegistryObject<SwordItem> AMETHYST_SWORD = ITEMS.register("amethyst_sword",
                        () -> new SwordItem(AmethystItemTier.AMETHYST, 2, -2.2f,
                                        new Item.Properties().group(GemstoneAddon.TAB)));

        public static final RegistryObject<PickaxeItem> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe",
                        () -> new PickaxeItem(AmethystItemTier.AMETHYST, 0, -2.8f,
                                        new Item.Properties().group(GemstoneAddon.TAB)));

        public static final RegistryObject<AxeItem> AMETHYST_AXE = ITEMS.register("amethyst_axe",
                        () -> new AxeItem(AmethystItemTier.AMETHYST, 5, -3.1f,
                                        new Item.Properties().group(GemstoneAddon.TAB)));

        public static final RegistryObject<HoeItem> AMETHYST_HOE = ITEMS.register("amethyst_hoe",
                        () -> new HoeItem(AmethystItemTier.AMETHYST, -3, -1.0f,
                                        new Item.Properties().group(GemstoneAddon.TAB)));

        public static final RegistryObject<ShovelItem> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel",
                        () -> new ShovelItem(AmethystItemTier.AMETHYST, 0, -3.0f,
                                        new Item.Properties().group(GemstoneAddon.TAB)));

}
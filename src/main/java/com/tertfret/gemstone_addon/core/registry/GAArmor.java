package com.tertfret.gemstone_addon.core.registry;

import com.tertfret.gemstone_addon.common.armor.RubyArmorMaterial;
import com.tertfret.gemstone_addon.common.armor.TopazArmorMaterial;
import com.tertfret.gemstone_addon.core.GemstoneAddon;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GAArmor {

        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
                        GemstoneAddon.MOD_ID);

        public static void init() {
                ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }

        // Ruby armor
        public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet", () ->
        // First input is the material, slot type in inventory, and the last the
        // creative tab
        new ArmorItem(RubyArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(GemstoneAddon.TAB)));

        public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
                        () -> new ArmorItem(RubyArmorMaterial.RUBY, EquipmentSlotType.CHEST,
                                        new Item.Properties().group(GemstoneAddon.TAB)));

        public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
                        () -> new ArmorItem(RubyArmorMaterial.RUBY, EquipmentSlotType.LEGS,
                                        new Item.Properties().group(GemstoneAddon.TAB)));

        public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots",
                        () -> new ArmorItem(RubyArmorMaterial.RUBY, EquipmentSlotType.FEET,
                                        new Item.Properties().group(GemstoneAddon.TAB)));

        // Topaz armor
        public static final RegistryObject<ArmorItem> TOPAZ_HELMET = ITEMS.register("topaz_helmet",
                        () -> new ArmorItem(TopazArmorMaterial.TOPAZ, EquipmentSlotType.HEAD,
                                        new Item.Properties().group(GemstoneAddon.TAB)));

        public static final RegistryObject<ArmorItem> TOPAZ_CHESTPLATE = ITEMS.register("topaz_chestplate",
                        () -> new ArmorItem(TopazArmorMaterial.TOPAZ, EquipmentSlotType.CHEST,
                                        new Item.Properties().group(GemstoneAddon.TAB)));

        public static final RegistryObject<ArmorItem> TOPAZ_LEGGINGS = ITEMS.register("topaz_leggings",
                        () -> new ArmorItem(TopazArmorMaterial.TOPAZ, EquipmentSlotType.LEGS,
                                        new Item.Properties().group(GemstoneAddon.TAB)));

        public static final RegistryObject<ArmorItem> TOPAZ_BOOTS = ITEMS.register("topaz_boots",
                        () -> new ArmorItem(TopazArmorMaterial.TOPAZ, EquipmentSlotType.FEET,
                                        new Item.Properties().group(GemstoneAddon.TAB)));
}
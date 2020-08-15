package com.tertfret.gemstone_addon.core.registry;

import com.tertfret.gemstone_addon.core.GemstoneAddon;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GAItems {
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GemstoneAddon.MOD_ID);
    
    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Gemstones themselves
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz", ItemBase::new);
    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", ItemBase::new);

    //Wearables
    public static final RegistryObject<Item> RUBY_HEADBAND = ITEMS.register("ruby_headband", ItemBase::new);
    public static final RegistryObject<Item> TOPAZ_BRACELET = ITEMS.register("topaz_bracelet", ItemBase::new);
    public static final RegistryObject<Item> AMETHYST_Amulet = ITEMS.register("amethyst_amulet", ItemBase::new);

}
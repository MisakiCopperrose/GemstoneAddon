package com.tertfret.gemstone_addon.core.registry;

import com.tertfret.gemstone_addon.common.blocks.AmethystBlock;
import com.tertfret.gemstone_addon.common.blocks.GemstoneWorkbench;
import com.tertfret.gemstone_addon.common.blocks.RubyBlock;
import com.tertfret.gemstone_addon.common.blocks.RubyOre;
import com.tertfret.gemstone_addon.common.blocks.TopazBlock;
import com.tertfret.gemstone_addon.core.GemstoneAddon;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GABlocks {

        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
                        GemstoneAddon.MOD_ID);
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
                        GemstoneAddon.MOD_ID);

        public static void init() {
                BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
                ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }

        // Gemstone blocks
        public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
        public static final RegistryObject<Block> TOPAZ_BLOCK = BLOCKS.register("topaz_block", TopazBlock::new);
        public static final RegistryObject<Block> AMETHYST_BLOCK = BLOCKS.register("amethyst_block",
                        AmethystBlock::new);

        // Interactive blocks
        public static final RegistryObject<Block> GEMSTONE_WORKBENCH = BLOCKS.register("gemstone_workbench",
                        GemstoneWorkbench::new);

        // Ores
        public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", RubyOre::new);

        // Block items
        public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block",
                        () -> new BlockItemBase(RUBY_BLOCK.get()));
        public static final RegistryObject<Item> TOPAZ_BLOCK_ITEM = ITEMS.register("topaz_block",
                        () -> new BlockItemBase(TOPAZ_BLOCK.get()));
        public static final RegistryObject<Item> AMETHYST_BLOCK_ITEM = ITEMS.register("amethyst_block",
                        () -> new BlockItemBase(AMETHYST_BLOCK.get()));

        public static final RegistryObject<Item> GEMSTONE_WORKBENCH_ITEM = ITEMS.register("gemstone_workbench",
                        () -> new BlockItemBase(GEMSTONE_WORKBENCH.get()));
}
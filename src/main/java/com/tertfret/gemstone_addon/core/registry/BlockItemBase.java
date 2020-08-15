package com.tertfret.gemstone_addon.core.registry;

import com.tertfret.gemstone_addon.core.GemstoneAddon;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(GemstoneAddon.TAB));
    }

}
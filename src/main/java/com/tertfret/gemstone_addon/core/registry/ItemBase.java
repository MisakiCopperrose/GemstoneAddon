package com.tertfret.gemstone_addon.core.registry;

import com.tertfret.gemstone_addon.core.GemstoneAddon;

import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(GemstoneAddon.TAB));
    }

}
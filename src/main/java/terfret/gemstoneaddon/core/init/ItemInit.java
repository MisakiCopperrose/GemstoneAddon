package terfret.gemstoneaddon.core.init;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import terfret.gemstoneaddon.GemstoneAddon;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GemstoneAddon.MOD_ID);
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby_item", () -> new Item(new Item.Properties()));
}

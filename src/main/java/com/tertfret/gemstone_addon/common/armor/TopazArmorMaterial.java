package com.tertfret.gemstone_addon.common.armor;

import java.util.function.Supplier;

import com.tertfret.gemstone_addon.core.GemstoneAddon;
import com.tertfret.gemstone_addon.core.registry.GAItems;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum TopazArmorMaterial implements IArmorMaterial {

    // Will it make refer to topaz_layer_1 and ~2, then durability, protection
    // value, enchantability, equip sound, toughness and the repair material
    TOPAZ(GemstoneAddon.MOD_ID + ":topaz", 25, new int[] { 2, 5, 6, 2 }, 12, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0f,
            () -> {
                return Ingredient.fromItems(GAItems.TOPAZ.get());
            }, 0.0f);

    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 11, 16, 15, 13 };
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;
    private final float knockbackResistance;

    TopazArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability,
            SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial, float knockbackResistance) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        // TODO Auto-generated method stub
        return damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        // TODO Auto-generated method stub
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * maxDamageFactor;
    }

    @Override
    public int getEnchantability() {
        // TODO Auto-generated method stub
        return enchantability;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    @Override
    public Ingredient getRepairMaterial() {
        // TODO Auto-generated method stub
        return repairMaterial.get();
    }

    @Override
    public SoundEvent getSoundEvent() {
        // TODO Auto-generated method stub
        return soundEvent;
    }

    @Override
    public float getToughness() {
        // TODO Auto-generated method stub
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }

}
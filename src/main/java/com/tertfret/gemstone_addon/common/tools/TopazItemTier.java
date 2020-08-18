package com.tertfret.gemstone_addon.common.tools;

import java.util.function.Supplier;

import com.tertfret.gemstone_addon.core.registry.GAItems;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum TopazItemTier implements IItemTier {

    // These are all base values in order: harvest level, durability, efficiency, attack damage, enchantability and repair material
    TOPAZ(3, 650, 6.0f, 3.0f, 12, () -> {
        return Ingredient.fromItems(GAItems.TOPAZ.get());
	});

    private final int harvestlevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    TopazItemTier(int harvestlevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestlevel = harvestlevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

	@Override
	public float getAttackDamage() {
		return attackDamage;
	}

	@Override
	public float getEfficiency() {
		return efficiency;
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public int getHarvestLevel() {
		return harvestlevel;
	}

	@Override
	public int getMaxUses() {
		return maxUses;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return repairMaterial.get();
	}

    
}
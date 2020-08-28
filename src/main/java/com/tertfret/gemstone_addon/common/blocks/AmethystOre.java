package com.tertfret.gemstone_addon.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class AmethystOre extends OreBlock {

    public AmethystOre() {
        super(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 4.0f).sound(SoundType.STONE)
                .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool());
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        // TODO Auto-generated method stub
        return (silktouch == 0) ? MathHelper.nextInt(this.RANDOM, 3, 7) : 0;
    }

}
package com.tertfret.gemstone_addon.common.world.gen;

import com.tertfret.gemstone_addon.core.GemstoneAddon;
import com.tertfret.gemstone_addon.core.registry.GABlocks;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = GemstoneAddon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreGen {

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {

            //Nether Generation
            if (biome.getCategory() == Biome.Category.NETHER) {

            } 
            //End Generation
            else if (biome.getCategory() == Biome.Category.THEEND) {

            } 
            //Overworld Generation
            else {
                oreGen(biome, 20, 1, 2, 48, OreFeatureConfig.FillerBlockType.NATURAL_STONE, GABlocks.RUBY_ORE.get().getDefaultState(), 10);
                oreGen(biome, 20, 1, 2, 48, OreFeatureConfig.FillerBlockType.NATURAL_STONE, GABlocks.TOPAZ_ORE.get().getDefaultState(), 10);
                oreGen(biome, 20, 1, 2, 48, OreFeatureConfig.FillerBlockType.NATURAL_STONE, GABlocks.AMETHYST_ORE.get().getDefaultState(), 10);
            }
            
        }
    }

    private static void oreGen(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockState, int size) {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockState, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));

    }
}
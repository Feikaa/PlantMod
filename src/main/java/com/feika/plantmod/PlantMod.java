package com.feika.plantmod;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

import java.util.function.Predicate;

public class PlantMod implements ModInitializer {

    // Mod ID
    public static final String MOD_ID = "plantmod";

    public static ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "item_group"), () -> new ItemStack(ModItems.WHITE_BERRIES));

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();

        // Generation
        registerGeneration("minecraft:forest,minecraft:wooded_hills,minecraft:jungle,minecraft:jungle_hills,minecraft:savanna,minecraft:savanna_plateau", ModBlocks.WHITE_BERRY_BUSH, 16, "whiteberry");
        registerGeneration("minecraft:forest,minecraft:birch_forest,minecraft:tall_birch_forest,minecraft:taiga", ModBlocks.YELLOW_BERRY_BUSH, 16, "yellowberry");
        registerGeneration("minecraft:forest,minecraft:plains,minecraft:sunflower_plains,minecraft:savanna,minecraft:jungle,minecraft:flower_forest", ModBlocks.PURPLE_BERRY_BUSH, 16, "purpleberry");
        registerGeneration("minecraft:plains,minecraft:jungle_edge,minecraft:sunflower_plains,minecraft:savanna", ModBlocks.BLUE_BERRY_BUSH, 16, "blueberry");
        registerGeneration("minecraft:taiga,minecraft:taiga_hills,minecraft:taiga_mountains,minecraft:jungle,minecraft:jungle_hills,minecraft:plains", ModBlocks.RED_BERRY_BUSH, 16, "redberry");
    }

    // Places fully grown berry bushes in specified biomes
    private void registerGeneration(String biomes, Block block, int chance, String name) {
        String[] biomeList = biomes.split(",");
        BlockState blockState = block.getDefaultState().with(SweetBerryBushBlock.AGE, 3);
        RandomPatchFeatureConfig BUSH_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(blockState), SimpleBlockPlacer.INSTANCE)).tries(32)
                .spreadX(2).spreadY(2).spreadZ(2).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK)).build();
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, name + "_generation"), Feature.RANDOM_PATCH.configure(BUSH_CONFIG).applyChance(chance * 2));

        for (int i = 0; i < biomeList.length; i++) {
            Predicate<BiomeSelectionContext> biomeSelector = BiomeSelectors.includeByKey(RegistryKey.of(Registry.BIOME_KEY, new Identifier(biomeList[i])));
            BiomeModifications.addFeature(biomeSelector, GenerationStep.Feature.VEGETAL_DECORATION, RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MOD_ID, name + "_generation")));
        }
    }
}

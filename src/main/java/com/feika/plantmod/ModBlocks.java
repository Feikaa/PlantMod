package com.feika.plantmod;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    // Berry bushes
    public static final Block WHITE_BERRY_BUSH = new WhiteBerryBush();
    public static final Block YELLOW_BERRY_BUSH = new YellowBerryBush();
    public static final Block PURPLE_BERRY_BUSH = new PurpleBerryBush();
    public static final Block BLUE_BERRY_BUSH = new BlueBerryBush();
    public static final Block RED_BERRY_BUSH = new RedBerryBush();

    // Mushrooms
    public static final Block MUSHROOM_NORMAL_BLOCK = new MushroomModBlock(FabricBlockSettings
            .of(Material.PLANT)
            .breakByHand(true)
            .sounds(BlockSoundGroup.GRASS));
    public static final Block MUSHROOM_SPEED_BLOCK = new MushroomModBlock(FabricBlockSettings
            .of(Material.PLANT)
            .breakByHand(true)
            .sounds(BlockSoundGroup.GRASS));
    public static final Block MUSHROOM_HIGH_BLOCK = new MushroomModBlock(FabricBlockSettings
            .of(Material.PLANT)
            .breakByHand(true)
            .sounds(BlockSoundGroup.GRASS));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "white_berry_bush"), WHITE_BERRY_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "yellow_berry_bush"), YELLOW_BERRY_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "purple_berry_bush"), PURPLE_BERRY_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "blue_berry_bush"), BLUE_BERRY_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "red_berry_bush"), RED_BERRY_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "mushroom_normal_block"), MUSHROOM_NORMAL_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "mushroom_speed_block"), MUSHROOM_SPEED_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "mushroom_high_block"), MUSHROOM_HIGH_BLOCK);
    }
}

package com.feika.plantmod.registry;

import com.feika.plantmod.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeatures;

public class ModBlocks {

    // Berry bushes
    public static final Block WHITE_BERRY_BUSH = new WhiteBerryBush();
    public static final Block YELLOW_BERRY_BUSH = new YellowBerryBush();
    public static final Block PURPLE_BERRY_BUSH = new PurpleBerryBush();
    public static final Block BLUE_BERRY_BUSH = new BlueBerryBush();
    public static final Block RED_BERRY_BUSH = new RedBerryBush();

    // Mushrooms
    public static final Block MUSHROOM_NORMAL_BLOCK = new MushroomModBlock(AbstractBlock.Settings.of(Material.PLANT).breakInstantly().noCollision().sounds(BlockSoundGroup.GRASS),
            () -> ConfiguredFeatures.HUGE_BROWN_MUSHROOM);
    public static final Block MUSHROOM_SPEED_BLOCK = new MushroomModBlock(AbstractBlock.Settings.of(Material.PLANT).breakInstantly().noCollision().sounds(BlockSoundGroup.GRASS),
            () -> ConfiguredFeatures.HUGE_BROWN_MUSHROOM);
    public static final Block MUSHROOM_HIGH_BLOCK = new MushroomModBlock(AbstractBlock.Settings.of(Material.PLANT).breakInstantly().noCollision().sounds(BlockSoundGroup.GRASS),
            () -> ConfiguredFeatures.HUGE_BROWN_MUSHROOM);
    public static final Block MUSHROOM_HALL_BLOCK = new MushroomModBlock(AbstractBlock.Settings.of(Material.PLANT).breakInstantly().noCollision().sounds(BlockSoundGroup.GRASS),
            () -> ConfiguredFeatures.HUGE_BROWN_MUSHROOM);
    public static final Block MUSHROOM_RELAX_BLOCK = new MushroomModBlock(AbstractBlock.Settings.of(Material.PLANT).breakInstantly().noCollision().sounds(BlockSoundGroup.GRASS),
            () -> ConfiguredFeatures.HUGE_BROWN_MUSHROOM);
    public static final Block MUSHROOM_RAGE_BLOCK = new MushroomModBlock(AbstractBlock.Settings.of(Material.PLANT).breakInstantly().noCollision().sounds(BlockSoundGroup.GRASS),
            () -> ConfiguredFeatures.HUGE_BROWN_MUSHROOM);

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "white_berry_bush"), WHITE_BERRY_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "yellow_berry_bush"), YELLOW_BERRY_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "purple_berry_bush"), PURPLE_BERRY_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "blue_berry_bush"), BLUE_BERRY_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "red_berry_bush"), RED_BERRY_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "mushroom_normal_block"), MUSHROOM_NORMAL_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "mushroom_speed_block"), MUSHROOM_SPEED_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "mushroom_high_block"), MUSHROOM_HIGH_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "mushroom_hallucination_block"), MUSHROOM_HALL_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "mushroom_relax_block"), MUSHROOM_RELAX_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "mushroom_rage_block"), MUSHROOM_RAGE_BLOCK);
    }
}

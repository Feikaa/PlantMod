package com.feika.plantmod;

import net.minecraft.block.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block WHITE_BERRY_BUSH = new WhiteBerryBush();
    public static final Block YELLOW_BERRY_BUSH = new YellowBerryBush();
    public static final Block PURPLE_BERRY_BUSH = new PurpleBerryBush();
    public static final Block BLUE_BERRY_BUSH = new BlueBerryBush();
    public static final Block RED_BERRY_BUSH = new RedBerryBush();

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "white_berry_bush"), WHITE_BERRY_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "yellow_berry_bush"), YELLOW_BERRY_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "purple_berry_bush"), PURPLE_BERRY_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "blue_berry_bush"), BLUE_BERRY_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "red_berry_bush"), RED_BERRY_BUSH);
    }
}

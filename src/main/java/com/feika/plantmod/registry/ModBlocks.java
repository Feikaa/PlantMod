package com.feika.plantmod.registry;

import com.feika.plantmod.PlantMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block WHITE_BERRY_BUSH = new Block(FabricBlockSettings
            .of(Material.PLANT)
            .breakByHand(true)
            .breakInstantly()
            .noCollision()
            .sounds(BlockSoundGroup.SWEET_BERRY_BUSH));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(PlantMod.MOD_ID, "white_berry_bush"), WHITE_BERRY_BUSH);
    }
}

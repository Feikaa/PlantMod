package com.feika.plantmod;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.PlantBlock;
import net.minecraft.sound.BlockSoundGroup;

public class MushroomModBlock extends PlantBlock {
    public MushroomModBlock() {
        super(FabricBlockSettings.of(Material.PLANT)
                .breakByHand(true)
                .sounds(BlockSoundGroup.GRASS)
                .noCollision()
                .nonOpaque());
    }
}

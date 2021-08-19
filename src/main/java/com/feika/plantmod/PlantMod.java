package com.feika.plantmod;

import com.feika.plantmod.registry.ModBlocks;
import com.feika.plantmod.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class PlantMod implements ModInitializer {

    // Mod ID
    public static final String MOD_ID = "plantmod";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
    }
}

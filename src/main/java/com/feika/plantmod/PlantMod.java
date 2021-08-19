package com.feika.plantmod;

import com.feika.plantmod.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class PlantMod implements ModInitializer {

    public static final String MOD_ID = "plantmod";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
    }
}

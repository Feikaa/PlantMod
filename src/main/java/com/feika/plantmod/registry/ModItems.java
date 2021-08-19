package com.feika.plantmod.registry;

import com.feika.plantmod.PlantMod;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    // Berries Items
    public static final BlockItem WHITE_BERRIES = new BlockItem(ModBlocks.WHITE_BERRY_BUSH, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 20, 4), 1f).build()));
    public static final Item YELLOW_BERRIES = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 20, 4), 1f).build()));
    public static final Item PURPLE_BERRIES = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).build()));
    public static final Item BLUE_BERRIES = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).build()));
    public static final Item RED_BERRIES = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 20, 4), 0.5f).build()));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "white_berries"), WHITE_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "yellow_berries"), YELLOW_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "purple_berries"), PURPLE_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "blue_berries"), BLUE_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "red_berries"), RED_BERRIES);

    }

}

package com.feika.plantmod;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    // Berries Items
    public static final Item WHITE_BERRIES = new AliasedBlockItem(ModBlocks.WHITE_BERRY_BUSH, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*5, 4), 1f).build()));
    public static final Item YELLOW_BERRIES = new AliasedBlockItem(ModBlocks.YELLOW_BERRY_BUSH, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*5, 4), 1f).build()));
    public static final Item PURPLE_BERRIES = new AliasedBlockItem(ModBlocks.PURPLE_BERRY_BUSH, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).build()));
    public static final Item BLUE_BERRIES = new AliasedBlockItem(ModBlocks.BLUE_BERRY_BUSH, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).build()));
    public static final Item RED_BERRIES = new AliasedBlockItem(ModBlocks.RED_BERRY_BUSH, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*5, 4), 0.5f).build()));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "white_berries"), WHITE_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "yellow_berries"), YELLOW_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "purple_berries"), PURPLE_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "blue_berries"), BLUE_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "red_berries"), RED_BERRIES);

    }

}

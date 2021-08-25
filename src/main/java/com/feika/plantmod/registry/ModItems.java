package com.feika.plantmod.registry;

import com.feika.plantmod.PlantMod;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    // Berries Items
    public static final Item WHITE_BERRIES = new AliasedBlockItem(ModBlocks.WHITE_BERRY_BUSH, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*5, 4), 1f).build()));
    public static final Item YELLOW_BERRIES = new AliasedBlockItem(ModBlocks.YELLOW_BERRY_BUSH, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*5, 4), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*10, 0), 1f).build()));
    public static final Item PURPLE_BERRIES = new AliasedBlockItem(ModBlocks.PURPLE_BERRY_BUSH, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).build()));
    public static final Item BLUE_BERRIES = new AliasedBlockItem(ModBlocks.BLUE_BERRY_BUSH, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).build()));
    public static final Item RED_BERRIES = new AliasedBlockItem(ModBlocks.RED_BERRY_BUSH, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*5, 4), 0.5f).build()));

    // Mushroom Items
    public static final Item MUSHROOM_NORMAL = new AliasedBlockItem(ModBlocks.MUSHROOM_NORMAL_BLOCK, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build()));
    public static final Item MUSHROOM_SPEED = new AliasedBlockItem(ModBlocks.MUSHROOM_SPEED_BLOCK, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(1).saturationModifier(0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*15, 4), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20*15, 2), 1f).build()));
    public static final Item MUSHROOM_HIGH = new AliasedBlockItem(ModBlocks.MUSHROOM_HIGH_BLOCK, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*15, 0), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 20*15, 0), 1f).build()));
    public static final Item MUSHROOM_HALL = new AliasedBlockItem(ModBlocks.MUSHROOM_HALL_BLOCK, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(0f)
            .statusEffect(new StatusEffectInstance(PlantMod.HALLUCINATION, 20*60, 0, false, false), 1f).build()));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "white_berries"), WHITE_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "yellow_berries"), YELLOW_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "purple_berries"), PURPLE_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "blue_berries"), BLUE_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "red_berries"), RED_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "mushroom_normal"), MUSHROOM_NORMAL);
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "mushroom_speed"), MUSHROOM_SPEED);
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "mushroom_high"), MUSHROOM_HIGH);
        Registry.register(Registry.ITEM, new Identifier(PlantMod.MOD_ID, "mushroom_hallucination"), MUSHROOM_HALL);

    }

}

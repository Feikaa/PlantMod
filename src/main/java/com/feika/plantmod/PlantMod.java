package com.feika.plantmod;

import com.feika.plantmod.registry.ModBlocks;
import com.feika.plantmod.registry.ModItems;
import com.feika.plantmod.statuseffect.effects.HallucinationEffect;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class PlantMod implements ModInitializer {

    // Mod ID
    public static final String MOD_ID = "plantmod";

    public static ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "item_group"), () -> new ItemStack(ModItems.WHITE_BERRIES));

    public static final StatusEffect HALLUCINATION = new HallucinationEffect();

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();

        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "hallucination"), HALLUCINATION);

        // Generation
        registerGeneration("minecraft:forest,minecraft:jungle,minecraft:jungle_hills,minecraft:savanna,minecraft:savanna_plateau", ModBlocks.WHITE_BERRY_BUSH, 16, "whiteberry");
        registerGeneration("minecraft:forest,minecraft:birch_forest,minecraft:taiga", ModBlocks.YELLOW_BERRY_BUSH, 16, "yellowberry");
        registerGeneration("minecraft:forest,minecraft:plains,minecraft:savanna,minecraft:jungle", ModBlocks.PURPLE_BERRY_BUSH, 16, "purpleberry");
        registerGeneration("minecraft:plains,minecraft:jungle_edge,minecraft:savanna", ModBlocks.BLUE_BERRY_BUSH, 16, "blueberry");
        registerGeneration("minecraft:taiga,minecraft:taiga_hills,minecraft:taiga_mountains,minecraft:jungle,minecraft:jungle_hills,minecraft:plains", ModBlocks.RED_BERRY_BUSH, 16, "redberry");

        generateMushrooms("minecraft:swamp,minecraft:tall_birch_forest,minecraft:tall_birch_hills", ModBlocks.MUSHROOM_HIGH_BLOCK, 16, "high_mushroom");
        generateMushrooms("minecraft:sunflower_plains,minecraft:flower_forest", ModBlocks.MUSHROOM_SPEED_BLOCK, 16, "speed_mushroom");
        generateMushrooms("minecraft:wooded_hills,minecraft:birch_forest_hills", ModBlocks.MUSHROOM_NORMAL_BLOCK, 16, "normal_mushroom");
        generateMushrooms("minecraft:dark_forest,minecraft:dark_forest_hills",ModBlocks.MUSHROOM_HALL_BLOCK, 16, "hallucination_mushroom");
        generateMushrooms("minecraft:mountains,minecraft:giant_tree_taiga",ModBlocks.MUSHROOM_RELAX_BLOCK, 16, "relax_mushroom");
        generateMushrooms("minecraft:plains,minecraft:badlands",ModBlocks.MUSHROOM_RAGE_BLOCK, 16, "rage_mushroom");

        // Listen Event when player shears cactus block
        UseBlockCallback.EVENT.register(((player, world, hand, hitResult) -> {
            BlockState state = world.getBlockState(hitResult.getBlockPos());
            if (state.isOf(Blocks.CACTUS)) {
                ItemStack itemStack = player.getStackInHand(hand);
                if (itemStack.isOf(Items.SHEARS)) {
                    if (!world.isClient) {
                        Direction direction = hitResult.getSide();
                        Direction direction2 = direction.getAxis() == Direction.Axis.Y ? player.getHorizontalFacing().getOpposite() : direction;
                        world.playSound((PlayerEntity) null, hitResult.getBlockPos(), SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        world.setBlockState(hitResult.getBlockPos(), (BlockState) ModBlocks.SHAVED_CACTUS.getDefaultState(), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
                        ItemEntity itemEntity = new ItemEntity(world, (double) hitResult.getBlockPos().getX() + 0.5D + (double) direction2.getOffsetX() * 0.65D, (double) hitResult.getBlockPos().getY() + 0.1D, (double) hitResult.getBlockPos().getZ() + 0.5D + (double) direction2.getOffsetZ() * 0.65D, new ItemStack(ModItems.CACTUS_NEEDLES, 2));
                        itemEntity.setVelocity(0.05D * (double) direction2.getOffsetX() + world.random.nextDouble() * 0.02D, 0.05D, 0.05D * (double) direction2.getOffsetZ() + world.random.nextDouble() * 0.02D);
                        world.spawnEntity(itemEntity);
                        itemStack.damage(1, (LivingEntity) player, (Consumer<LivingEntity>) ((playerx) -> {
                            playerx.sendToolBreakStatus(hand);
                        }));
                        world.emitGameEvent(player, GameEvent.SHEAR, hitResult.getBlockPos());
                        player.incrementStat(Stats.USED.getOrCreateStat(Items.SHEARS));
                    }

                    return ActionResult.success(world.isClient);
                } else {
                    return ActionResult.PASS;
                }
            }
            else {
                return ActionResult.PASS;
            }
        }));

    }

    // Places fully grown berry bushes in specified biomes
    private void registerGeneration(String biomes, Block block, int chance, String name) {
        String[] biomeList = biomes.split(",");
        BlockState blockState = block.getDefaultState().with(SweetBerryBushBlock.AGE, 3);
        RandomPatchFeatureConfig BUSH_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(blockState), SimpleBlockPlacer.INSTANCE)).tries(32)
                .spreadX(2).spreadY(2).spreadZ(2).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK)).build();
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, name + "_generation"), Feature.RANDOM_PATCH.configure(BUSH_CONFIG).applyChance(chance * 2));

        for (int i = 0; i < biomeList.length; i++) {
            Predicate<BiomeSelectionContext> biomeSelector = BiomeSelectors.includeByKey(RegistryKey.of(Registry.BIOME_KEY, new Identifier(biomeList[i])));
            BiomeModifications.addFeature(biomeSelector, GenerationStep.Feature.VEGETAL_DECORATION, RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MOD_ID, name + "_generation")));
        }
    }

    private void generateMushrooms(String biomes, Block block, int chance, String name) {
        String[] biomeList = biomes.split(",");
        BlockState blockState = block.getDefaultState();
        RandomPatchFeatureConfig MUSHROOM_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(blockState), SimpleBlockPlacer.INSTANCE).tries(64).spreadX(2).spreadY(2).spreadZ(2).build());
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, name + "_generation"), Feature.RANDOM_PATCH.configure(MUSHROOM_CONFIG).applyChance(chance * 2));

        for (int i = 0; i < biomeList.length; i++) {
            Predicate<BiomeSelectionContext> biomeSelector = BiomeSelectors.includeByKey(RegistryKey.of(Registry.BIOME_KEY, new Identifier(biomeList[i])));
            BiomeModifications.addFeature(biomeSelector, GenerationStep.Feature.VEGETAL_DECORATION, RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MOD_ID, name + "_generation")));
        }
    }
}

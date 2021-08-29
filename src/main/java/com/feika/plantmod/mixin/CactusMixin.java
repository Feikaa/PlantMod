package com.feika.plantmod.mixin;

import java.util.Iterator;

import com.feika.plantmod.registry.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(CactusBlock.class)
public abstract class CactusMixin {

    @Overwrite
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Iterator var4 = Direction.Type.HORIZONTAL.iterator();

        Direction direction;
        Material material;
        do {
            if (!var4.hasNext()) {
                BlockState blockState2 = world.getBlockState(pos.down());
                return (blockState2.isOf(Blocks.CACTUS) || blockState2.isOf(Blocks.SAND) || blockState2.isOf(Blocks.RED_SAND) || blockState2.isOf(ModBlocks.SHAVED_CACTUS)) && !world.getBlockState(pos.up()).getMaterial().isLiquid();
            }

            direction = (Direction)var4.next();
            BlockState blockState = world.getBlockState(pos.offset(direction));
            material = blockState.getMaterial();
        } while(!material.isSolid() && !world.getFluidState(pos.offset(direction)).isIn(FluidTags.LAVA));

        return false;
    }

}

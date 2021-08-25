package com.feika.plantmod.statuseffect.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

import java.util.Random;

public class HallucinationEffect extends StatusEffect {
    public HallucinationEffect() {
        super(StatusEffectType.HARMFUL, 0xFCBA03);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        int bound = 500 / (amplifier + 1);
        if (bound < 100)
            bound = 100;

        int tick = new Random().nextInt(bound);

        if (tick == 1) {
            if (entity instanceof PlayerEntity) {
                int rand = new Random().nextInt(5);
                if (rand == 0)
                    ((PlayerEntity) entity).playSound(SoundEvents.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR, SoundCategory.HOSTILE, 1f, 1f);
                if (rand == 1)
                    ((PlayerEntity) entity).playSound(SoundEvents.ENTITY_CREEPER_PRIMED, SoundCategory.HOSTILE, 1f, 1f);
                if (rand == 2)
                    ((PlayerEntity) entity).playSound(SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS, 1f, 1f);
                if (rand == 3)
                    ((PlayerEntity) entity).playSound(SoundEvents.BLOCK_STONE_STEP, SoundCategory.HOSTILE, 3f, 1f);
                if (rand == 4)
                    ((PlayerEntity) entity).playSound(SoundEvents.ENTITY_PLAYER_HURT, SoundCategory.PLAYERS, 1f, 1f);
            }
        }
    }
}

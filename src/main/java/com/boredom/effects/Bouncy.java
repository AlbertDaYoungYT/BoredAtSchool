package com.boredom.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Bouncy extends StatusEffect {

    public double getRandomNumber(int min, int max) {
        return (double) ((Math.random() * (max - min)) + min);
    }

    public Bouncy() {
        super(StatusEffectCategory.NEUTRAL, 0xe9b8b3);
    }
    
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = ((PlayerEntity) entity);
            World playerWorld = player.getWorld();

            Vec3d currentVelocity = player.getVelocity();
            
            if (player.collidedSoftly || player.isOnGround()) {
                Vec3d velocity = currentVelocity.add(new Vec3d(
                    getRandomNumber(-1, 1),
                    getRandomNumber(-1, 1),
                    getRandomNumber(-1, 1)
                ));
                player.addVelocity(velocity);
            }
        }

        return;
    }
}

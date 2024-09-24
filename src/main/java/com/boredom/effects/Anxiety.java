package com.boredom.effects;

import java.util.List;

import com.boredom.BoredAtSchool;

import net.fabricmc.loader.impl.lib.sat4j.core.Vec;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.entity.VariantPredicates.Predicate;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Anxiety extends StatusEffect {

    public Anxiety() {
        super(StatusEffectCategory.NEUTRAL, 0xee1106);
        //TODO Auto-generated constructor stub
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
            Vec3d playerRotation = player.getRotationVector();
            Vec3d playerPosition = player.getPos();
            List<Entity> worldPlayers = playerWorld.getOtherEntities(((Entity) player), new Box(playerPosition.x-25, playerPosition.y-25, playerPosition.z-25, playerPosition.x+25, playerPosition.y+25, playerPosition.z+25));

            for (Entity playerEntity : worldPlayers) {
                if (playerEntity.getId() != player.getId()) {
                    Vec3d A = player.getPos();
                    Vec3d B = playerEntity.getPos();
                    
                    Vec3d cos_theta = A.normalize().crossProduct(B.normalize());
                    double x_angle = Math.toDegrees(Math.acos(cos_theta.getX()));
                    double y_angle = Math.toDegrees(Math.acos(cos_theta.getY()));
                    double z_angle = Math.toDegrees(Math.acos(cos_theta.getZ()));

                    Vec3d w = A.crossProduct(B).normalize();

                    BoredAtSchool.LOGGER.info("X: " + String.valueOf(x_angle) + " Y: " + String.valueOf(y_angle) + " Z: " + String.valueOf(z_angle));
                    BoredAtSchool.LOGGER.info("W: " + w.toString() + " CosTheta: " + cos_theta.toString());
                    
                }
            }
            
        }

        return;
    }
}

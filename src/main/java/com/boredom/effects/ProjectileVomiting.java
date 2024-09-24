package com.boredom.effects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.LlamaSpitEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EntityList;
import net.minecraft.world.World;
import java.util.ArrayList; 

public class ProjectileVomiting extends StatusEffect {

    public double getRandomNumber(int min, int max) {
        return (double) ((Math.random() * (max - min)) + min);
    }

    public ProjectileVomiting() {
        super(StatusEffectCategory.NEUTRAL, 0xe9b8b3);
    }
    
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof LivingEntity) {
            LivingEntity player = ((LivingEntity) entity);
            World playerWorld = player.getWorld();
            
            Vec3d playerRotationVector = player.getRotationVecClient();
            Vec3d randomArrowPosVec3d = new Vec3d(
                (Math.random()-0.5)/10,
                (Math.random()-0.5)/10,
                (Math.random()-0.5)/10
            );
            Vec3d randomArrowVelocityVec3d = new Vec3d(
                Math.random()-0.5,
                Math.random()-0.5,
                Math.random()-0.5
            );
            Vec3d playerPosVec3d = player.getEyePos().add(randomArrowPosVec3d);
            Vec3d finalProjectileVec3d = playerRotationVector.add(playerRotationVector.multiply(randomArrowVelocityVec3d));

            int randomProjectileInt = (int) getRandomNumber(0, 4);
            if (randomProjectileInt == 0) {
                ArrowEntity spawnedEntity = new ArrowEntity(EntityType.ARROW, playerWorld);
                spawnedEntity.setPosition(playerPosVec3d);
                spawnedEntity.addVelocity(finalProjectileVec3d);
                playerWorld.spawnEntity(spawnedEntity);
            } else if (randomProjectileInt == 1) {
                SnowballEntity spawnedEntity = new SnowballEntity(EntityType.SNOWBALL, playerWorld);
                spawnedEntity.setPosition(playerPosVec3d);
                spawnedEntity.addVelocity(finalProjectileVec3d);
                playerWorld.spawnEntity(spawnedEntity);
            } else if (randomProjectileInt == 2) {
                EggEntity spawnedEntity = new EggEntity(EntityType.EGG, playerWorld);
                spawnedEntity.setPosition(playerPosVec3d);
                spawnedEntity.addVelocity(finalProjectileVec3d);
                playerWorld.spawnEntity(spawnedEntity);
            } else if (randomProjectileInt == 3) {
                LlamaSpitEntity spawnedEntity = new LlamaSpitEntity(EntityType.LLAMA_SPIT, playerWorld);
                spawnedEntity.setPosition(playerPosVec3d);
                spawnedEntity.addVelocity(finalProjectileVec3d);
                playerWorld.spawnEntity(spawnedEntity);
            } else if (randomProjectileInt == 4) {
                PotionEntity spawnedEntity = new PotionEntity(EntityType.POTION, playerWorld);
                spawnedEntity.setPosition(playerPosVec3d);
                spawnedEntity.addVelocity(finalProjectileVec3d);
                playerWorld.spawnEntity(spawnedEntity);
            }
        }

        return;
    }
}

package com.boredom.enchants;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.World.ExplosionSourceType;

public class Explosion extends Enchantment {

    public Explosion() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        new Thread() {
            public void run() {
                World targetWorld = target.getWorld();
                try {
                    targetWorld.playSound(((PlayerEntity) target), target.getX(), target.getY(), target.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.MASTER);
                } catch (ClassCastException e) {}

                try {
                    Thread.sleep(level*1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                targetWorld.createExplosion(null, target.getX(), target.getY(), target.getZ(), (float) level, ExplosionSourceType.TNT);
            }
        }.start();
    }
}

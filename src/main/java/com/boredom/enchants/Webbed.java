package com.boredom.enchants;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.exception.ExceptionUtils;

import com.boredom.BoredAtSchool;
import com.mojang.datafixers.types.templates.List;

import net.fabricmc.loader.impl.util.ExceptionUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class Webbed extends Enchantment {
    // private static int slownessBaseTime = 5;
    // private static float slownessTierTimeWeight = 0.50F;
    private static float timeWeight = 0.5F;

    public Webbed() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        Vec3d entityPos = target.getPos();
        BlockPos actionBlock = new BlockPos(
                new Vec3i((int) entityPos.getX(), (int) entityPos.getY(), (int) entityPos.getZ()));
        BlockState previousBlockState = user.getWorld().getBlockState(actionBlock);
        World userWorld = user.getWorld();
        BlockPos[] replaceBlocks = {};

        if (level == 1) {
            if (previousBlockState == Blocks.AIR.getDefaultState()) {
                replaceBlocks = new BlockPos[] { actionBlock };
                userWorld.removeBlock(replaceBlocks[0], false);
                if (userWorld.canSetBlock(replaceBlocks[0])) {
                    userWorld.setBlockState(replaceBlocks[0], Blocks.COBWEB.getDefaultState());
                }
            }
        } else if (level == 2) {
            replaceBlocks = new BlockPos[] {
                    actionBlock,
                    actionBlock.offset(Direction.NORTH),
                    actionBlock.offset(Direction.EAST),
                    actionBlock.offset(Direction.NORTH).offset(Direction.EAST)
            };
            for (var i = 0; i < replaceBlocks.length; i++) {
                if (previousBlockState == Blocks.AIR.getDefaultState()) {
                    userWorld.removeBlock(replaceBlocks[i], false);
                    if (userWorld.canSetBlock(replaceBlocks[i])) {
                        userWorld.setBlockState(replaceBlocks[i], Blocks.COBWEB.getDefaultState());
                    }
                }
            }
        } else if (level == 3) {
            replaceBlocks = new BlockPos[] {
                    actionBlock,
                    actionBlock.offset(Direction.NORTH),
                    actionBlock.offset(Direction.EAST),
                    actionBlock.offset(Direction.NORTH).offset(Direction.EAST),
                    actionBlock.offset(Direction.WEST),
                    actionBlock.offset(Direction.NORTH).offset(Direction.WEST),
                    actionBlock.offset(Direction.SOUTH),
                    actionBlock.offset(Direction.SOUTH).offset(Direction.EAST),
                    actionBlock.offset(Direction.SOUTH).offset(Direction.WEST)
            };
            for (var i = 0; i < replaceBlocks.length; i++) {
                if (previousBlockState == Blocks.AIR.getDefaultState()) {
                    userWorld.removeBlock(replaceBlocks[i], false);
                    if (userWorld.canSetBlock(replaceBlocks[i])) {
                        userWorld.setBlockState(replaceBlocks[i], Blocks.COBWEB.getDefaultState());
                    }
                }
            }
        } else {
            replaceBlocks = new BlockPos[] {};
        }
    }
}

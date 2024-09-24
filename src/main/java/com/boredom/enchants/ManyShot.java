package com.boredom.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class ManyShot extends Enchantment {

    public ManyShot() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.BOW, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    
}

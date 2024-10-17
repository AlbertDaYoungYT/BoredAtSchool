package com.boredom;

import com.boredom.events.ThickOfItSoundEvent;

import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;

public class AllEvents {
    public static void registerEvents() {
        BoredAtSchool.LOGGER.info("Registering ModEvents for "+ BoredAtSchool.MOD_ID);
    }
}

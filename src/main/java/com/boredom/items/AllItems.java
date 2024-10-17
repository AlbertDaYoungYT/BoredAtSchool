package com.boredom.items;

import com.boredom.AllSounds;
import com.boredom.BoredAtSchool;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AllItems {
    public static final Item KSI_THICK_OF_IT_MUSIC_DISC = registerItem("ksi_thick_of_it_music_disc", new MusicDiscItem(7, AllSounds.KSI_THICK_OF_IT, new FabricItemSettings().maxCount(1), 39));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BoredAtSchool.MOD_ID, name), item);
    }

    public static void registerItems() {
        BoredAtSchool.LOGGER.info("Registering ModItems for "+ BoredAtSchool.MOD_ID);
    }
}

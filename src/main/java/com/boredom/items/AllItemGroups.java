package com.boredom.items;

import com.boredom.BoredAtSchool;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AllItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BoredAtSchool.MOD_ID, "ksi_thick_of_it_music_disc"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.boredatschool"))
                    .icon(() -> new ItemStack(AllItems.KSI_THICK_OF_IT_MUSIC_DISC)).entries((displayContext, entries) -> {
                        entries.add(AllItems.KSI_THICK_OF_IT_MUSIC_DISC);
                    }).build());
    
    public static void registerItemGroups() {
        BoredAtSchool.LOGGER.info("Registering Item Groups for " + BoredAtSchool.MOD_ID);
    }
}

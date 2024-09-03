package com.boredom;

import com.boredom.BoredAtSchool;
import com.boredom.enchants.Webbed;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AllEnchants {
    public static final Enchantment WEBBED = registerEnchantment("webbed", new Webbed());

    private static Enchantment registerEnchantment(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(BoredAtSchool.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        BoredAtSchool.LOGGER.info("Registering ModEnchantments for "+ BoredAtSchool.MOD_ID);
    }
}
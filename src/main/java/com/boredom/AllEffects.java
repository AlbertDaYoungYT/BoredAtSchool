package com.boredom;

import com.boredom.effects.Anxiety;
import com.boredom.effects.Bouncy;
import com.boredom.effects.ProjectileVomiting;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class AllEffects {
    public static final StatusEffect BOUNCY_EFFECT;
    public static final StatusEffect PROJECTILE_VOMITING_EFFECT;
//    public static final StatusEffect ANXIETY;

	static {
		BOUNCY_EFFECT = Registry.register(Registries.STATUS_EFFECT, Identifier.of(BoredAtSchool.MOD_ID, "bouncy"), new Bouncy());
		PROJECTILE_VOMITING_EFFECT = Registry.register(Registries.STATUS_EFFECT, Identifier.of(BoredAtSchool.MOD_ID, "projectile_vomiting"), new ProjectileVomiting());
//		ANXIETY = Registry.register(Registries.STATUS_EFFECT, Identifier.of(BoredAtSchool.MOD_ID, "anxiety"), new Anxiety());
	}

    public static void registerModEffects() {
        BoredAtSchool.LOGGER.info("Registering ModEffects for "+ BoredAtSchool.MOD_ID);
    }
}

package com.boredom;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class AllSounds {
    public static final SoundEvent KSI_THICK_OF_IT = registerSoundEvent("ksi_thick_of_it");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(BoredAtSchool.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSounds() {
        BoredAtSchool.LOGGER.info("Registering ModSounds for "+ BoredAtSchool.MOD_ID);
    }
}

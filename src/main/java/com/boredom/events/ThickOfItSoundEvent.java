package com.boredom.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface ThickOfItSoundEvent {
	Event<ThickOfItSoundEvent> EVENT = EventFactory.createArrayBacked(ThickOfItSoundEvent.class,
			(listeners) -> (player, block) -> {
				for (ThickOfItSoundEvent listener : listeners) {
					ActionResult result = listener.interact(player, block);

					if (result != ActionResult.PASS) {
						return result;
					}
				}

				return ActionResult.PASS;
			});

	ActionResult interact(PlayerEntity player, Block block);
}
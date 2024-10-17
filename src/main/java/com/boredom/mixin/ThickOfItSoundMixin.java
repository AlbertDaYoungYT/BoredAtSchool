package com.boredom.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.boredom.events.ThickOfItSoundEvent;

import net.minecraft.block.JukeboxBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

@Mixin(JukeboxBlock.class)
public class ThickOfItSoundMixin {
 
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/block/JukeboxBlock;onUse()V"), method = "interactMob", cancellable = true)
    private void onShear(final PlayerEntity player, final Hand hand, final CallbackInfoReturnable<Boolean> info) {
        ActionResult result = ThickOfItSoundEvent.EVENT.invoker().interact(player, (JukeboxBlock) (Object) this);
 
        if(result == ActionResult.FAIL) {
            info.cancel();
        }
    }
}
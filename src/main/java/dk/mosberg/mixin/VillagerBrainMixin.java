package dk.mosberg.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mojang.serialization.Dynamic;

import dk.mosberg.ai.guard.GuardBrainInjector;
import dk.mosberg.ai.warrior.WarriorBrainInjector;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.passive.VillagerEntity;

@Mixin(VillagerEntity.class)
public abstract class VillagerBrainMixin {

  @Inject(method = "createBrain", at = @At("RETURN"), cancellable = true)
  private void avp$injectCustomBrain(Dynamic<?> dynamic, CallbackInfoReturnable<Brain<VillagerEntity>> cir) {
    Brain<VillagerEntity> brain = cir.getReturnValue();
    GuardBrainInjector.inject(brain);
    WarriorBrainInjector.inject(brain);
    cir.setReturnValue(brain);
  }
}

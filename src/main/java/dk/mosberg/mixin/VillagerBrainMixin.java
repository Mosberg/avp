package dk.mosberg.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import dk.mosberg.ai.guard.GuardBrainInjector;
import dk.mosberg.ai.warrior.WarriorBrainInjector;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.passive.VillagerEntity;

@Mixin(VillagerEntity.class)
public abstract class VillagerBrainMixin {

  @Inject(method = "initBrain", at = @At("TAIL"))
  private void avp$injectCustomBrain(Brain<VillagerEntity> brain,
      org.spongepowered.asm.mixin.injection.callback.CallbackInfo ci) {
    GuardBrainInjector.inject(brain);
    WarriorBrainInjector.inject(brain);
  }
}

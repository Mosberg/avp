package dk.mosberg.abilities;

import java.util.List;

import dk.mosberg.professions.ModProfessions;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;

public class GuardAbilities {

  public static void applyAlarmEffects(ServerWorld world, VillagerEntity guard) {
    List<VillagerEntity> guards = world.getEntitiesByClass(
        VillagerEntity.class,
        new Box(guard.getBlockPos()).expand(16),
        v -> v.getVillagerData().profession().equals(ModProfessions.GUARD));

    for (VillagerEntity g : guards) {
      g.addStatusEffect(new StatusEffectInstance(
          StatusEffects.SPEED, 20 * 10, 0, true, true));
    }
  }
}

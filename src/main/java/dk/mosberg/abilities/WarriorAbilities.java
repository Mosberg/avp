package dk.mosberg.abilities;

import java.util.List;

import dk.mosberg.professions.ModProfessions;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;

public class WarriorAbilities {

  public static void applyCombatAura(ServerWorld world, VillagerEntity warrior) {
    List<VillagerEntity> allies = world.getEntitiesByClass(
        VillagerEntity.class,
        new Box(warrior.getBlockPos()).expand(8),
        v -> v.getVillagerData().profession().equals(ModProfessions.WARRIOR));

    for (VillagerEntity ally : allies) {
      ally.addStatusEffect(new StatusEffectInstance(
          StatusEffects.STRENGTH, 20 * 10, 0, true, true));
    }
  }
}

package dk.mosberg.abilities;

import java.util.List;

import dk.mosberg.professions.ModProfessions;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

public class VillageDefenseManager {

  public static void onGuardDetectHostile(ServerWorld world, VillagerEntity guard, BlockPos threatPos) {
    buffNearbyWarriors(world, threatPos);
    panicVillagers(world, threatPos);
  }

  public static void onWarriorEnterCombat(ServerWorld world, VillagerEntity warrior, BlockPos threatPos) {
    buffNearbyPlayers(world, threatPos);
  }

  private static void buffNearbyWarriors(ServerWorld world, BlockPos center) {
    List<VillagerEntity> warriors = world.getEntitiesByClass(
        VillagerEntity.class,
        new Box(center).expand(16),
        v -> v.getVillagerData().profession().equals(ModProfessions.WARRIOR));

    for (VillagerEntity warrior : warriors) {
      warrior.addStatusEffect(new StatusEffectInstance(
          StatusEffects.RESISTANCE, 20 * 20, 0, true, true));
    }
  }

  private static void panicVillagers(ServerWorld world, BlockPos center) {
    List<VillagerEntity> villagers = world.getEntitiesByClass(
        VillagerEntity.class,
        new Box(center).expand(24),
        v -> !v.getVillagerData().profession().equals(ModProfessions.WARRIOR)
            && !v.getVillagerData().profession().equals(ModProfessions.GUARD));

    for (VillagerEntity villager : villagers) {
      villager.addStatusEffect(new StatusEffectInstance(
          StatusEffects.SPEED, 20 * 10, 0, true, true));
    }
  }

  private static void buffNearbyPlayers(ServerWorld world, BlockPos center) {
    // Fix: Use List<ServerPlayerEntity> instead of List<PlayerEntity>
    List<ServerPlayerEntity> players = world
        .getPlayers(p -> p.squaredDistanceTo(center.getX(), center.getY(), center.getZ()) < 16 * 16);

    for (ServerPlayerEntity player : players) {
      player.addStatusEffect(new StatusEffectInstance(
          StatusEffects.STRENGTH, 20 * 15, 0, true, true));
    }
  }
}

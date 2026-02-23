package dk.mosberg.abilities;

import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;

public class LevelingSystem {

  public static void register() {
  }

  public static void onWarriorSpar(ServerWorld world, VillagerEntity warrior) {
    addExperience(warrior, 1);
  }

  public static void onWarriorCombat(ServerWorld world, VillagerEntity warrior) {
    addExperience(warrior, 3);
  }

  public static void onGuardAlarm(ServerWorld world, VillagerEntity guard) {
    addExperience(guard, 2);
  }

  private static void addExperience(VillagerEntity villager, int amount) {
    int xp = villager.getExperience() + amount;
    villager.setExperience(xp);
  }
}

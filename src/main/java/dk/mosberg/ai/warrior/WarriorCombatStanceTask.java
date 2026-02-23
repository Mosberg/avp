package dk.mosberg.ai.warrior;

import com.google.common.collect.ImmutableMap;

import dk.mosberg.professions.ModProfessions;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.MultiTickTask;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;

public class WarriorCombatStanceTask extends MultiTickTask<VillagerEntity> {

  public WarriorCombatStanceTask() {
    super(ImmutableMap.of(
        MemoryModuleType.NEAREST_HOSTILE, MemoryModuleState.REGISTERED));
  }

  @Override
  protected boolean shouldRun(ServerWorld world, VillagerEntity villager) {
    return villager.getVillagerData().profession().equals(ModProfessions.WARRIOR);
  }

  @Override
  protected void run(ServerWorld world, VillagerEntity villager, long time) {
    boolean hasHostile = villager.getBrain().getOptionalMemory(MemoryModuleType.NEAREST_HOSTILE).isPresent();
    villager.setSprinting(hasHostile);
  }
}

package dk.mosberg.ai.warrior;

import java.util.Optional;

import com.google.common.collect.ImmutableMap;

import dk.mosberg.abilities.LevelingSystem;
import dk.mosberg.abilities.VillageDefenseManager;
import dk.mosberg.abilities.WarriorAbilities;
import dk.mosberg.professions.ModProfessions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;

public class WarriorCombatTask extends Task<VillagerEntity> {

  private final float speed;

  public WarriorCombatTask(float speed) {
    super(ImmutableMap.of(
        MemoryModuleType.NEAREST_HOSTILE, MemoryModuleState.VALUE_PRESENT));
    this.speed = speed;
  }

  @Override
  protected boolean shouldRun(ServerWorld world, VillagerEntity villager) {
    return villager.getVillagerData().getProfession() == ModProfessions.WARRIOR;
  }

  @Override
  protected void run(ServerWorld world, VillagerEntity villager, long time) {
    Optional<LivingEntity> hostileOpt = villager.getBrain().getOptionalMemory(MemoryModuleType.NEAREST_HOSTILE);

    if (hostileOpt.isEmpty())
      return;

    LivingEntity target = hostileOpt.get();
    villager.getNavigation().startMovingTo(target, speed);
    villager.setSprinting(true);

    LevelingSystem.onWarriorCombat(world, villager);
    WarriorAbilities.applyCombatAura(world, villager);
    VillageDefenseManager.onWarriorEnterCombat(world, villager, target.getBlockPos());
  }
}

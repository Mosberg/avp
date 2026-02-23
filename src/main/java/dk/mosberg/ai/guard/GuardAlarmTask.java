package dk.mosberg.ai.guard;

import java.util.Optional;

import com.google.common.collect.ImmutableMap;

import dk.mosberg.abilities.GuardAbilities;
import dk.mosberg.abilities.LevelingSystem;
import dk.mosberg.abilities.VillageDefenseManager;
import dk.mosberg.professions.ModProfessions;
import dk.mosberg.registry.ModSounds;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.MultiTickTask;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;

public class GuardAlarmTask extends MultiTickTask<VillagerEntity> {

  public GuardAlarmTask() {
    super(ImmutableMap.of(
        MemoryModuleType.NEAREST_HOSTILE, MemoryModuleState.VALUE_PRESENT));
  }

  @Override
  protected boolean shouldRun(ServerWorld world, VillagerEntity villager) {
    return villager.getVillagerData().profession().equals(ModProfessions.GUARD);
  }

  @Override
  protected void run(ServerWorld world, VillagerEntity villager, long time) {
    Optional<LivingEntity> hostileOpt = villager.getBrain().getOptionalMemory(MemoryModuleType.NEAREST_HOSTILE);
    // Fix: Null check before isEmpty()
    if (hostileOpt == null || hostileOpt.isEmpty())
      return;
    LivingEntity hostile = hostileOpt.get();
    world.playSound(null, villager.getBlockPos(), ModSounds.GUARD_ALARM, SoundCategory.NEUTRAL, 1.0f, 1.0f);
    BlockPos villPos = villager.getBlockPos();
    BlockPos.iterateOutwards(villPos, 16, 8, 16).forEach(pos -> {
      if (world.getBlockState(pos).isOf(Blocks.BELL)) {
        world.syncWorldEvent(null, 3002, pos, 0); // 3002 = bell ring event
      }
    });
    LevelingSystem.onGuardAlarm(world, villager);
    GuardAbilities.applyAlarmEffects(world, villager);
    VillageDefenseManager.onGuardDetectHostile(world, villager, hostile.getBlockPos());
  }
}

package dk.mosberg.ai.guard;

import com.google.common.collect.ImmutableMap;

import dk.mosberg.professions.ModProfessions;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;

public class GuardShiftTask extends Task<VillagerEntity> {

  public GuardShiftTask() {
    super(ImmutableMap.of());
  }

  @Override
  protected boolean shouldRun(ServerWorld world, VillagerEntity villager) {
    return villager.getVillagerData().getProfession() == ModProfessions.GUARD;
  }

  @Override
  protected void run(ServerWorld world, VillagerEntity villager, long time) {
    boolean isNight = world.isNight();
    villager.setNoDrag(isNight); // cheap "on duty" flag placeholder
  }
}

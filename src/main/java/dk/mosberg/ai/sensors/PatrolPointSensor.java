package dk.mosberg.ai.sensors;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;

public class PatrolPointSensor extends Sensor<VillagerEntity> {

  @Override
  public Set<MemoryModuleType<?>> getOutputMemoryModules() {
    return ImmutableSet.of(MemoryModuleType.WALK_TARGET);
  }

  @Override
  protected void sense(ServerWorld world, VillagerEntity villager) {
    // We generate patrol points in GuardPatrolTask, so nothing needed here for now.
  }
}

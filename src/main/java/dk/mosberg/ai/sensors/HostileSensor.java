package dk.mosberg.ai.sensors;

import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;

public class HostileSensor extends Sensor<VillagerEntity> {

  @Override
  public Set<MemoryModuleType<?>> getOutputMemoryModules() {
    return ImmutableSet.of(MemoryModuleType.NEAREST_HOSTILE);
  }

  @Override
  protected void sense(ServerWorld world, VillagerEntity villager) {
    Box box = villager.getBoundingBox().expand(24.0);
    List<Monster> hostiles = world.getEntitiesByClass(Monster.class, box,
        e -> e.isAlive() && !e.isRemoved());

    if (!hostiles.isEmpty()) {
      villager.getBrain().remember(MemoryModuleType.NEAREST_HOSTILE, hostiles.get(0));
    } else {
      villager.getBrain().forget(MemoryModuleType.NEAREST_HOSTILE);
    }
  }
}

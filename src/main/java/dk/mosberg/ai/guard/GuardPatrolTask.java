package dk.mosberg.ai.guard;

import com.google.common.collect.ImmutableMap;

import dk.mosberg.professions.ModProfessions;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.WalkTarget;
import net.minecraft.entity.ai.brain.task.MultiTickTask;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class GuardPatrolTask extends MultiTickTask<VillagerEntity> {

  private final float speed;

  public GuardPatrolTask(float speed) {
    super(ImmutableMap.of(
        MemoryModuleType.WALK_TARGET, MemoryModuleState.REGISTERED));
    this.speed = speed;
  }

  @Override
  protected boolean shouldRun(ServerWorld world, VillagerEntity villager) {
    return villager.getVillagerData().profession().equals(ModProfessions.GUARD);
  }

  @Override
  protected void run(ServerWorld world, VillagerEntity villager, long time) {
    BlockPos center = villager.getBlockPos();
    BlockPos patrolPos = center.add(
        world.random.nextBetween(-12, 12),
        0,
        world.random.nextBetween(-12, 12));

    villager.getBrain().remember(
        MemoryModuleType.WALK_TARGET,
        new WalkTarget(patrolPos, speed, 1));
  }
}

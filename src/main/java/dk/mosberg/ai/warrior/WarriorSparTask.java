package dk.mosberg.ai.warrior;

import java.util.List;

import com.google.common.collect.ImmutableMap;

import dk.mosberg.abilities.LevelingSystem;
import dk.mosberg.professions.ModProfessions;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;

public class WarriorSparTask extends Task<VillagerEntity> {

  public WarriorSparTask() {
    super(ImmutableMap.of());
  }

  @Override
  protected boolean shouldRun(ServerWorld world, VillagerEntity villager) {
    return villager.getVillagerData().getProfession() == ModProfessions.WARRIOR
        && world.random.nextInt(200) == 0;
  }

  @Override
  protected void run(ServerWorld world, VillagerEntity villager, long time) {
    List<VillagerEntity> partners = world.getEntitiesByClass(
        VillagerEntity.class,
        villager.getBoundingBox().expand(6.0),
        v -> v.getVillagerData().getProfession() == ModProfessions.WARRIOR && v != villager);

    if (partners.isEmpty())
      return;

    VillagerEntity partner = partners.get(world.random.nextInt(partners.size()));
    villager.getLookControl().lookAt(partner);
    partner.getLookControl().lookAt(villager);

    LevelingSystem.onWarriorSpar(world, villager);
  }
}

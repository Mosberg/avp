package dk.mosberg.ai.warrior;

import com.google.common.collect.ImmutableList;

import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.passive.VillagerEntity;

public class WarriorBrainInjector {

  public static void inject(Brain<VillagerEntity> brain) {
    addIdleTasks(brain);
    addFightTasks(brain);
  }

  private static void addIdleTasks(Brain<VillagerEntity> brain) {
    brain.setTaskList(
        Activity.IDLE,
        20,
        ImmutableList.<Task<? super VillagerEntity>>builder()
            .add(new WarriorSparTask())
            .build());
  }

  private static void addFightTasks(Brain<VillagerEntity> brain) {
    brain.setTaskList(
        Activity.FIGHT,
        20,
        ImmutableList.<Task<? super VillagerEntity>>builder()
            .add(new WarriorCombatStanceTask())
            .add(new WarriorCombatTask(1.2f))
            .build());
  }

  public static void register() {
  }
}

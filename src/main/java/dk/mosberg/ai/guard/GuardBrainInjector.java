package dk.mosberg.ai.guard;

import com.google.common.collect.ImmutableList;

import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.passive.VillagerEntity;

public class GuardBrainInjector {

  public static void inject(Brain<VillagerEntity> brain) {
    addCoreTasks(brain);
    addIdleTasks(brain);
    addFightTasks(brain);
  }

  private static void addCoreTasks(Brain<VillagerEntity> brain) {
    brain.setTaskList(
        Activity.CORE,
        0,
        ImmutableList.<Task<? super VillagerEntity>>builder()
            .addAll(brain.getTaskList(Activity.CORE))
            .add(new GuardShiftTask())
            .build());
  }

  private static void addIdleTasks(Brain<VillagerEntity> brain) {
    brain.setTaskList(
        Activity.IDLE,
        10,
        ImmutableList.<Task<? super VillagerEntity>>builder()
            .addAll(brain.getTaskList(Activity.IDLE))
            .add(new GuardPatrolTask(0.6f))
            .build());
  }

  private static void addFightTasks(Brain<VillagerEntity> brain) {
    brain.setTaskList(
        Activity.FIGHT,
        10,
        ImmutableList.<Task<? super VillagerEntity>>builder()
            .addAll(brain.getTaskList(Activity.FIGHT))
            .add(new GuardAlarmTask())
            .build());
  }

  public static void register() {
  }
}

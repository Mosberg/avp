package dk.mosberg.registry;

import dk.mosberg.AVP;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
  public static SoundEvent WARRIOR_WORK;
  public static SoundEvent GUARD_ALARM;

  public static void register() {
    WARRIOR_WORK = register("warrior_work");
    GUARD_ALARM = register("guard_alarm");
  }

  private static SoundEvent register(String id) {
    Identifier identifier = new Identifier(AVP.MOD_ID, id);
    return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
  }
}
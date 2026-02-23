package dk.mosberg.professions;

import com.google.common.collect.ImmutableSet;

import dk.mosberg.AVP;
import dk.mosberg.poi.ModPOIs;
import dk.mosberg.registry.ModSounds;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModProfessions {

  public static final VillagerProfession WARRIOR = register(
      "warrior", ModPOIs.WARRIOR_POI, ModSounds.WARRIOR_WORK);

  public static final VillagerProfession GUARD = register(
      "guard", ModPOIs.GUARD_POI, ModSounds.GUARD_ALARM);

  private static VillagerProfession register(String id,
      RegistryKey<PointOfInterestType> poiKey,
      SoundEvent workSound) {
    return Registry.register(
        Registries.VILLAGER_PROFESSION,
        Identifier.of(AVP.MOD_ID, id),
        new VillagerProfession(
            net.minecraft.text.Text.literal(id),
            entry -> entry.matchesKey(poiKey),
            entry -> entry.matchesKey(poiKey),
            ImmutableSet.of(),
            ImmutableSet.of(),
            workSound));
  }

  public static void register() {
  }
}

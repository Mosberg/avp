package dk.mosberg.professions;

import org.spongepowered.include.com.google.common.collect.ImmutableSet;

import dk.mosberg.AVP;
import dk.mosberg.poi.ModPOIs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModProfessions {
  public static final VillagerProfession WARRIOR = register(
      "warrior", ModPOIs.WARRIOR_POI);

  public static final VillagerProfession GUARD = register(
      "guard", ModPOIs.GUARD_POI);

  private static VillagerProfession register(String id, RegistryKey<PointOfInterestType> poi) {
    return Registry.register(
        Registries.VILLAGER_PROFESSION,
        new Identifier(AVP.MODID, id),
        new VillagerProfession(
            id,
            entry -> entry.matchesKey(poi),
            entry -> entry.matchesKey(poi),
            ImmutableSet.of(),
            ImmutableSet.of(),
            SoundEvents.ENTITY_VILLAGER_WORK_ARMORER));
  }

  public static void register() {
  }
}
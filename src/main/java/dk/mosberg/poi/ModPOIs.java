package dk.mosberg.poi;

import java.util.Set;

import dk.mosberg.AVP;
import dk.mosberg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

public class ModPOIs {
  public static final RegistryKey<PointOfInterestType> WARRIOR_POI = RegistryKey.of(
      Registries.POINT_OF_INTEREST_TYPE.getKey(),
      new Identifier(AVP.MOD_ID, "warrior_poi"));

  public static final RegistryKey<PointOfInterestType> GUARD_POI = RegistryKey.of(
      Registries.POINT_OF_INTEREST_TYPE.getKey(),
      new Identifier(AVP.MOD_ID, "guard_poi"));

  public static void register() {
    register(WARRIOR_POI, ModBlocks.WARRIOR_TRAINING_POST);
    register(GUARD_POI, ModBlocks.GUARD_POST);
  }

  private static void register(RegistryKey<PointOfInterestType> key, Block block) {
    Registry.register(Registries.POINT_OF_INTEREST_TYPE, key.getValue(),
        new PointOfInterestType(
            Set.copyOf(block.getStateManager().getStates()),
            1, 1));
  }
}
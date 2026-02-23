package dk.mosberg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mosberg.abilities.LevelingSystem;
import dk.mosberg.ai.guard.GuardBrainInjector;
import dk.mosberg.ai.warrior.WarriorBrainInjector;
import dk.mosberg.poi.ModPOIs;
import dk.mosberg.professions.ModProfessions;
import dk.mosberg.registry.ModBlockEntities;
import dk.mosberg.registry.ModBlocks;
import dk.mosberg.registry.ModItems;
import dk.mosberg.registry.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class AVP implements ModInitializer {
  public static final String MOD_ID = "avp";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  public static Identifier id(String path) {
    return Identifier.of(MOD_ID, path);
  }

  @Override
  public void onInitialize() {
    LOGGER.info("Initializing AVP");

    ModBlocks.register();
    ModBlockEntities.register();
    ModItems.register();
    ModPOIs.register();
    ModProfessions.register();
    ModSounds.register();

    GuardBrainInjector.register();
    WarriorBrainInjector.register();
    LevelingSystem.register();

    LOGGER.info("AVP initialized");
  }
}

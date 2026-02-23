package dk.mosberg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mosberg.abilities.LevelingSystem;
import dk.mosberg.ai.guard.GuardBrainInjector;
import dk.mosberg.ai.warrior.WarriorBrainInjector;
import dk.mosberg.poi.ModPOIs;
import dk.mosberg.professions.ModProfessions;
import dk.mosberg.registry.ModBlocks;
import dk.mosberg.registry.ModItems;
import dk.mosberg.registry.ModSounds;
import net.fabricmc.api.ModInitializer;

public class AVP implements ModInitializer {
  public static final String MOD_ID = "avp";

  // This logger is used to write text to the console and the log file.
  // It is considered best practice to use your mod id as the logger's name.
  // That way, it's clear which mod wrote info, warnings, and errors.
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  @Override
  public void onInitialize() {
    // This code runs as soon as Minecraft is in a mod-load-ready state.
    // However, some things (like resources) may still be uninitialized.
    // Proceed with mild caution.

    ModBlocks.register();
    ModItems.register();
    ModPOIs.register();
    ModProfessions.register();

    ModSounds.register();

    // AI injection
    GuardBrainInjector.register();
    WarriorBrainInjector.register();

    // Abilities + leveling
    LevelingSystem.register();

    LOGGER.info("Hello Fabric world!");
  }
}
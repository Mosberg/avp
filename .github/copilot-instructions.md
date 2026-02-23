# Copilot Instructions for AVP Mod (Fabric 1.21.11)

## Project Overview

- This is a Minecraft Fabric mod for 1.21.11, adding new villager professions (Warrior, Guard), custom job site blocks, AI, abilities, and full resource/data integration.
- The codebase is modular, with clear separation between AI, abilities, blocks, professions, and resources.

## Key Architecture & Patterns

- **Java source:**
  - Main mod logic: `src/main/java/dk/mosberg/avp/`
  - Client code: `src/client/java/dk/mosberg/client/`
- **Initialization:**
  - All registration (blocks, items, POIs, professions, sounds, AI, abilities) is triggered from `AVP.java` via `onInitialize()`.
- **AI System:**
  - Custom villager behaviors use mixins (`mixin/`), tasks, sensors, and brain injectors.
  - Example: `GuardPatrolTask`, `WarriorSparTask`, `GuardBrainInjector`, `WarriorBrainInjector`.
- **Resource/data files:**
  - Blockstates, models, textures, sounds, trades, POIs, professions, villager types are under `src/main/resources/assets/avp/` and `src/main/resources/data/avp/`.

## Developer Workflows

- **Build:** Use `./gradlew build` (or `gradlew.bat` on Windows).
- **Test:** No explicit test suite; validate by running Minecraft with the mod loaded.
- **Debug:** Use Fabric's built-in logging and Minecraft's F3 debug screen. AI debugging often requires mixin log output.
- **Data generation:** Use `AVPDataGenerator.java` for generating JSON/data files.

## Project-Specific Conventions

- **Registration:** All registry classes (`ModBlocks`, `ModItems`, `ModPOIs`, `ModProfessions`, `ModSounds`) have a static `register()` method called from `AVP.java`.
- **Resource structure:**
  - Textures: `textures/entity/villager/profession/`, `textures/entity/villager/type/`
  - Block models: `models/block/`, `blockstates/`
  - Sounds: `sounds.json`, `.ogg` files
  - Trades, POIs, professions: `data/avp/`
- **AI/Abilities:**
  - Custom tasks and sensors are grouped by profession and role.
  - Abilities and leveling logic are in `abilities/`.
- **Mixins:**
  - Used for injecting custom AI and profession logic into vanilla villagers.

## Integration Points

- **External dependencies:**
  - Fabric API, Geckolib, ModMenu (see `README.md` for exact versions)
- **Data-driven trades:**
  - Trades are defined in JSON under `data/avp/trades/`.
- **Custom sounds:**
  - Registered in `ModSounds.java` and referenced in professions.

## Examples

- Registering a block: `ModBlocks.register()`
- Adding a profession: `ModProfessions.register()`
- Custom AI task: `GuardPatrolTask.java`, `WarriorSparTask.java`
- Resource file: `assets/avp/textures/entity/villager/profession/guard.png`

## Quickstart for AI Agents

- Always call registration methods from `AVP.java`.
- Follow the folder structure for new features (e.g., new AI tasks go in `ai/guard/` or `ai/warrior/`).
- Use data generators for JSON files.
- Reference the `README.md` for versioning and dependency details.

---

If any section is unclear or missing, please request clarification or suggest improvements for future iterations.

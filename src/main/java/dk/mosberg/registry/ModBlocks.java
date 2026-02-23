package dk.mosberg.registry;

import dk.mosberg.AVP;
import dk.mosberg.blocks.GuardTowerBlock;
import dk.mosberg.blocks.TrainingDummyBlock;
import dk.mosberg.blocks.WeaponRackBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
  public static final Block WARRIOR_TRAINING_POST = register("warrior_training_post",
      new TrainingDummyBlock(FabricBlockSettings.create().strength(2.0f)));

  public static final Block GUARD_POST = register("guard_post",
      new WeaponRackBlock(FabricBlockSettings.create().strength(2.0f)));

  public static final Block GUARD_TOWER = register("guard_tower",
      new GuardTowerBlock(FabricBlockSettings.create().strength(3.0f)));

  private static Block register(String id, Block block) {
    return Registry.register(Registries.BLOCK, new Identifier(AVP.MODID, id), block);
  }

  public static void register() {
  }
}
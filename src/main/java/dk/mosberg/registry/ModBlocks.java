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
      new TrainingDummyBlock(Block.Settings.create().strength(2.0f).nonOpaque()));

  public static final Block GUARD_POST = register("guard_post",
      new WeaponRackBlock(Block.Settings.create().strength(2.0f).nonOpaque()));

  public static final Block GUARD_TOWER = register("guard_tower",
      new GuardTowerBlock(Block.Settings.create().strength(3.0f).nonOpaque()));

  private static Block register(String id, Block block) {
    return Registry.register(Registries.BLOCK, Identifier.of(AVP.MOD_ID, id), block);
  }

  public static void register() {
    // class load triggers static init
  }
}

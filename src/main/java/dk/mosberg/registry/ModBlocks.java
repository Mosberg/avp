package dk.mosberg.registry;

import dk.mosberg.AVP;
import dk.mosberg.blocks.GuardTowerBlock;
import dk.mosberg.blocks.TrainingDummyBlock;
import dk.mosberg.blocks.WeaponRackBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public final class ModBlocks {
  public static Block GUARD_POST;
  public static Block WARRIOR_TRAINING_POST;
  public static Block GUARD_TOWER;
  public static Block WEAPON_RACK;

  private ModBlocks() {
  }

  public static void register() {
    GUARD_POST = Registry.register(Registries.BLOCK, AVP.id("guard_post"),
        new TrainingDummyBlock(Block.Settings.create().strength(2.0f).requiresTool()));

    Registry.register(Registries.ITEM, AVP.id("guard_post"),
        new BlockItem(GUARD_POST, new Item.Settings()));

    GUARD_TOWER = Registry.register(Registries.BLOCK, AVP.id("guard_tower"),
        new GuardTowerBlock(Block.Settings.create().strength(2.0f).requiresTool()));

    Registry.register(Registries.ITEM, AVP.id("guard_tower"),
        new BlockItem(GUARD_TOWER, new Item.Settings()));

    WARRIOR_TRAINING_POST = Registry.register(Registries.BLOCK, AVP.id("warrior_training_post"),
        new TrainingDummyBlock(Block.Settings.create().strength(2.0f).requiresTool()));

    Registry.register(Registries.ITEM, AVP.id("warrior_training_post"),
        new BlockItem(WARRIOR_TRAINING_POST, new Item.Settings()));

    WEAPON_RACK = Registry.register(Registries.BLOCK, AVP.id("weapon_rack"),
        new WeaponRackBlock(Block.Settings.create().strength(2.0f).requiresTool()));

    Registry.register(Registries.ITEM, AVP.id("weapon_rack"),
        new BlockItem(WEAPON_RACK, new Item.Settings()));
  }
}

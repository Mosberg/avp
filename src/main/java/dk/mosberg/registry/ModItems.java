package dk.mosberg.registry;

import dk.mosberg.AVP;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

  public static final Item WARRIOR_TRAINING_POST = register("warrior_training_post",
      new BlockItem(ModBlocks.WARRIOR_TRAINING_POST, new Item.Settings()));

  public static final Item GUARD_POST = register("guard_post",
      new BlockItem(ModBlocks.GUARD_POST, new Item.Settings()));

  public static final Item GUARD_TOWER = register("guard_tower",
      new BlockItem(ModBlocks.GUARD_TOWER, new Item.Settings()));

  private static Item register(String id, Item item) {
    return Registry.register(Registries.ITEM, Identifier.of(AVP.MOD_ID, id), item);
  }

  public static void register() {
  }
}

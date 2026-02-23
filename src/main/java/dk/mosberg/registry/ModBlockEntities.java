package dk.mosberg.registry;

import dk.mosberg.AVP;
import dk.mosberg.blocks.entity.WeaponRackBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public final class ModBlockEntities {

  public static BlockEntityType<WeaponRackBlockEntity> WEAPON_RACK;

  private ModBlockEntities() {
  }

  public static void register() {
    WEAPON_RACK = Registry.register(
        Registries.BLOCK_ENTITY_TYPE,
        AVP.id("weapon_rack"),
        BlockEntityType.Builder.create(WeaponRackBlockEntity::new, ModBlocks.WEAPON_RACK).build());

  }
}

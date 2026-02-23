package dk.mosberg.registry;

import dk.mosberg.AVP;
import dk.mosberg.blocks.entity.TrainingDummyBlockEntity;
import dk.mosberg.blocks.entity.WeaponRackBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

  public static BlockEntityType<WeaponRackBlockEntity> WEAPON_RACK;
  public static BlockEntityType<TrainingDummyBlockEntity> TRAINING_DUMMY;

  public static void register() {
    WEAPON_RACK = Registry.register(
        Registries.BLOCK_ENTITY_TYPE,
        new Identifier(AVP.MOD_ID, "weapon_rack"),
        FabricBlockEntityTypeBuilder.create(WeaponRackBlockEntity::new, ModBlocks.GUARD_POST).build());

    TRAINING_DUMMY = Registry.register(
        Registries.BLOCK_ENTITY_TYPE,
        new Identifier(AVP.MOD_ID, "training_dummy"),
        FabricBlockEntityTypeBuilder.create(TrainingDummyBlockEntity::new, ModBlocks.WARRIOR_TRAINING_POST).build());
  }
}

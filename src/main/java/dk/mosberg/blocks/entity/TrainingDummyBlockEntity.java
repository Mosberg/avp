package dk.mosberg.blocks.entity;

import dk.mosberg.registry.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class TrainingDummyBlockEntity extends BlockEntity {

  public TrainingDummyBlockEntity(BlockPos pos, BlockState state) {
    super(ModBlockEntities.TRAINING_DUMMY, pos, state);
  }
}

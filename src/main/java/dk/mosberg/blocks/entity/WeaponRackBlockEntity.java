package dk.mosberg.blocks.entity;

import dk.mosberg.registry.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class WeaponRackBlockEntity extends BlockEntity {

  private ItemStack stored = ItemStack.EMPTY;

  public WeaponRackBlockEntity(BlockPos pos, BlockState state) {
    super(ModBlockEntities.WEAPON_RACK, pos, state);
  }

  public ItemStack getStored() {
    return stored;
  }

  public void setStored(ItemStack stack) {
    this.stored = stack;
  }

  @Override
  protected void writeNbt(NbtCompound nbt) {
    super.writeNbt(nbt);
    if (!stored.isEmpty()) {
      nbt.put("Item", stored.writeNbt(new NbtCompound()));
    }
  }

  @Override
  public void readNbt(NbtCompound nbt) {
    super.readNbt(nbt);
    if (nbt.contains("Item")) {
      stored = ItemStack.fromNbt(nbt.getCompound("Item"));
    } else {
      stored = ItemStack.EMPTY;
    }
  }
}

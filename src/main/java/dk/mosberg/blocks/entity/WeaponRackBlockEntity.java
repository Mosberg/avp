package dk.mosberg.blocks.entity;

import dk.mosberg.registry.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
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
      NbtCompound itemTag = new NbtCompound();
      itemTag.putString("id", Registries.ITEM.getId(stored.getItem()).toString());
      itemTag.putInt("count", stored.getCount());
      nbt.put("Item", itemTag);
    }
  }

  @Override
  public void readNbt(NbtCompound nbt) {
    super.readNbt(nbt);

    if (nbt.contains("Item")) {
      NbtCompound itemTag = nbt.getCompound("Item");
      String idStr = itemTag.getString("id");
      int count = itemTag.getInt("count");

      Identifier id = Identifier.tryParse(idStr);
      var item = id != null ? Registries.ITEM.get(id) : null;

      stored = item != null ? new ItemStack(item, count) : ItemStack.EMPTY;
    } else {
      stored = ItemStack.EMPTY;
    }
  }
}

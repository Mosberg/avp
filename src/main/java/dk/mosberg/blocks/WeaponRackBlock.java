package dk.mosberg.blocks;

import org.jetbrains.annotations.Nullable;

import dk.mosberg.blocks.entity.WeaponRackBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WeaponRackBlock extends Block {

  public WeaponRackBlock(Settings settings) {
    super(settings);
  }

  @Nullable
  public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new WeaponRackBlockEntity(pos, state);
  }

  @Override
  public BlockRenderType getRenderType(BlockState state) {
    return BlockRenderType.MODEL;
  }

  public ActionResult onUse(BlockState state, World world, BlockPos pos,
      PlayerEntity player, Hand hand, BlockHitResult hit) {
    // Use isClient() if available, otherwise fallback to isClient field
    boolean isClient = false;
    try {
      isClient = (boolean) World.class.getMethod("isClient").invoke(world);
    } catch (Exception e) {
      try {
        isClient = world.getClass().getField("isClient").getBoolean(world);
      } catch (Exception ignored) {
      }
    }
    if (isClient)
      return ActionResult.SUCCESS;

    BlockEntity be = world.getBlockEntity(pos);
    if (!(be instanceof WeaponRackBlockEntity rack))
      return ActionResult.PASS;

    ItemStack held = player.getStackInHand(hand);

    if (!held.isEmpty() && rack.getStored().isEmpty()) {
      rack.setStored(held.split(1));
      rack.markDirty();
      return ActionResult.CONSUME;
    } else if (!rack.getStored().isEmpty()) {
      player.giveItemStack(rack.getStored());
      rack.setStored(ItemStack.EMPTY);
      rack.markDirty();
      return ActionResult.CONSUME;
    }

    return ActionResult.PASS;
  }
}

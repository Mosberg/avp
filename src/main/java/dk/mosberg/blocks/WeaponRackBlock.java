package dk.mosberg.blocks;

import org.jetbrains.annotations.Nullable;

import dk.mosberg.blocks.entity.WeaponRackBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WeaponRackBlock extends BlockWithEntity {

  public WeaponRackBlock(Settings settings) {
    super(settings.nonOpaque());
  }

  @Nullable
  @Override
  public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new WeaponRackBlockEntity(pos, state);
  }

  @Override
  public ActionResult onUse(BlockState state, World world, BlockPos pos,
      PlayerEntity player, Hand hand, BlockHitResult hit) {
    if (world.isClient)
      return ActionResult.SUCCESS;

    WeaponRackBlockEntity be = (WeaponRackBlockEntity) world.getBlockEntity(pos);
    if (be == null)
      return ActionResult.PASS;

    ItemStack held = player.getStackInHand(hand);

    if (!held.isEmpty() && be.getStored().isEmpty()) {
      be.setStored(held.split(1));
      be.markDirty();
      return ActionResult.CONSUME;
    } else if (!be.getStored().isEmpty()) {
      player.giveItemStack(be.getStored());
      be.setStored(ItemStack.EMPTY);
      be.markDirty();
      return ActionResult.CONSUME;
    }

    return ActionResult.PASS;
  }
}
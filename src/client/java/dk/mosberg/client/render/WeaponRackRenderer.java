package dk.mosberg.client.render;

import dk.mosberg.blocks.entity.WeaponRackBlockEntity;
import dk.mosberg.client.render.state.WeaponRackRenderState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

public class WeaponRackRenderer implements BlockEntityRenderer<WeaponRackBlockEntity, WeaponRackRenderState> {

  public WeaponRackRenderer(BlockEntityRendererFactory.Context ctx) {
  }

  public void render(WeaponRackRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue,
      CameraRenderState cameraState) {
    if (state.blockEntity == null)
      return;
    WeaponRackBlockEntity rack = state.blockEntity;
    ItemStack stack = rack.getStored();
    if (stack == null || stack.isEmpty())
      return;

    matrices.push();
    matrices.translate(0.5, 0.75, 0.5);
    matrices.scale(0.5f, 0.5f, 0.5f);

    MinecraftClient.getInstance().getItemRenderer();
    ItemRenderer.renderItem(
        net.minecraft.item.ItemDisplayContext.FIXED,
        matrices,
        (VertexConsumerProvider) queue,
        0xF000F0,
        0,
        null, // tints
        null, // quads
        null, // layer
        null // glint
    );

    matrices.pop();
  }

  @Override
  public WeaponRackRenderState createRenderState() {
    return new WeaponRackRenderState();
  }
}

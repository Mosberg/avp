package dk.mosberg.client;

import dk.mosberg.client.render.WeaponRackRenderer;
import dk.mosberg.registry.ModBlockEntities;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class AVPClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    // This entrypoint is suitable for setting up client-specific logic, such as
    // rendering.

    BlockEntityRendererFactories.register(ModBlockEntities.WEAPON_RACK, WeaponRackRenderer::new);

  }
}
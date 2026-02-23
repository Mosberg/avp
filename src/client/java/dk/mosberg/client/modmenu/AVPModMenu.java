package dk.mosberg.client.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class AVPModMenu implements ModMenuApi {

  @Override
  public ConfigScreenFactory<?> getModConfigScreenFactory() {
    return parent -> new DummyConfigScreen(parent);
  }

  private static class DummyConfigScreen extends Screen {
    private final Screen parent;

    protected DummyConfigScreen(Screen parent) {
      super(Text.literal("AVP Config"));
      this.parent = parent;
    }

    @Override
    public void close() {
      this.client.setScreen(parent);
    }
  }
}

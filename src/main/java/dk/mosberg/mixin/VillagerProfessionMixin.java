package dk.mosberg.mixin;

import org.spongepowered.asm.mixin.Mixin;

import dk.mosberg.professions.ModProfessions;
import net.minecraft.village.VillagerProfession;

@Mixin(VillagerProfession.class)
public class VillagerProfessionMixin {
  // Placeholder – kept for future hooks if needed
  static {
    // Ensure class is loaded so ModProfessions static init runs
    ModProfessions.register();
  }
}

package net.dungeonhd.removesubanomalyone;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

/**
 * Entfernt Sub Anomaly 1 aus The Broken Script.
 *
 * {@link SubAnomalyRemover} kümmert sich um die Events,
 * {@link SubAnomalyMatcher} erkennt die entsprechende Entity.
 */
@Mod(Removesubanomalyone.MODID)
public class Removesubanomalyone {
    public static final String MODID = "removesubanomalyone";

    public Removesubanomalyone(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}

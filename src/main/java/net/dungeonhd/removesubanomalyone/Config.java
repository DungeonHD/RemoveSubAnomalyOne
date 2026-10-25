package net.dungeonhd.removesubanomalyone;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = Removesubanomalyone.MODID)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.ConfigValue<List<? extends String>> EXTRA_ENTITY_IDS = BUILDER
            .comment("Weitere Entity-IDs, die entfernt werden sollen.", "Sub Anomaly 1 wird immer entfernt (thebrokenscript:sub_anomaly_1).")
            .defineListAllowEmpty("extraEntityIds", List.of(), Config::validateId);

    static final ModConfigSpec SPEC = BUILDER.build();

    private static volatile Set<ResourceLocation> extraIds = Set.of();

    public static Set<ResourceLocation> extraIds() {
        return extraIds;
    }

    private static boolean validateId(final Object obj) {
        return obj instanceof String s && ResourceLocation.tryParse(s) != null;
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        if (event.getConfig().getSpec() != SPEC) return;

        Set<ResourceLocation> ids = new HashSet<>();
        for (String s : EXTRA_ENTITY_IDS.get()) {
            ResourceLocation id = ResourceLocation.tryParse(s);
            if (id != null) ids.add(id);
        }
        extraIds = Set.copyOf(ids);
    }
}
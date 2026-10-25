package net.dungeonhd.removesubanomalyone;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

final class SubAnomalyMatcher {
    static final String SUB_ANOMALY_1_CLASS = "dev.wendigodrip.thebrokenscript.entity.SubAnomaly1Entity";
    static final ResourceLocation SUB_ANOMALY_1_ID = ResourceLocation.fromNamespaceAndPath("thebrokenscript", "sub_anomaly_1");

    private SubAnomalyMatcher() {
    }

    static boolean isSubAnomalyOne(Entity entity) {
        if (SUB_ANOMALY_1_CLASS.equals(entity.getClass().getName())) return true;

        ResourceLocation key = BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType());
        return SUB_ANOMALY_1_ID.equals(key) || Config.extraIds().contains(key);
    }
}

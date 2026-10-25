package net.dungeonhd.removesubanomalyone;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = Removesubanomalyone.MODID)
public final class SubAnomalyRemover {
    private static final int SWEEP_INTERVAL_TICKS = 100;

    private SubAnomalyRemover() {
    }

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        if (SubAnomalyMatcher.isSubAnomalyOne(event.getEntity())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLevelTick(LevelTickEvent.Post event) {
        if (!(event.getLevel() instanceof ServerLevel level)) return;
        if (level.getGameTime() % SWEEP_INTERVAL_TICKS != 0) return;

        List<Entity> found = new ArrayList<>();
        for (Entity entity : level.getAllEntities()) {
            if (SubAnomalyMatcher.isSubAnomalyOne(entity)) found.add(entity);
        }
        found.forEach(Entity::discard);
    }
}

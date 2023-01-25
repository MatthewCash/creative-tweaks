package com.matthewcash.creativetweaks.tweaks;

import org.bukkit.event.EventPriority;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class NoSnowGolemDamage implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamage(EntityDamageEvent event) {
        LivingEntity entity = (LivingEntity) event.getEntity();
        if (entity.getType() == EntityType.SNOWMAN && !entity.getName().equals("Snow Golem")) {
            event.setCancelled(true);
            entity.setHealth(4);
        }
    }
}

package com.matthewcash.creativetweaks.tweaks;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import de.tr7zw.changeme.nbtapi.NBT;

public class NoSkeletonTraps implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntityType() != EntityType.SKELETON_HORSE)
            return;

        boolean isTrap = NBT
            .get(
                event.getEntity(),
                nbt -> (boolean) nbt.getBoolean("SkeletonTrap")
            );

        if (isTrap) {
            event.setCancelled(true);
        }
    }
}

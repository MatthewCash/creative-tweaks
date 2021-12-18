package com.matthewcash.creativetweaks.tweaks;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class NoSnowLayerAboveLava implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onSnowLayerFormation(org.bukkit.event.block.BlockFormEvent event) {
        if (event.getNewState().getType() != Material.SNOW) {
            return;
        }

        Material block2BelowType = event.getNewState().getBlock().getRelative(0, -2, 0).getType();

        if (block2BelowType == Material.LAVA) {
            event.setCancelled(true);
        }
    }
}

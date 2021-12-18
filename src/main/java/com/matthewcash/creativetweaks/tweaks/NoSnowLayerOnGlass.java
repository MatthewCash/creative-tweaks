package com.matthewcash.creativetweaks.tweaks;

import com.destroystokyo.paper.MaterialTags;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class NoSnowLayerOnGlass implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onSnowLayerFormation(org.bukkit.event.block.BlockFormEvent event) {
        if (event.getNewState().getType() != Material.SNOW) {
            return;
        }

        Material blockBelowType = event.getNewState().getBlock().getRelative(0, -1, 0).getType();

        if (MaterialTags.GLASS.isTagged(blockBelowType)) {
            event.setCancelled(true);
        }
    }
}

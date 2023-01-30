package com.matthewcash.creativetweaks.tweaks;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

public class NoIceFormation implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onIceFormation(BlockFormEvent event) {
        if (event.getNewState().getType() == Material.ICE) {
            event.setCancelled(true);
        }
    }
}

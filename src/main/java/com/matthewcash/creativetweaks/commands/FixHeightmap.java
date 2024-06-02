package com.matthewcash.creativetweaks.commands;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import com.matthewcash.creativetweaks.CreativeTweaks;

public class FixHeightmap implements CommandExecutor {
    @Override
    public boolean onCommand(
        CommandSender sender, Command command, String label, String[] args
    ) {
        Player player = (Player) sender;

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                Block block = player.getChunk().getBlock(x, 319, z);
                if (block == null || block.getType() != Material.AIR)
                    continue;

                block.setType(Material.STONE);

                BukkitScheduler scheduler = CreativeTweaks.getPlugin()
                    .getServer().getScheduler();
                scheduler.runTaskLater(CreativeTweaks.getPlugin(), () -> {
                    block.setType(Material.AIR);
                }, 1);
            }
        }

        player.sendMessage("Updated chunk!");

        return true;
    }
}

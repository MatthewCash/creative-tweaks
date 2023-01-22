package com.matthewcash.creativetweaks.commands;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FixSnow implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        long blocksUpdated = 0;
        Chunk chunk = player.getChunk();

        for (int x = 0; x < 16; x++) {
            for (int y = 30; y < 120; y++) {
                for (int z = 0; z < 16; z++) {
                    Block block = chunk.getBlock(x, y, z);
                    if (block == null)
                        continue;

                    if (block.getType() == Material.SNOW) {
                        block.setType(Material.AIR, true);
                        block.setType(Material.SNOW, true);
                        blocksUpdated++;
                    }
                }
            }
        }

        player.sendMessage(String.format("Updated %d blocks!", blocksUpdated));

        return true;
    }
}

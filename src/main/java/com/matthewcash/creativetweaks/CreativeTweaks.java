package com.matthewcash.creativetweaks;

import com.matthewcash.creativetweaks.commands.FixSnow;
import com.matthewcash.creativetweaks.tweaks.NoIceFormation;
import com.matthewcash.creativetweaks.tweaks.NoSnowGolemDamage;
import com.matthewcash.creativetweaks.tweaks.NoSnowLayerAboveLava;
import com.matthewcash.creativetweaks.tweaks.NoSnowLayerOnGlass;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CreativeTweaks extends JavaPlugin {
    private static CreativeTweaks plugin;

    public static CreativeTweaks getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;

        Bukkit.getPluginManager().registerEvents(new NoIceFormation(), this);
        Bukkit.getPluginManager().registerEvents(new NoSnowGolemDamage(), this);
        Bukkit.getPluginManager().registerEvents(new NoSnowLayerAboveLava(), this);
        Bukkit.getPluginManager().registerEvents(new NoSnowLayerOnGlass(), this);

        Bukkit.getPluginCommand("fixsnow").setExecutor(new FixSnow());

        getLogger().info("Enabled CreativeTweaks!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled CreativeTweaks!");
    }
}

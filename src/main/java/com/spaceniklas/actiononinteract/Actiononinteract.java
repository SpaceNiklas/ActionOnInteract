package com.spaceniklas.actiononinteract;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Actiononinteract extends JavaPlugin {
    public static FileConfiguration config;

    public static Actiononinteract instance;

    public void onEnable() {
        instance = this;
        getConfig();
        saveDefaultConfig();
        config = getConfig();
        Bukkit.getPluginManager().registerEvents(new Listeners(), (Plugin)this);
    }
}
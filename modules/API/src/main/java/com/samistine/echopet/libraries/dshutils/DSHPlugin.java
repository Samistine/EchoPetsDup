package com.samistine.echopet.libraries.dshutils;

import com.samistine.echopet.libraries.dshutils.config.YAMLConfigManager;
import com.samistine.echopet.libraries.dshutils.logger.ConsoleLogger;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public abstract class DSHPlugin extends JavaPlugin {

    private static DSHPlugin INSTANCE;
    private static Random r;
    private YAMLConfigManager configManager;

    public static DSHPlugin getPluginInstance() {
        return INSTANCE;
    }

    public YAMLConfigManager getConfigManager() {
        return configManager;
    }

    public static Random r() {
        return r;
    }

    @Override
    public void onEnable() {
        r = new Random();
        INSTANCE = this;
        this.configManager = new YAMLConfigManager(this);
        ConsoleLogger.initiate();
    }

    @Override
    public void onDisable() {
        INSTANCE = null;
    }
}
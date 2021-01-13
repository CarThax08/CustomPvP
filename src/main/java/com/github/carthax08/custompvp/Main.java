package com.github.carthax08.custompvp;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;

public final class Main extends JavaPlugin {

    private static Main instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static Main getInstance(){
        return instance;
    }
}

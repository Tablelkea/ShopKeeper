package org.plugins.shopkeeper;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ShopKeeper extends JavaPlugin {

    // TEST DE FONCTION POUR UN SHOPKEEPER v0

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("ride")).setExecutor(new RideCommand());
        Objects.requireNonNull(getCommand("addtrade")).setExecutor(new TradeCommand());
        Objects.requireNonNull(getCommand("gui")).setExecutor(new testGUI());
        getServer().getPluginManager().registerEvents(new testGUI(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

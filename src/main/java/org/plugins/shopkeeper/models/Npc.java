package org.plugins.shopkeeper.models;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Npc {

    private final UUID uuid;
    private final List<Trade> trades = new ArrayList<>();
    private String name;
    private Location location;

    public Npc(String name, Location location) {
        this.name = name;
        this.uuid = UUID.randomUUID();
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public void addTrades(List<Trade> trades) {
        this.trades.addAll(trades);
    }

    public void removeTrade(UUID uuid) {
        this.trades.removeIf(trade -> trade.getUuid() == uuid);
    }
}

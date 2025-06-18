package org.plugins.shopkeeper.models;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Trade {

    public static List<Trade> tradeList = new ArrayList<>();
    private final UUID uuid;
    private ItemStack require1;
    private ItemStack require2;
    private ItemStack reward;

    public Trade(ItemStack require1, ItemStack require2, ItemStack reward) {
        this.require1 = require1;
        this.require2 = require2;
        this.reward = reward;
        this.uuid = UUID.randomUUID();
        tradeList.add(this);
    }

    public ItemStack getRequire1() {
        return require1;
    }

    public void setRequire1(ItemStack require1) {
        this.require1 = require1;
    }

    public ItemStack getRequire2() {
        return require2;
    }

    public void setRequire2(ItemStack require2) {
        this.require2 = require2;
    }

    public ItemStack getReward() {
        return reward;
    }

    public void setReward(ItemStack reward) {
        this.reward = reward;
    }

    public UUID getUuid() {
        return uuid;
    }
}

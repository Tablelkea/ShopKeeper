package org.plugins.shopkeeper;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class testGUI implements CommandExecutor, Listener {

    static Inventory gui = Bukkit.createInventory(null, 36, "trades");
    static Villager entity;

    public static void getTrades() {

        ItemStack reward;
        ItemStack require1;
        ItemStack require2;

        List<MerchantRecipe> recipes = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            if (gui.getItem(i) != null && gui.getItem(i + 18) != null) {
                reward = gui.getItem(i);
                require1 = gui.getItem(i + 18);
                MerchantRecipe newRecipe = new MerchantRecipe(reward, 1000000);
                newRecipe.addIngredient(require1);
                if (gui.getItem(i + 9).getType() != Material.AIR) {
                    require2 = gui.getItem(i + 9);
                    newRecipe.addIngredient(require2);
                }
                recipes.add(newRecipe);
            }
        }

        entity.setRecipes(recipes);
    }

    public static Inventory guiManager() {

        gui.setItem(gui.getSize() - 1, new ItemStack(Material.GREEN_WOOL));

        return gui;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {

        if (sender instanceof Player player) {
            if (player.getTargetEntity(10) instanceof Villager) {
                entity = (Villager) player.getTargetEntity(10);
            }

            player.openInventory(guiManager());
        }

        return false;

    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == gui) {
            Material material = event.getCurrentItem().getType();

            if (material == Material.GREEN_WOOL) {
                event.setCancelled(true);
                getTrades();
                event.getWhoClicked().closeInventory();
            }
        }

    }
}

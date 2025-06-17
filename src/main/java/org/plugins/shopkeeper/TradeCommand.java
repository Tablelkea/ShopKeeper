package org.plugins.shopkeeper;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TradeCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        if (sender instanceof Player player) {
            if (args.length == 0) {
                player.sendMessage("slot1 = requis1, slot2 = requis2, slot3 = reward");
            } else if (args[0].equalsIgnoreCase("create")) {
                ItemStack slot1 = player.getInventory().getItem(0);
                ItemStack slot2 = player.getInventory().getItem(1);
                ItemStack reward = player.getInventory().getItem(2);

                Entity entity = player.getTargetEntity(10);

                if (entity instanceof Villager villager) {
                    villager.setAI(false);
                    villager.setProfession(Villager.Profession.ARMORER);

                    MerchantRecipe newTrade = new MerchantRecipe(reward, 1000000);
                    if (slot1 != null) {
                        newTrade.addIngredient(slot1);
                    }
                    if (slot2 != null) {
                        newTrade.addIngredient(slot2);
                    }

                    MerchantRecipe newTrade2 = new MerchantRecipe(new ItemStack(Material.STONE), 100000);
                    newTrade2.addIngredient(new ItemStack(Material.DIAMOND, 5));
                    newTrade2.addIngredient(new ItemStack(Material.EMERALD, 2));


                    villager.setRecipes(List.of(newTrade, newTrade2));

                }

            }
        }


        return false;
    }
}

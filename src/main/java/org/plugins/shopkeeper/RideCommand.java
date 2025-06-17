package org.plugins.shopkeeper;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.jetbrains.annotations.NotNull;


public class RideCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        Player player = (Player) commandSender;

        Villager villager = (Villager) player.getTargetEntity(5);
        if (villager != null) {
            player.sendMessage(villager.getRecipes().toString());
            player.sendMessage(villager.getRecipe(0).getIngredients().get(0).toString());
            player.sendMessage(villager.getRecipe(0).getIngredients().get(1).toString());
        }

        return false;
    }
}

package com.github.carthax08.custompvp.commands;

import com.github.carthax08.custompvp.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetRankCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            player.sendMessage("You are currently " + Util.getPlayerRankName(player) + " with " + Util.getPlayerRank(player) + " ranking points.");
            return true;
        }else{
            sender.sendMessage(ChatColor.GREEN + "You MUST be a player to run this command!");
            return true;
        }
    }
}

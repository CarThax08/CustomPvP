package com.github.carthax08.custompvp.commands;

import com.github.carthax08.custompvp.Main;
import com.github.carthax08.custompvp.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player sendingPlayer = (Player) sender;
            if(args[0].equalsIgnoreCase("setranking") && args.length > 2){
                OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
                if(Util.setRanking(player, Integer.parseInt(args[1]))){
                    sendingPlayer.sendMessage(ChatColor.GREEN + "Successfully set ranking of player.");
                }else{
                    sendingPlayer.sendMessage(ChatColor.RED + "Failed to set ranking.");
                }
            }else{
                sendingPlayer.sendMessage("Insufficient Arguments!");
                return true;
            }
        }else{
            if(args[0].equalsIgnoreCase("setrank") && args.length > 2){
                OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
                if(Util.setRanking(player, Integer.parseInt(args[1]))){
                    sender.sendMessage(ChatColor.GREEN + "Successfully set ranking of player.");
                }else{
                    sender.sendMessage(ChatColor.RED + "Failed to set ranking.");
                }
            }else{
                sender.sendMessage("Insufficient Arguments!");
                return true;
            }
        }
        return false;
    }
}

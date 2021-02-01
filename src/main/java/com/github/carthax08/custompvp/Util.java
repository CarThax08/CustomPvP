package com.github.carthax08.custompvp;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Util {
    private static Random rand;
    public static HashMap<OfflinePlayer, Integer> RankingMap = new HashMap<>();
    public static boolean isPlayerRanked(OfflinePlayer p){
        Main instance = Main.getInstance();
        return instance.getConfig().isSet(p.getUniqueId() + ".isRanked");
    }
    public static int getPlayerRank(OfflinePlayer p){
        return RankingMap.get(p);
    }
    public static String getPlayerRankName(OfflinePlayer p){
        Main instance = Main.getInstance();
        int ranking = RankingMap.get(p);
        if(ranking == 0){
            return "Unranked";
        }else if(ranking > 1 && ranking <= 20){
            return "Coal 1";
        }else if(ranking <= 40){
            return "Coal 2";
        }else if(ranking <= 60){
            return "Coal 3";
        }else if(ranking <= 80){
            return "Iron 1";
        }else if(ranking <= 100){
            return "Iron 2";
        }else if(ranking <= 120){
            return "Iron 3";
        }else if(ranking <= 140){
            return "Gold 1";
        }else if(ranking <= 160){
            return "Gold 2";
        }else if(ranking <= 180){
            return "Gold 3";
        }else if(ranking <= 200){
            return "Diamond 1";
        }else if(ranking <= 220){
            return "Diamond 2";
        }else if(ranking <= 240){
            return "Diamond 3";
        }else if(ranking <= 260){
            return "Emerald 1";
        }else if(ranking <= 280){
            return "Emerald 2";
        }else if(ranking <= 300){
            return "Emerald 3";
        }else {
            return "Obsidian";
        }
    }
    public static boolean hasJoinedBefore(OfflinePlayer p){
        return p.hasPlayedBefore();
    }
    public static boolean setRanking(OfflinePlayer p,int ranking){
        try{
            RankingMap.put(p, ranking);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public static void addOrRemoveRankingFromPlayer(OfflinePlayer p, Integer amountToChangeBy){
        int currentRanking = RankingMap.get(p);
        int newRanking = currentRanking + amountToChangeBy;
        RankingMap.put(p, newRanking);
        if(p.isOnline()) {
            if (newRanking > currentRanking) {
                if (checkIfIntBetween(newRanking, 20, 40) && currentRanking < 20) {
                    p.getPlayer().sendMessage("Congratulations on ranking up to Coal 2!");
                } else if (currentRanking < 40 && checkIfIntBetween(newRanking, 40, 60)) {
                    p.getPlayer().sendMessage("Congratulations on ranking up to Coal 3!");
                } else if (currentRanking < 60 && checkIfIntBetween(newRanking, 60, 80)) {
                    p.getPlayer().sendMessage("Congratulations on ranking up to Iron 1!");
                } else if (currentRanking < 80 && checkIfIntBetween(newRanking, 80, 100)) {
                    p.getPlayer().sendMessage("Congratulations on ranking up to Iron 2!");
                } else if (currentRanking < 100 && checkIfIntBetween(newRanking, 100, 120)) {
                    p.getPlayer().sendMessage("Congratulations on ranking up to Iron 3!");
                } else if (currentRanking < 120 && checkIfIntBetween(newRanking, 120, 140)) {
                    p.getPlayer().sendMessage("Congratulations on ranking up to Gold 1!");
                } else if (currentRanking < 140 && checkIfIntBetween(newRanking, 140, 160)) {
                    p.getPlayer().sendMessage("Congratulations on ranking up to Gold 2!");
                } else if (currentRanking < 160 && checkIfIntBetween(newRanking, 160, 180)) {
                    p.getPlayer().sendMessage("Congratulations on ranking up to Gold 3!");
                } else if (currentRanking < 180 && checkIfIntBetween(newRanking, 180, 200)) {
                    p.getPlayer().sendMessage("Congratulations on ranking up to Diamond 1!");
                } else if (currentRanking < 200 && checkIfIntBetween(newRanking, 200, 220)) {
                    p.getPlayer().sendMessage("Congratulations on ranking up to Diamond 2!");
                } else if (currentRanking < 220 && checkIfIntBetween(newRanking, 220, 240)) {
                    p.getPlayer().sendMessage("Congratulations on ranking up to Diamond 3!");
                } else if (currentRanking < 240 && checkIfIntBetween(newRanking, 240, 260)) {
                    p.getPlayer().sendMessage("Congratulations on ranking up to Emerald 1!");
                } else if (currentRanking < 260 && checkIfIntBetween(newRanking, 260, 280)) {
                    p.getPlayer().sendMessage("Congratulations on ranking up to Emerald 2!");
                } else if (currentRanking < 280 && checkIfIntBetween(newRanking, 280, 300)) {
                    p.getPlayer().sendMessage("Congratulations on ranking up to Emerald 3");
                } else if (currentRanking < 300) {
                    p.getPlayer().sendMessage("Congratulations on raking up to Obsidian!");
                }
            } else if (newRanking < currentRanking) {
                //WIP
            } else {
                p.getPlayer().sendMessage("Your rank didn't change.");
            }
        }
    }
    private static boolean checkIfIntBetween(Integer x, Integer y, Integer z){
        return x >= y && x <= z;
    }
    public static void teleportPlayers(ArrayList<Player> players, String GameMode){
        rand = new Random();
        WorldCreator World = new WorldCreator(GameMode + "-" + rand.nextInt(100000));
        World.type(WorldType.FLAT);
        World.generateStructures(false);
        World world = World.createWorld();
        for(int i = 0; i < players.size(); i++){
            if(GameMode.equalsIgnoreCase("1v1")) {
                //WIP
                if (i == 0) {
                    Block b = world.getBlockAt(100, 20, 100);
                    players.get(i).teleport(b.getLocation());
                }
            }
        }
    }

}

package com.github.carthax08.custompvp;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Util {
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
        }else if(ranking > 1 && ranking < 20){
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
}

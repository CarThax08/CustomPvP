package com.github.carthax08.custompvp.events;

import com.github.carthax08.custompvp.Main;
import com.github.carthax08.custompvp.Util;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onPlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        if(Util.hasJoinedBefore(e.getPlayer())){
            Util.RankingMap.put(e.getPlayer(),Main.getInstance().getConfig().getInt(e.getPlayer().getUniqueId() + ".ranking"));
        }else{
            Main.getInstance().getConfig().set(e.getPlayer().getUniqueId() + ".ranking", 0);
            Main.getInstance().getConfig().set(e.getPlayer().getUniqueId() + ".isRanked", false);
            Util.RankingMap.put(e.getPlayer(),0);
        }
    }
}

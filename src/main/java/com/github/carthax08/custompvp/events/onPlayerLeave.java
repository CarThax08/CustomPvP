package com.github.carthax08.custompvp.events;

import com.github.carthax08.custompvp.Main;
import com.github.carthax08.custompvp.Util;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onPlayerLeave implements Listener {
    @EventHandler
    public void onPlayerLeaveEvent(PlayerQuitEvent e){
        Main.getInstance().getConfig().set(e.getPlayer().getUniqueId() + ".ranking", Util.RankingMap.get(e.getPlayer()));
    }
}

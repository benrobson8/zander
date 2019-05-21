package com.shadowolfyt.zander.events;

import com.shadowolfyt.zander.ZanderMain;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayerOnQuit implements Listener {
    ZanderMain plugin;

    public PlayerOnQuit(ZanderMain instance) {
        plugin = instance;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();

        event.setQuitMessage("");
        if (player.isOp()) {
            event.setQuitMessage(ChatColor.GOLD + "Server Operator " + player.getName() + " has left the server");
        } else {
            event.setQuitMessage(ChatColor.YELLOW + player.getName() + " has left the server");
        }
    }
}

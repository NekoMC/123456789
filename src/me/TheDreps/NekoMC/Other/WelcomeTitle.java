package me.TheDreps.NekoMC.Other;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.connorlinfoot.titleapi.TitleAPI;

import me.TheDreps.NekoMC.NekoMC;
import net.md_5.bungee.api.ChatColor;

public class WelcomeTitle implements Listener{
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		
	
		FileConfiguration config = NekoMC.plugin.getConfig();
		String line1 = config.getString("WelcomeTitle.line1");
		String line2 = config.getString("WelcomeTitle.line2");
		
		TitleAPI.sendTitle(e.getPlayer(), 10, 40, 0, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "NekoMC", ChatColor.LIGHT_PURPLE + line1);
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				
				TitleAPI.sendTitle(e.getPlayer(), 0, 40, 20, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "NekoMC", ChatColor.LIGHT_PURPLE + line2);
				
			}
		}.runTaskLater(NekoMC.plugin, 39);
	}

}

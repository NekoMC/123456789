package me.TheDreps.NekoMC.Other;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.TheDreps.NekoMC.Misc.Rank;

public class ChatFormat implements Listener{
	
	Rank rank = new Rank();
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event){
		
		Player player = event.getPlayer();
		
	    
		event.setMessage(ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	    
	    String path = "=getRank= " + ChatColor.RESET + "=getName= " + ChatColor.GRAY + "=getMessage=";
	    
	    path = path.replace("=getMessage=", "%2$s").replace("=getName=", "%1$s");
	    
	    path = path.replace("=getRank=", rank.getColoredRank(player.getUniqueId()));

	    event.setFormat(path);
	  }

}

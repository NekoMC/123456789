package me.TheDreps.NekoMC.Misc;

import org.bukkit.ChatColor;

public class Messages {
	
	Rank rank = new Rank();
	
	public String getNoPermMsg(String type, String rankNeeded){
		String prefix = getPluginPrefix(type);
		String noPerm = prefix + "Sorry, this action requires [" + rank.getPrefix(rankNeeded) + "]";
		
		return noPerm;
	}
	
	public String getPluginPrefix(String type){
		
		if(type.equalsIgnoreCase("spawn")){
			return ChatColor.DARK_PURPLE + "Spawn" + ChatColor.DARK_GRAY + " | " + ChatColor.RESET;
		}
		
		
		return "Error 404";
	}

}

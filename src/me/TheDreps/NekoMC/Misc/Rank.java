package me.TheDreps.NekoMC.Misc;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Rank {

	public String getRank(UUID uuid) {

		Player player = Bukkit.getServer().getPlayer(uuid);
		if (player.hasPermission("rank.slt")) {
			return "SLT";
		}
		if (player.hasPermission("rank.admin")) {
			return "ADMIN";
		}
		if (player.hasPermission("rank.mod")) {
			return "MOD";
		}
		if (player.hasPermission("rank.default")) {
			return "No Rank";
		}
		return null;
	}

	public String getColoredRank(UUID uuid) {

		Player player = Bukkit.getServer().getPlayer(uuid);
		if (player.hasPermission("rank.slt")) {
			return ChatColor.DARK_RED + "" + ChatColor.BOLD + "SLT" + ChatColor.RESET;
		}
		if (player.hasPermission("rank.admin")) {
			return ChatColor.AQUA + "" + ChatColor.BOLD + "ADMIN" + ChatColor.RESET;
		}
		if (player.hasPermission("rank.mod")) {
			return ChatColor.GOLD + "" + ChatColor.BOLD + "MOD" + ChatColor.RESET;
		}
		if (player.hasPermission("rank.default")) {
			return "";
		}
		return "";
	}

	public String getPrefix(String rank) {

		String prefix = "";

		if (rank.equalsIgnoreCase("slt")) {
			prefix = ChatColor.DARK_RED + "" + ChatColor.BOLD + "SLT" + ChatColor.RESET;
		}else if(rank.equalsIgnoreCase("admin")){
			prefix = ChatColor.AQUA + "" + ChatColor.BOLD + "ADMIN" + ChatColor.RESET;
		}else if(rank.equalsIgnoreCase("mod")){
			prefix = ChatColor.GOLD + "" + ChatColor.BOLD + "MOD" + ChatColor.RESET;
		}

		return prefix;
	}

}

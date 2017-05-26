package me.TheDreps.NekoMC.Other;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.TheDreps.NekoMC.NekoMC;
import me.TheDreps.NekoMC.Misc.Messages;

public class SpawnTP implements Listener{
	
	Messages msg = new Messages();
	
	private String prefix = msg.getPluginPrefix("spawn");
	
	public FileConfiguration getConfig(){
		return NekoMC.plugin.getConfig();
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		
		Player p = e.getPlayer();
		
		if (getConfig().getConfigurationSection("spawn") == null) {
			p.sendMessage(prefix + "Teleport error, please contact a member of staff imediately. Thank you.");
		}
		
		World w = Bukkit.getServer().getWorld(getConfig().getString("spawn.world"));
		double x = getConfig().getDouble("spawn.x");
		double y = getConfig().getDouble("spawn.y");
		double z = getConfig().getDouble("spawn.z");
		Float pitch = (float) getConfig().getInt("spawn.pitch");
		Float yaw = (float) getConfig().getDouble("spawn.yaw");
		p.teleport(new Location(w, x, y, z, yaw, pitch));
		
	}

}

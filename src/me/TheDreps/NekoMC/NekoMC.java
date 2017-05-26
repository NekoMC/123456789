package me.TheDreps.NekoMC;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
/*
 * Main class
 */

import me.TheDreps.NekoMC.Cmd.SetSpawn;
import me.TheDreps.NekoMC.Other.ChatFormat;
import me.TheDreps.NekoMC.Other.SpawnTP;
import me.TheDreps.NekoMC.Other.WelcomeTitle;

public class NekoMC extends JavaPlugin{
	
	public static NekoMC plugin;
	
	
	public void onEnable(){
		loadConfiguration();
		start();
		plugin = this;
	}
	
	
	public void onDisable(){
		
	}
	
	
	
	public void loadConfiguration(){
	     getConfig().options().copyDefaults(true);
	     saveConfig();
	}
	

	public String serverType(){
		String config = getConfig().getString("Server").trim().toUpperCase();

		return config;
	}
	
	
	
	////////////////////////////////////
	
	public void start(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		
		if(serverType().equalsIgnoreCase("HUB")){
			pm.registerEvents(new ChatFormat(), this);
			pm.registerEvents(new SpawnTP(), this);
			pm.registerEvents(new WelcomeTitle(), this);
			
			getCommand("setspawn").setExecutor(new SetSpawn());
		}
		
		
	}
	
	
	
}

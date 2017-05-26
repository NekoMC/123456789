package me.TheDreps.NekoMC.Cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import me.TheDreps.NekoMC.NekoMC;
import me.TheDreps.NekoMC.Misc.Messages;

public class SetSpawn implements CommandExecutor {

	Messages msg = new Messages();

	private String prefix = msg.getPluginPrefix("spawn");

	public FileConfiguration getConfig() {
		return NekoMC.plugin.getConfig();
	}

	public void saveConfig() {
		NekoMC.plugin.saveConfig();
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(prefix + "This command is for players only!");
			return true;
		}

		Player p = (Player) sender;

		if (sender.hasPermission("spawn.setspawn")) {
			if (cmd.getName().equalsIgnoreCase("setspawn")) {
				getConfig().set("spawn.world", p.getLocation().getWorld().getName());
				getConfig().set("spawn.x", p.getLocation().getX());
				getConfig().set("spawn.y", p.getLocation().getY());
				getConfig().set("spawn.z", p.getLocation().getZ());
				getConfig().set("spawn.pitch", p.getLocation().getPitch());
				getConfig().set("spawn.yaw", p.getLocation().getYaw());
				saveConfig();
				p.sendMessage(prefix + "Spawn set!");
				return true;
			}
		} else {
			p.sendMessage(msg.getNoPermMsg("spawn", "slt"));
		}

		return true;
	}
}
package me.potatofarms.entitypolice;

import java.util.logging.Logger;
import me.potatofarms.entitypolice.entityCounter;
import me.potatofarms.entitypolice.entityCounterNear;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class EntityPolice extends JavaPlugin {
	public final Logger logger = Logger.getLogger("minecraft");
	public static EntityPolice plugin;

	@Override
	public void onEnable() {
		PluginDescriptionFile pdffile = this.getDescription();
		this.logger.info(pdffile.getName() + " version " + pdffile.getVersion()
				+ " has been enabled.");
	}

	@Override
	public void onDisable() {
		PluginDescriptionFile pdffile = this.getDescription();
		this.logger.info(pdffile.getName() + " has been disabled.");
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player player = (Player) sender;

		if (commandLabel.equalsIgnoreCase("entitypolice")
				|| commandLabel.equalsIgnoreCase("ep")) {

			entityCounter ec = new entityCounter();
			entityRemover er = new entityRemover();
			String subCommand = args.length > 0 ? args[0].toLowerCase() : "";
			if (subCommand.equalsIgnoreCase("count")) {
				if (player.hasPermission("entitypolice.count")) {

					// /entitypolice count
					String entityName = args.length >= 2 ? args[1]
							.toLowerCase() : "";
					String worldName = args.length == 3 ? args[2].toLowerCase()
							: "";
					PluginDescriptionFile pdffile = this.getDescription();
					if (args.length >= 2) {
						String count = ec.countEntity(player, entityName,
								worldName, pdffile.getName(), args);
						player.sendMessage(count);
						return true;
					} else {
						return false;
					}
				} else {
					player.sendMessage(ChatColor.RED
							+ "You do not have permission to do this.");
					return true;
				}

			} else if (subCommand.equalsIgnoreCase("remove")) {
				if (player.hasPermission("entitypolice.remove")) {

					// /entitypolice count
					String entityName = args.length >= 2 ? args[1]
							.toLowerCase() : "";
					String worldName = args.length == 3 ? args[2].toLowerCase()
							: "";
					PluginDescriptionFile pdffile = this.getDescription();
					if (args.length >= 2) {
						String remove = er.removeEntities(player, entityName,
								worldName, pdffile.getName(), args);
						player.sendMessage(remove);
						return true;
					} else {
						return false;
					}
				} else {
					player.sendMessage(ChatColor.RED
							+ "You do not have permission to do this.");
					return true;
				}
			} else if (subCommand.equalsIgnoreCase("countnear")) {
				if (player.hasPermission("entitypolice.countnear")) {
					entityCounterNear ecn = new entityCounterNear();
					String playerName = args.length >= 1 ? args[1] : "";
					Player playerC = Bukkit.getServer().getPlayer(playerName);
					String mobName = args.length >= 2 ? args[2] : "";
					String sr = args.length >= 3 ? args[3] : "";
					double x = Double.valueOf(sr);
					double y = Double.valueOf(sr);
					double z = Double.valueOf(sr);
					PluginDescriptionFile pdffile = this.getDescription();
					String countnear = ecn.countEntitiesNear(playerC, x, y, z,
							mobName, pdffile.getName());
					player.sendMessage(countnear);
					return true;
				} else {
					player.sendMessage(ChatColor.RED
							+ "You do not have permission to do this.");
					return true;
				}
			} else if (subCommand.equalsIgnoreCase("removenear")) {
				if (player.hasPermission("entitypolice.removenear")) {
					entityRemoverNear ern = new entityRemoverNear();
					String playerName = args.length >= 1 ? args[1] : "";
					Player playerC = Bukkit.getServer().getPlayer(playerName);
					String mobName = args.length >= 2 ? args[2] : "";
					String sr = args.length >= 3 ? args[3] : "";
					double x = Double.valueOf(sr);
					double y = Double.valueOf(sr);
					double z = Double.valueOf(sr);
					PluginDescriptionFile pdffile = this.getDescription();
					String countnear = ern.removeEntitiesNear(playerC, x, y, z,
							mobName, pdffile.getName());
					player.sendMessage(countnear);
					return true;
				} else {
					player.sendMessage(ChatColor.RED
							+ "You do not have permission to do this.");
					return true;
				}

			} else if (subCommand.equalsIgnoreCase("help")) {
				if (player.hasPermission("entitypolice.help")) {
					player.sendMessage(ChatColor.GOLD + "EntityPolice Help:");
					player.sendMessage(ChatColor.GOLD + "Commands:");
					player.sendMessage(ChatColor.BLUE + "/entitypolice"
							+ ChatColor.AQUA
							+ " count <mob> <(optional) world>"
							+ ChatColor.YELLOW
							+ " - Returns the number of <mob> in <world>");
					player.sendMessage(ChatColor.BLUE
							+ "/entitypolice"
							+ ChatColor.AQUA
							+ " remove <mob> <(optional) world>"
							+ ChatColor.YELLOW
							+ " - Removes all the mobs of type <mob> in <world>");
					player.sendMessage(ChatColor.BLUE
							+ "/entitypolice"
							+ ChatColor.AQUA
							+ " removenear <player> <mob> <radius>"
							+ ChatColor.YELLOW
							+ " - Removes all mobs of type <mob> around player <player> within the radius of <radius>");
					player.sendMessage(ChatColor.BLUE
							+ "/entitypolice"
							+ ChatColor.AQUA
							+ " countnear <player> <mob> <radius>"
							+ ChatColor.YELLOW
							+ " - Counts all mobs of type <mob> around player <player> within the radius of <radius>");
					return true;
				} else {
					player.sendMessage(ChatColor.RED
							+ "You do not have permission to do this.");
					return true;
				}
			}

		}
		return false;
	}
}
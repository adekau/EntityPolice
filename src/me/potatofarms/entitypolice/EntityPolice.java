package me.potatofarms.entitypolice;

import me.potatofarms.entitypolice.EntityNames;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Animals;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.entity.Squid;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class EntityPolice extends JavaPlugin {
	public final Logger logger = Logger.getLogger("minecraft");
	public static EntityPolice plugin;

	@Override
	public void onEnable() {
		logger.info("Loaded....");
	}

	@Override
	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player player = (Player) sender;

		if (commandLabel.equalsIgnoreCase("entitypolice")) {
			String subCommand = args.length > 0 ? args[0].toLowerCase() : "";
			if (subCommand.equalsIgnoreCase("count")) {
				// /entitypolice count
				String entityName = args[1];
				String worldName = args.length == 3 ? args[2].toLowerCase()
						: "";
				Integer total = 0;
				List<World> world = new ArrayList<World>();
				if (args.length == 3 && worldName.equalsIgnoreCase("all")) {
					for (World w : Bukkit.getServer().getWorlds()) {
						world.add(w);
						continue;
					}
				} else if (args.length == 3) {
					if (Bukkit.getServer().getWorld(worldName) == null) {
						player.sendMessage(ChatColor.RED + "Invalid world.");
						return false;
					} else {
						world.add(Bukkit.getServer().getWorld(worldName));
					}

				} else if (args.length == 2) {
					world.add(player.getWorld());
				} else {
					return false;
				}

				for (World w : world) {

					Boolean validEntityName = false;
					for (EntityNames en : EntityNames.values()) {
						String theName = en.getName();
						if (theName.equalsIgnoreCase(entityName)) {
							validEntityName = true;
						} else {

						}
						continue;
					}
					if (validEntityName == true
							&& !entityName.equalsIgnoreCase("monster")
							&& !entityName.equalsIgnoreCase("animal")
							&& !entityName.equalsIgnoreCase("mob")
							&& !entityName.equalsIgnoreCase("squid")) {

						for (LivingEntity f : w.getLivingEntities()) {
							if (f.getType().toString()
									.equalsIgnoreCase(entityName)) {
								total++;
								continue;
							}

						}

					} else if (validEntityName == true
							&& entityName.equalsIgnoreCase("monster")) {
						for (LivingEntity f : w.getLivingEntities()) {
							if (f instanceof Monster) {
								total++;
								continue;
							}

						}
					} else if (validEntityName == true
							&& entityName.equalsIgnoreCase("animal")) {
						for (LivingEntity f : w.getLivingEntities()) {
							if (f instanceof Animals) {
								total++;
								continue;
							}
						}
					} else if (validEntityName == true
							&& entityName.equalsIgnoreCase("squid")) {
						for (LivingEntity f : w.getLivingEntities()) {
							if (f instanceof Squid) {
								total++;
								continue;
							}
						}

					} else if (validEntityName == true
							&& entityName.equalsIgnoreCase("mob")) {
						for (LivingEntity f : w.getLivingEntities()) {
							if (f instanceof Animals) {
								total++;
								continue;
							} else if (f instanceof Monster) {
								total++;
								continue;

							} else if (f instanceof Squid) {
								total++;
								continue;

							}
						}
					} else {
						player.sendMessage(ChatColor.RED + "Invalid Entity");
						return false;
					}
					continue;
				}
				PluginDescriptionFile pdffile = this.getDescription();

				player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD
						+ pdffile.getName() + ChatColor.GREEN + "] There are "
						+ ChatColor.BLUE + total.toString() + ChatColor.GREEN
						+ " " + entityName + "s.");
			}

		}
		return false;
	}
}
package me.potatofarms.entitypolice;

import java.util.logging.Logger;
import me.potatofarms.entitypolice.entityCounter;
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
		logger.info("Loaded....");
	}

	@Override
	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player player = (Player) sender;

		if (commandLabel.equalsIgnoreCase("entitypolice")) {
			entityCounter ec = new entityCounter();
			String subCommand = args.length > 0 ? args[0].toLowerCase() : "";
			if (subCommand.equalsIgnoreCase("count")) {
				// /entitypolice count
				String entityName = args[1];
				String worldName = args.length == 3 ? args[2].toLowerCase()
						: "";
				PluginDescriptionFile pdffile = this.getDescription();
				String count = ec.countEntity(player, entityName, worldName, pdffile.getName(), args);
				player.sendMessage(count);
			}

		}
		return false;
	}
}
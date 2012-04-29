package me.potatofarms.entitypolice;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Golem;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Monster;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Squid;

public class entityRemover {
	public String removeEntities(Player player, String entityName,
			String worldName, String pluginName, String[] args) {
		Integer total = 0;
		List<World> world = new ArrayList<World>();
		if (args.length == 3 && worldName.equalsIgnoreCase("all")) {
			for (World w : Bukkit.getServer().getWorlds()) {
				world.add(w);
				continue;
			}
		} else if (args.length == 3) {
			if (Bukkit.getServer().getWorld(worldName) == null) {
				return ChatColor.RED + "Invalid world.";
			} else {
				world.add(Bukkit.getServer().getWorld(worldName));
			}

		} else if (args.length == 2) {
			world.add(player.getWorld());
		} else {

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
					&& !entityName.equalsIgnoreCase("squid")
					&& !entityName.equalsIgnoreCase("PigZombie")
					&& !entityName.equalsIgnoreCase("MagmaCube")
					&& !entityName.equalsIgnoreCase("MushroomCow")
					&& !entityName.equalsIgnoreCase("IronGolem")
					&& !entityName.equalsIgnoreCase("Golem")
					&& !entityName.equalsIgnoreCase("Enderman")) {
				for (LivingEntity f : w.getLivingEntities()) {
					if (f.getType().toString().equalsIgnoreCase(entityName)) {
						total++;
						f.remove();
						continue;
					}

				}

			} else if (validEntityName == true
					&& entityName.equalsIgnoreCase("monster")) {
				for (LivingEntity f : w.getLivingEntities()) {
					if (f instanceof Monster) {
						total++;
						f.remove();
						continue;
					}

				}
			} else if (validEntityName == true
					&& entityName.equalsIgnoreCase("animal")) {
				for (LivingEntity f : w.getLivingEntities()) {
					if (f instanceof Animals) {
						total++;
						f.remove();
						continue;
					}
				}
			} else if (validEntityName == true
					&& entityName.equalsIgnoreCase("squid")) {
				for (LivingEntity f : w.getLivingEntities()) {
					if (f instanceof Squid) {
						total++;
						f.remove();
						continue;
					}
				}

			} else if (validEntityName == true
					&& entityName.equalsIgnoreCase("mob")) {
				for (LivingEntity f : w.getLivingEntities()) {
					if (f instanceof Animals) {
						total++;
						f.remove();
						continue;
					} else if (f instanceof Monster) {
						total++;
						f.remove();
						continue;

					} else if (f instanceof Squid) {
						total++;
						f.remove();
						continue;

					}
				}
			} else if (validEntityName == true
					&& entityName.equalsIgnoreCase("MagmaCube")) {
				for (LivingEntity f : w.getLivingEntities()) {
					if (f instanceof MagmaCube) {
						total++;
						f.remove();
						continue;
					}
				}
			} else if (validEntityName == true
					&& entityName.equalsIgnoreCase("Enderman")) {
				for (LivingEntity f : w.getLivingEntities()) {
					if (f instanceof Enderman) {
						total++;
						f.remove();
						continue;
					}
				}
			} else if (validEntityName == true
					&& entityName.equalsIgnoreCase("PigZombie")) {
				for (LivingEntity f : w.getLivingEntities()) {
					if (f instanceof PigZombie) {
						total++;
						f.remove();
						continue;
					}
				}
			} else if (validEntityName == true
					&& entityName.equalsIgnoreCase("MushroomCow")) {
				for (LivingEntity f : w.getLivingEntities()) {
					if (f instanceof MushroomCow) {
						total++;
						f.remove();
						continue;
					}
				}
			} else if (validEntityName == true
					&& entityName.equalsIgnoreCase("irongolem")) {
				for (LivingEntity f : w.getLivingEntities()) {
					if (f instanceof IronGolem) {
						total++;
						f.remove();
						continue;
					}
				}
			} else if (validEntityName == true
					&& entityName.equalsIgnoreCase("golem")) {
				for (LivingEntity f : w.getLivingEntities()) {
					if (f instanceof Golem) {
						total++;
						f.remove();
						continue;
					}
				}
			}

			else {

				return ChatColor.RED + "Invalid Entity";

			}
			continue;
		}

		return ChatColor.GOLD + "[" + pluginName + "]" + ChatColor.GREEN
				+ " Removed " + ChatColor.WHITE + total.toString()
				+ ChatColor.GREEN + " " + entityName + "s.";
	}
}

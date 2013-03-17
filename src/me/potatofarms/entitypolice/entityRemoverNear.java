package me.potatofarms.entitypolice;

import org.bukkit.ChatColor;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Golem;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Monster;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.Skeleton.SkeletonType;

public class entityRemoverNear {
	public String removeEntitiesNear(Player playerC, double x, double y,
			double z, String entityName, String pluginName) {
		Integer all = 0;

		Boolean validEntityName = false;
		for (EntityNames en : EntityNames.values()) {
			String theName = en.getName();
			if (theName.equalsIgnoreCase(entityName)) {
				validEntityName = true;
			} else {
				continue;
			}
			continue;
		}
		if (validEntityName == true && !entityName.equalsIgnoreCase("monster")
				&& !entityName.equalsIgnoreCase("animal")
				&& !entityName.equalsIgnoreCase("mob")
				&& !entityName.equalsIgnoreCase("squid")
				&& !entityName.equalsIgnoreCase("PigZombie")
				&& !entityName.equalsIgnoreCase("MagmaCube")
				&& !entityName.equalsIgnoreCase("MushroomCow")
				&& !entityName.equalsIgnoreCase("IronGolem")
				&& !entityName.equalsIgnoreCase("Golem")
				&& !entityName.equalsIgnoreCase("Skeleton")
				&& !entityName.equalsIgnoreCase("WitherSkeleton")
				&& !entityName.equalsIgnoreCase("Zombie")
				&& !entityName.equalsIgnoreCase("ZombieVillager")
				&& !entityName.equalsIgnoreCase("Enderman")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if (f.getType().toString().equalsIgnoreCase(entityName)) {
					all++;
					continue;
				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("monster")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if (f instanceof Monster) {
					f.remove();
					all++;
				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("animal")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if (f instanceof Animals) {
					f.remove();
					all++;
				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("mob")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if (f instanceof Animals) {
					f.remove();
					all++;
					continue;
				} else if (f instanceof Monster) {
					f.remove();
					all++;
					continue;

				} else if (f instanceof Squid) {
					f.remove();
					all++;
					continue;

				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("squid")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if (f instanceof Squid) {
					f.remove();
					all++;
				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("PigZombie")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if (f instanceof PigZombie) {
					f.remove();
					all++;
				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("MushroomCow")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if (f instanceof MushroomCow) {
					f.remove();
					all++;
				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("PigZombie")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if (f instanceof Monster) {
					f.remove();
					all++;
				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("PigZombie")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if (f instanceof Monster) {
					f.remove();
					all++;
				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("Skeleton")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if (f instanceof Skeleton) {
					if(((Skeleton) f).getSkeletonType() == SkeletonType.NORMAL) {
						f.remove();
						all++;	
					}	
				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("WitherSkeleton")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if(((Skeleton) f).getSkeletonType() == SkeletonType.WITHER) {
					f.remove();
					all++;	
				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("Zombie")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if(((Zombie) f).isVillager() == false) {
					f.remove();
					all++;
				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("ZombieVillager")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if(((Zombie) f).isVillager() == true) {
					f.remove();
					all++;
				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("MagmaCube")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if (f instanceof MagmaCube) {
					f.remove();
					all++;
				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("IronGolem")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if (f instanceof IronGolem) {
					f.remove();
					all++;
				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("Golem")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if (f instanceof Golem) {
					f.remove();
					all++;
				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("Enderman")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if (f instanceof Enderman) {
					f.remove();
					all++;
				}
			}
		}

		else {
			return ChatColor.RED + "Invalid Entity.";
		}

		return ChatColor.GOLD + "[" + pluginName + "]" + ChatColor.GREEN
				+ " Removed " + ChatColor.WHITE + all.toString()
				+ ChatColor.GREEN + " " + entityName + "s near "
				+ playerC.getName();

	}
}

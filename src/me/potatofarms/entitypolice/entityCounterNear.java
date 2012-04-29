package me.potatofarms.entitypolice;

import org.bukkit.entity.Player;

public class entityCounterNear {
	public String countEntitiesNear(Player playerC, double x, double y,
			double z, String entityName) {
		Integer all = 0;
		//for (Entity f : playerC.getNearbyEntities(x, y, z)) {
			
		//}
		return "There are " + all.toString() + " monsters nearby "
				+ playerC.getName();
		
	}
}

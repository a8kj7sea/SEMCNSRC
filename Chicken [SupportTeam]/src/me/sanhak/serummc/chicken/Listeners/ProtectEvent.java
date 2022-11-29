package me.sanhak.serummc.chicken.Listeners;

import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import me.sanhak.serummc.chicken.methods.CutsMethods;

/**
 * [<b>SerumMC Development Team</b>] <br>
 * <br>
 * <b>ProtectEvent</b> class , It class contains EntityDamageEvent i used it to
 * save cl (chicken life) life lmao <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class ProtectEvent implements Listener { // Start

	// This method i used it to save cl (chicken life) life lmao
	@EventHandler
	public void SaveClLife(EntityDamageEvent e) {
		Player p = (Player) e.getEntity();
		Chicken c = (Chicken) e.getEntity();
		if (p instanceof Chicken) { // Check if player instanceof Chicken
			if (c.getCustomName().equalsIgnoreCase(CutsMethods.Chicken_Name)) { // Check if chicken name equals
																				// chickname life (from configuration file)
																				// If Yes (True) will cancel the damage
				e.setCancelled(true);
			} else {// Check if chicken name not equal chicken life name (from configuration file)
				// If no (False) will cancel the damage also ! cuz it for lobby plugin not for
				// pvp game !!
				e.setCancelled(true);
			}
		}

	}

	// This code down is deprecated

//	@EventHandler
//	public void onDamageByEntity(EntityDamageEvent event) {
//		if (event.getCause().equals(DamageCause.VOID)) {
//			event.setCancelled(true);
//		}
//
//		if (!event.getCause().equals(DamageCause.FIRE_TICK) && !event.getCause().equals(DamageCause.ENTITY_ATTACK)
//				&& !event.getCause().equals(DamageCause.LAVA) && !event.getCause().equals(DamageCause.FALL)
//				&& !event.getCause().equals(DamageCause.FALLING_BLOCK)
//				&& !event.getCause().equals(DamageCause.ENTITY_ATTACK)
//				&& !event.getCause().equals(DamageCause.CUSTOM)) {
//			if (!event.getCause().equals(DamageCause.CUSTOM)) {
//				event.setCancelled(true);
//			}
//		} else {
//			event.setCancelled(true);
//		}
//
//	}

} // End

package me.sanhak.serummc.chicken.Listeners;

import org.bukkit.Sound;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import me.sanhak.serummc.chicken.Main.Main;
import me.sanhak.serummc.chicken.methods.CutsMethods;
import me.sanhak.serummc.chicken.methods.Methods;

/**
 * [<b>SerumMC Development Team</b>] <br>
 * <br>
 * <b>InteractEvents</b> class , It class contains PlayerInteractEntityEvent i
 * used it to send messages to player when click on chicken life and i used it
 * for remove chick life <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class InteractEvents implements Listener { // Start

	// This method i used it to send messages to player when click on chicken life and i used it
	@EventHandler
	public void onClickonChickenLife(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		if (e.getRightClicked() instanceof Chicken) { // if RightClicked instanceof Chicken
			e.setCancelled(true); // cancel
			Chicken c = (Chicken) e.getRightClicked(); // Get the chicken entity after right click on it | idk if it
														// right !!
			if (c.getCustomName().equalsIgnoreCase(CutsMethods.Chicken_Name)) { // Check if chicken name equal Chicken
																				// life name (from Configuration file) /
																				// if Yes (True) will send messages from
																				// Configuration file (config.yml)
				for (String msg : CutsMethods.list) {
					p.sendMessage(Methods.f(msg)); // Send the Messages
				}
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F); // Play sound after successful the process
			}

		}

		if (p.hasPermission("chicken.admin") && Main.RemoveMode.contains(p)) { // Check if Player have permissions to
																				// remove chicken and inside array list
																				// (RemoveMode) if Yes (True) he can
																				// remove the chicken life and if not
																				// will ingore him
			if (e.getRightClicked() instanceof Chicken) { // Check if RightClick instanceof Chicken
				Chicken c = (Chicken) e.getRightClicked(); // Get Chicken after right Click
				if (c.getCustomName().equalsIgnoreCase(CutsMethods.Chicken_Name)) { // Check if chicken name equal
																					// Chicken life name (from
																					// Configuration file) / if Yes
																					// (True) will send message and
																					// remove the chicken life (like
																					// down)
					p.sendMessage(Methods.f("&aThe Chicken has been Removed successfully :( with age " + c.getAge())); // Send
																														// Message
					e.getRightClicked().remove(); // Remove the Chickend life
				} else { // Check if chicken name not equal Chicken life name (from Configuration file)
							// send message like down
					p.sendMessage(Methods.f("This not a super chicken life !")); // Send Message
				}

			}
		}

	}

} // End

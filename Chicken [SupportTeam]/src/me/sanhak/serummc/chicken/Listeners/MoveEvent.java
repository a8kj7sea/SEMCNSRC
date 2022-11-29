package me.sanhak.serummc.chicken.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.sanhak.serummc.chicken.configuration.Configuration;
import me.sanhak.serummc.chicken.methods.CutsMethods;
import me.sanhak.serummc.chicken.methods.Methods;

/**
 * [<b>SerumMC Development Team</b>] <br>
 * <br>
 * <b>MoveEvent</b> class , It class contains PlayerMoveEvent i used it to check
 * if the chicken life entity is in void or not if in void teleport to hub spawn
 * and if dead :( spawn another one , its work when player move with 20 ticks
 * maybe it good idk i'll try soon (Demo) <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */
public class MoveEvent implements Listener { // Start

	// This method to check on cl (Chicken Life) life lmao every player moved !! | i
	// think it will take alot of engery but it's demo
	@EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
	public void onMove(PlayerMoveEvent e) {
		for (Entity chicken : Bukkit.getWorld(Configuration.getConfig().getString("Chicken.World-Name"))
				.getEntitiesByClass(Chicken.class)) { // Get the Entity from class use for each
			if (chicken.getCustomName().equalsIgnoreCase(CutsMethods.Chicken_Name)) { // Check if chicken name equals
																						// chickname life (from
																						// configuration file)
																						// If Yes (True) will check on
																						// chicken Location and else
																						// will ignore

				if (chicken.getLocation().getY() <= 15) { // Check if chicken life location cords (Y) less or equal 15 /
															// if yes (True) will teleport the chicken to loacation from
															// Configuration file (if not dead !) / and if dead will
															// spawn new one
					if (!(chicken.isDead())) { // if the chicken life not dead and in Y less or equal than 15 will
												// teleport to location from configuration file
						chicken.teleport(
								new Location(Bukkit.getWorld(Configuration.getConfig().getString("Chicken.World-Name")),
										Configuration.getConfig().getInt("Chicken.Loc-X"),
										Configuration.getConfig().getInt("Chicken.Loc-Y"),
										Configuration.getConfig().getInt("Chicken.Loc-Z"))); // Teleport the chicken
																								// life
					} else { // if the chicken life dead will spawn a new chicken in custom location
						Methods.SpawnChickenWithCustomLocation(
								new Location(Bukkit.getWorld(Configuration.getConfig().getString("Chicken.World-Name")),
										Configuration.getConfig().getInt("Chicken.Loc-X"),
										Configuration.getConfig().getInt("Chicken.Loc-Y"),
										Configuration.getConfig().getInt("Chicken.Loc-Z")));
					}

					// b3deen b3d al f79 5leeha tro7 3nd la3b 3shaw2i aw she kda (Demo version
					// specially this class)
				}
			}
		}
	}

} // End

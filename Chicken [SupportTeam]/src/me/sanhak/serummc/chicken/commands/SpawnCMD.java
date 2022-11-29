package me.sanhak.serummc.chicken.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import me.sanhak.serummc.chicken.configuration.Configuration;
import me.sanhak.serummc.chicken.methods.CutsMethods;
import me.sanhak.serummc.chicken.methods.Logger;
import me.sanhak.serummc.chicken.methods.Methods;

/**
 * [<b>SerumMC Development Team</b>] <br>
 * <br>
 * <b>Methods</b> class , It contains on Command allow to the players with
 * permissions to spawn the chicken entity <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class SpawnCMD implements CommandExecutor { // Start

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (!(cs instanceof Player)) { // If player use command from console return false and send message !
			Logger.Warn("&cThis Command Just for Players , you can't use this command from Console !!");
			return false;
		}

		Player p = (Player) cs;
		if (p.hasPermission("chicken.admin")) { // If player has permissions
			if (args.length == 0) { // if player use command without args like /sscl
				// Spawn the Super Chicken Life
				// Store the Chicken life location in configuration file
				Check(p);
			} else { // If player use the wrong command!
				p.sendMessage(Methods.f("&cWrong use please try to type &f/sscl"));
			}
		} else { // if player hasn't permissions !
			p.sendMessage(Methods.f("&cYou don't have enough of permissions to use this command !"));
			p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5, 5);
		}

		return false;
	}

	// This Method Check if Player use command to spawn new Chicken but chicken
	// exists
	public void Check(Player p) {
		for (Entity chicken : Bukkit.getWorld(Configuration.getConfig().getString("Chicken.World-Name"))
				.getEntitiesByClass(Chicken.class)) { // Get the Entity from class use for each
			if (chicken.getCustomName().equalsIgnoreCase(CutsMethods.Chicken_Name)) { // Check if chicken name equals
																						// chickname life (from
																						// configuration file)
				if (chicken.isDead()) { // if dead spawn new one
					// Spawn the Super Chicken Life
					// Store the Chicken life location in configuration file
					Methods.SpawnChicken(p);
					Configuration.getConfig().set("Chicken.World-Name", p.getLocation().getWorld());
					Configuration.getConfig().set("Chicken.Loc-X", p.getLocation().getBlockX());
					Configuration.getConfig().set("Chicken.Loc-Y", p.getLocation().getBlockY());
					Configuration.getConfig().set("Chicken.Loc-Z", p.getLocation().getBlockZ());
					Configuration.save();
					p.sendMessage(Methods.f("&aSuccessfully set the chicken !"));
				} else { // if not dead remove the last one and spawn new one
					// Remove the last chicken on life
					// Spawn the Super Chicken Life
					// Store the Chicken life location in configuration file
					chicken.remove();
					Methods.SpawnChicken(p);
					Configuration.getConfig().set("Chicken.World-Name", p.getLocation().getWorld());
					Configuration.getConfig().set("Chicken.Loc-X", p.getLocation().getBlockX());
					Configuration.getConfig().set("Chicken.Loc-Y", p.getLocation().getBlockY());
					Configuration.getConfig().set("Chicken.Loc-Z", p.getLocation().getBlockZ());
					Configuration.save();
					p.sendMessage(Methods.f("&aSuccessfully set the chicken !"));
				}
			}
		}
	}

} // End

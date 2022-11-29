package me.sanhak.serummc.chicken.methods;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.sanhak.serummc.chicken.configuration.Configuration;

/**
 * [<b>SerumMC Development Team</b>] <br>
 * <br>
 * <b>Methods</b> class , It contains a little methods and functions that help
 * the plug-in <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class Methods { // Start

	// This method to translate color codes
	// Example on usages -> p.sendMessage(f("&bHello Worst World !!!"));
	public static String f(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}

	// This method to spawn the chicken entity with custom name from config.yml
	// (Configuration file) | assert With Player Location !!;
	public static void SpawnChicken(Player p) {
		Chicken c = (Chicken) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.CHICKEN);
		c.setCustomName(CutsMethods.Chicken_Name);
		c.setCustomNameVisible(true);
	}
	
	
	// This method to spawn the chicken entity with custom name from config.yml and custom location parmeter
	// (Configuration file)
	public static void SpawnChickenWithCustomLocation(Location loc) {
		Chicken c = (Chicken) loc.getWorld().spawnEntity(loc, EntityType.CHICKEN);
		c.setCustomName(CutsMethods.Chicken_Name);
		c.setCustomNameVisible(true);
	}
	
	// Get messages from from config.yml (Configuration file) | is simple not try it at your home
	public static String getMessages() {
		String Messages = "";
		List<String> list = Configuration.getConfig().getStringList("Chicken.Messages");
		for (String i : list) {
			Messages = i;
		}
		return Messages;
	}

} // End

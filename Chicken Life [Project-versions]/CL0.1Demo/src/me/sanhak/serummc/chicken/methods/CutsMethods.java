package me.sanhak.serummc.chicken.methods;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import me.sanhak.serummc.chicken.Listeners.InteractEvents;
import me.sanhak.serummc.chicken.Listeners.MoveEvent;
import me.sanhak.serummc.chicken.Listeners.ProtectEvent;
import me.sanhak.serummc.chicken.Main.Main;
import me.sanhak.serummc.chicken.commands.*;
import me.sanhak.serummc.chicken.configuration.Configuration;

/**
 * [<b>SerumMC Development Team</b>] <br>
 * <br>
 * <b>CutsMethods</b> class , It contains abbreviations for some things so that
 * you do not repeat them and complicate things for you <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class CutsMethods { // Start

	public static String Chicken_Name = Configuration.getConfig().getString("Chicken.Name"); // Get CustomName for
																								// (Chicken Entity)

	public static List<String> list = Configuration.getConfig().getStringList("onClick.Messages"); // Get List of
																									// Messages
																									// From
																									// Configuration
																									// file
	//This Method to register events !
	public static void RegisterEvents() {
		PluginManager pm = Bukkit.getPluginManager(); //Get Plug-in Manager
		pm.registerEvents(new MoveEvent(), Main.getMain()); //Register MoveEvent Class
		pm.registerEvents(new InteractEvents(), Main.getMain()); //Register InteractEvents Class
		pm.registerEvents(new ProtectEvent(), Main.getMain()); //Register ProtectEvent Class
	}
	
	//This Method to register the commands !
	public static void RegisterCommands() {
		Main.getMain().getCommand("sscl").setExecutor(new SpawnCMD());
		Main.getMain().getCommand("rscl").setExecutor(new RemoveCMD());
		Main.getMain().getCommand("sclrlc").setExecutor(new ReloadCMD());
	}
	
	
	//This method send messages when plug-in enabled or disabled ! / Print Messages according to plug-in status 
	public static void PrintPluginStatusMessages(int Status) {
		if  (Status == 1) { //If the input == 1 (Enabled the plugin) ==> will send message like down
			Bukkit.getConsoleSender().sendMessage(Methods.f("&b\r\n"
					+ "  █▀▀ █░█ █ █▀▀ █▄▀ █▀▀ █▄░█   █░░ █ █▀▀ █▀▀\r\n"
					+ "  █▄▄ █▀█ █ █▄▄ █░█ ██▄ █░▀█   █▄▄ █ █▀░ ██▄\r\n"
					+ "                                         by [SerumMC Developments] !"));
			
			Bukkit.getConsoleSender().sendMessage(Methods.f("&6Super Chicken Life &aPlugin has been Enabled"));
		} else if  (Status == 0) { //If the input == 0 (Disabled the plugin) ==> will send message like down
			Bukkit.getConsoleSender().sendMessage(Methods.f("&b\r\n"
					+ "  █▀▀ █░█ █ █▀▀ █▄▀ █▀▀ █▄░█   █░░ █ █▀▀ █▀▀\r\n"
					+ "  █▄▄ █▀█ █ █▄▄ █░█ ██▄ █░▀█   █▄▄ █ █▀░ ██▄\r\n"
					+ "                                         by [SerumMC Developments] !"));
			
			Bukkit.getConsoleSender().sendMessage(Methods.f("&6Super Chicken Life &cPlugin has been Disabled"));
		} else { //If input not equal 1 or 0 ==> Error 
			Logger.Error("Please send this error to Sanhak or decode it in Serum bot (!scle <Error>)");
			Logger.Error("");
		}
	}
	
} // End

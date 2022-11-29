package me.sanhak.serummc.chicken.methods;

import org.bukkit.Bukkit;

/**
 * [<b>SerumMC Development Team</b>] <br>
 * <br>
 * <b>Methods</b> class , It so simple logger to console the plug-in <br>
 * <br>
 * Class was created in <b>0.1 version</b> by Sanhak
 */

public class Logger { // Start

	// Send Error Message with parameter
	public static void Error(String msg) {
		Bukkit.getServer().getConsoleSender().sendMessage(Methods.f("&c[Error] &r" + msg));
	}

	// Send Info Message with parameter
	public static void Info(String msg) {
		Bukkit.getServer().getConsoleSender().sendMessage(Methods.f("&b[Info] &r" + msg));
	}

	// Send Warn Message with parameter
	public static void Warn(String msg) {
		Bukkit.getServer().getConsoleSender().sendMessage(Methods.f("&e[Warn] &r" + msg));
	}

} // End

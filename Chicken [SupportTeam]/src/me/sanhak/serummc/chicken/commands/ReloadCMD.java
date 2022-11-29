package me.sanhak.serummc.chicken.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.sanhak.serummc.chicken.Main.Main;
import me.sanhak.serummc.chicken.configuration.Configuration;
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

public class ReloadCMD implements CommandExecutor { // Start

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (!(cs instanceof Player)) { // If player use command from console return false and send message !
			Logger.Warn("&cThis Command Just for Players , you can't use this command from Console !!");
			return false;
		}

		Player p = (Player) cs;
		if (p.hasPermission("chicken.admin")) { // If player has permissions
			if (args.length == 0) { // if player use command without args like /sclrlc
				//Reload Configuration
				Configuration.reload();
				Configuration.save();
				Bukkit.getPluginManager().disablePlugin(Main.getMain());
				Bukkit.getPluginManager().enablePlugin(Main.getMain());
				p.sendMessage(Methods.f("&aSuccessfully reloaded the configuraion file !"));
			} else { // If player use the wrong command!
				p.sendMessage(Methods.f("&cWrong use please try to type &f/sclrlc"));
			}
		} else { // if player hasn't permissions !
			p.sendMessage(Methods.f("&cYou don't have enough of permissions to use this command !"));
			p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5, 5);
		}

		return false;
	}
}
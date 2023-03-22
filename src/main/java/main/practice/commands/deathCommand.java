package main.practice.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class deathCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args ) {

		if(command.getName().equalsIgnoreCase("whyamidead")) {
			Player player = (Player) sender;
			String deathReason = deathMSG.deathReasons.get(player);
			if(deathReason != null ) {

				player.sendMessage(deathReason);
			}
			else {
				player.sendMessage("You havent died yet");

			}
		}
		return false;
	}
}

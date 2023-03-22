package main.practice.commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.ItemStack;

public class chatting implements Listener {

	private gamestart game = new gamestart();


	@EventHandler
	public void onChat(PlayerChatEvent event) {

		Player player = event.getPlayer();
		ItemStack itemstack = new ItemStack(Material.STICK);
		String message = event.getMessage();
		int randomNumber = game.getRandomNumber();

		if (game.started) {
			if (Integer.parseInt(message) != (randomNumber)) {
				player.sendMessage("You have guessed the wrong number" + randomNumber);

			} else {
				player.sendMessage("You have guessed the right number " + randomNumber);
				player.getInventory().addItem(itemstack);
			}
		}
	}



	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		Material block = event.getBlock().getType();
		Player player = event.getPlayer();

		if(block == Material.DIAMOND_BLOCK) {
			if(game.started) {
				player.sendMessage("Changing to false");
				game.setStarted(false);

			}
			else {
				player.sendMessage("Changing to true");
				game.setStarted(true);
			}
		}
	}
}
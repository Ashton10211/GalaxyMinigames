package main.minigames.GuessingGame;

import main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Guess implements Listener {

	private GuessConstructor guesser;
	private boolean cooldownActive;
	private static final int COOLDOWN_TIME_SECONDS = 5;

	public Guess(GuessConstructor guessConstructor) {
		this.guesser = guessConstructor;
		this.cooldownActive = false;
	}


	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();

		player.sendMessage("Hi it is " + guesser.isStarted());

	}

	@EventHandler
	public void onChat(PlayerChatEvent event) {

		Player player = event.getPlayer();
		ItemStack itemstack = new ItemStack(Material.STICK);
		String message = event.getMessage();
		int randomNumber = guesser.getRandomNumber();

		if (guesser.isStarted()) {
			if (Integer.parseInt(message) != (randomNumber)) {
				player.sendMessage("You have guessed the wrong number " + randomNumber);

			} else {
				player.sendMessage("You have guessed the right number " + randomNumber);
				player.getInventory().addItem(itemstack);
				endGame();
			}
		}
	}

	public void startGame() {
		if (cooldownActive) {
			Bukkit.broadcastMessage("Game starting in " + COOLDOWN_TIME_SECONDS + " seconds!");
			return;
		}

		Bukkit.broadcastMessage("Starting game...");

		cooldownActive = true;

		Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				cooldownActive = false;
				if (guesser.isStarted()) {
					Bukkit.broadcastMessage("Game has already started!");
					return;
				}
				guesser.startGame();
				guesser.setMaxPlayers(20); // set max players to 20
				Random rand = new Random();
				guesser.getRandomNumber(); // Generate a random number between 1-50
				Bukkit.broadcastMessage("Game starting, guess a number between 1 and 50!");
			}
		}, COOLDOWN_TIME_SECONDS * 20L);
	}

	public void endGame() {
		guesser.endGame(true);
	}
}

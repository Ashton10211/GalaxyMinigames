package main.minigames.Gladiators;

import main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Gladiator implements Listener {

	private GladiatorConstructor duel;
	private boolean cooldownActive;
	private static final int COOLDOWN_TIME_SECONDS = 5;
	private boolean gameEnded;

	public Gladiator(GladiatorConstructor gladiatorConstructor) {
		this.duel = gladiatorConstructor;
		this.cooldownActive = false;
		this.gameEnded = false;
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		player.sendMessage("Hi it is " + duel.isStarted());
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		if (duel.isStarted()) {
			return;
		}

		Player player = event.getEntity();
		Player killer = player.getKiller();
		if (killer != null) {
			Bukkit.broadcastMessage(player.getName() + " was killed by " + killer.getName());
		} else {
			Bukkit.broadcastMessage(player.getName() + " died");
		}

		gameEnded = true;
		endGame();
	}

	public void startGame() {
		if (cooldownActive) {
			Bukkit.broadcastMessage("Game starting in " + COOLDOWN_TIME_SECONDS + " seconds!");
			return;
		}

		Bukkit.broadcastMessage("Starting game...");
		cooldownActive = true;
		Location spot1 = new Location(Bukkit.getWorld("world"), 1, 2, 3);
		Location spot2 = new Location(Bukkit.getWorld("world"), 1, 2, 3);

		Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
			cooldownActive = false;
			if (duel.isStarted()) {
				Bukkit.broadcastMessage("Game has already started!");
				return;
			}
			duel.startGame();
			duel.setMaxPlayers(20); // set max players to 20
			Bukkit.broadcastMessage("Game starting, kill the other opponent ");
			List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
			int i = 1;
			ItemStack item = new ItemStack(Material.STICK);
			for (Player player : players) {
				player.teleport(i == 1 ? spot1 : spot2);
				i++;
			}
			for (Player player : players) {
				player.sendMessage("HEY game is starting ");
				player.getInventory().addItem(item);
			}
		}, COOLDOWN_TIME_SECONDS * 20L);
	}

	public void endGame() {
		if (gameEnded) {
			Bukkit.broadcastMessage("Game is over teleporting you guys to Lobby");
			gameEnded = false;
		}
	}
}

package main.minigames.Bridges;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BridgeConstructor {
	private int maxPlayers;
	private boolean started;
	private int gameDuration;

	public BridgeConstructor() {
		this.maxPlayers = 20;
		this.started = false;
		this.gameDuration = 10; // Default game duration of 10 minutes
	}

	public void startGame() {
		this.started = true;
		Bukkit.broadcastMessage("Game is starting");
		// Set up game logic for Bridges
	}

	public void endGame() {
		this.started = false;
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.sendMessage("The Bridges game has ended");
		}
		// Clean up game logic for Bridges
	}

	public boolean isStarted() {
		return this.started;
	}

	public int getMaxPlayers() {
		return this.maxPlayers;
	}

	public void setGameDuration(int duration) {
		this.gameDuration = duration;
	}

	public int getGameDuration() {
		return this.gameDuration;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}
}

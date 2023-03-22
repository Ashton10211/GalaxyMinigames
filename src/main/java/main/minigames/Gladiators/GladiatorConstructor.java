package main.minigames.Gladiators;

import org.bukkit.Bukkit;

import java.util.Random;

public class GladiatorConstructor {
	private boolean started;
	private int maxPlayers;
	private int cooldownTime;
	private long cooldownEnd;

	public GladiatorConstructor() {
		this.started = false;
		this.maxPlayers = 10;
		this.cooldownTime = 5; // 5 second cooldown time
		this.cooldownEnd = 0;
	}

	// other methods here



	public void startGame() {
		if (cooldownActive()) {
			return;
		}
		cooldownEnd = System.currentTimeMillis() + cooldownTime * 1000L;
		started = true;
	}
	public void endGame(boolean end) {
		// end game logic here
	}

	public boolean isStarted() {
		return this.started;
	}



	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	private boolean cooldownActive() {
		return System.currentTimeMillis() < cooldownEnd;
	}
}


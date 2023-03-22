package main.minigames.GuessingGame;

import org.bukkit.Bukkit;

import java.util.Random;

public class GuessConstructor {
		private boolean started;
		private int randomNumber;
		private int maxPlayers;
		private int cooldownTime;
		private long cooldownEnd;

		public GuessConstructor() {
			this.started = false;
			this.randomNumber = new Random().nextInt(50) + 1;
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

	public int getRandomNumber() {
		return this.randomNumber;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	private boolean cooldownActive() {
		return System.currentTimeMillis() < cooldownEnd;
	}
}


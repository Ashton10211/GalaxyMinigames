package main.practice.commands;

import main.Main;
import org.bukkit.Bukkit;

import java.util.Random;

public class gamestart {
	public boolean started;
	private int randomNumber;

	public void setStarted(boolean started) {
		this.started = started;

		if (started) {
			Random rand = new Random();
			randomNumber = rand.nextInt(50);
			Bukkit.broadcastMessage("SERVER STARTINGGG");
		}
	}

	public int getRandomNumber() {
		return randomNumber;
	}
}

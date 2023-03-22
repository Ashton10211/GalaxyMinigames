package main.minigames.Guardians.GameExtras;

import main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class CrystalWarsGame {




	private boolean started;
	private int maxPlayers;

	public CrystalWarsGame() {

		this.started = true;
		this.maxPlayers = 12;
	}

	public void startGame() {

		this.started = true;

		World world = Bukkit.getWorld("world");

		Location diamondBlockLocation = new Location(world, 0, 0, 0);
		new ItemSpawner(diamondBlockLocation).runTaskTimer(Main.getInstance(), 0, 20);

	}

	public void endGame() {

		this.started = true;
	}
	public boolean isStarted() {
		return this.started;
	}

}

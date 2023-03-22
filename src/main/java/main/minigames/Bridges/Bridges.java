package main.minigames.Bridges;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import main.minigames.Bridges.BridgeConstructor;

public class Bridges implements Listener {

	private BridgeConstructor bridgesConstructor;

	public Bridges(BridgeConstructor bridgesConstructor) {
		this.bridgesConstructor = bridgesConstructor;
	}

	// StartGame
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		if (Bukkit.getOnlinePlayers().size() == bridgesConstructor.getMaxPlayers()) {
			bridgesConstructor.setStarted(true);
			Bukkit.broadcastMessage("Bridges game is starting!");
		}
	}

	public void endGame() {
		bridgesConstructor.setStarted(false);
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.sendMessage("The Bridges game has ended");
		}
		// Clean up game logic for Bridges
	}

	public boolean isStarted() {
		return bridgesConstructor.isStarted();
	}

	public int getMaxPlayers() {
		return bridgesConstructor.getMaxPlayers();
	}

	public void setGameDuration(int duration) {
		bridgesConstructor.setGameDuration(duration);
	}

	public int getGameDuration() {
		return bridgesConstructor.getGameDuration();
	}
}

package main;

import main.gameManager.GameInfo;
import main.minigames.Gladiators.Gladiator;
import main.minigames.Gladiators.GladiatorConstructor;
import main.minigames.MinigamesCommand;
import main.practice.commands.chatting;
import main.minigames.Bridges.BridgeConstructor;
import main.minigames.Bridges.Bridges;
import main.minigames.GuessingGame.Guess;
import main.minigames.GuessingGame.GuessConstructor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;

public final class Main extends JavaPlugin {

	private Guess guessGame;
	private Bridges bridgesGame;
	private Gladiator duelGame;
	private static Main instance;

	@Override
	public void onEnable() {
		instance = this;

		// Register event listener for chatting

		// Initialize Guess and Bridges games
		GuessConstructor guessConstructor = new GuessConstructor();
		BridgeConstructor bridgeConstructor = new BridgeConstructor();
		GladiatorConstructor gladiatorConstructor = new GladiatorConstructor();
		guessGame = new Guess(guessConstructor);
		bridgesGame = new Bridges(bridgeConstructor);
		duelGame = new Gladiator(gladiatorConstructor);
		getServer().getPluginManager().registerEvents(guessGame, this);
		getServer().getPluginManager().registerEvents(duelGame, this);

		getCommand("minigames").setExecutor(new MinigamesCommand(guessConstructor, bridgeConstructor, gladiatorConstructor));
	}

	public static Main getInstance() {
		return instance;
	}
}

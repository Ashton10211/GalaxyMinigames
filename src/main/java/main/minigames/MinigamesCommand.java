package main.minigames;

import main.minigames.Gladiators.Gladiator;
import main.minigames.Gladiators.GladiatorConstructor;
import main.minigames.GuessingGame.Guess;
import main.minigames.GuessingGame.GuessConstructor;
import main.minigames.Bridges.Bridges;
import main.minigames.Bridges.BridgeConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MinigamesCommand implements CommandExecutor {

	private final Guess guessGame;
	private final Bridges bridgesGame;
	private final Gladiator duelGame;
	private String currentGame;

	public MinigamesCommand(GuessConstructor guessConstructor, BridgeConstructor bridgesConstructor, GladiatorConstructor gladiatorConstructor) {
		guessGame = new Guess(guessConstructor);
		bridgesGame = new Bridges(bridgesConstructor);
		duelGame = new Gladiator(gladiatorConstructor);
		currentGame = "";
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) {
			sender.sendMessage("Please specify a game or use /minigames current to check the current game.");
			return true;
		}

		String game = args[0].toLowerCase();

		switch (game) {
			case "guessing":
				guessGame.endGame();
				guessGame.startGame();
				currentGame = "guessing";
				break;
			case "bridges":
				bridgesGame.endGame();
				currentGame = "bridges";
				break;
			case "gladiators":
				duelGame.endGame();
				duelGame.startGame();
				currentGame = "Gladiators";
				break;
			case "current":
				sender.sendMessage("The current game is: " + currentGame);
				return true;
			default:
				sender.sendMessage("Invalid game specified.");
				return true;
		}

		sender.sendMessage("Switched to " + game + " game.");
		return true;
	}
}

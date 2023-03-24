package main.minigames.Guardians.GameExtras;

import main.minigames.Gladiators.GladiatorConstructor;
import main.minigames.Guardians.CustomTeam;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class CrystalDead implements Listener {


	private CrystalWarsGame guardians;
	private Block crystal1;

	private CustomTeam customteam;

	public CrystalDead(CrystalWarsGame crystalWarsGame, Block crystal1, CustomTeam customTeam) {
		this.guardians = crystalWarsGame;
		this.crystal1 = crystal1;
		this.customteam = customTeam;
	}


	@EventHandler
	public void onCrystalBreak(BlockBreakEvent event) {
		Block block = event.getBlock();
		Location Crystals = event.getBlock().getLocation();
		Material Blocks = Material.STONE_BRICKS;

		if(block.equals(Blocks)) {
			if(Crystals == crystal1) {
				customteam.removeCrystal();
			}
		}

	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {


		if(guardians.isStarted()) {

		}
	}
}

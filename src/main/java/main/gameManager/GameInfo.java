package main.gameManager;

import main.Main;
import org.bukkit.*;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

import static main.gameManager.ConfigManager.getConfig;

public class GameInfo implements Listener {


	private HashMap<UUID, Integer> playerRanks = new HashMap<>();

	private boolean started;
	private boolean reset;
	private int resetTaskId;
	private int resetDelay = 200; //ticks
	public Main main;

	public GameInfo(Main main) {

		this.main = main;

	}

	public boolean isStarted() {
		return started;
	}
	public void setStarted(boolean started) {
		this.started = started;

		if (started) {
			System.out.println("Started is true");
			FileConfiguration config = getConfig();
			int numLocations = 4;
			for (Player player : Bukkit.getOnlinePlayers()) {
				int locationIndex = (int) (Math.random() * numLocations) + 1;

				String locationKey = "teleport" + locationIndex;
				double x = config.getDouble(locationKey + ".x");
				double y = config.getDouble(locationKey + ".y");
				double z = config.getDouble(locationKey + ".z");

				Location location = new Location(player.getWorld(), x, y, z);
				player.teleport(location);

				ItemStack diamondShovel = new ItemStack(Material.DIAMOND_SHOVEL);
				player.getInventory().clear();
				player.getInventory().addItem(diamondShovel);

				player.sendTitle("Get ready!", "", 10, 30, 10);
				player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
			}
		} else {
			System.out.println("Started is false");
		}
	}





	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}


	public void start(){

		Bukkit.broadcastMessage("starting test");
		Bukkit.broadcastMessage("This is a minigame testing server");

	}

	public void reset(){

		Bukkit.broadcastMessage("Game over! Resetting...");

		//Reset player ranks
		playerRanks.clear();

		//Reset started flag
		setStarted(false);

		//Reset player locations and inventory
		FileConfiguration config = getConfig();
		double x = config.getDouble("spawnPoint.x");
		double y = config.getDouble("spawnPoint.y");
		double z = config.getDouble("spawnPoint.z");
		Location spawnLocation = new Location(Bukkit.getWorlds().get(0), x, y, z);

		for (Player player : Bukkit.getOnlinePlayers()) {
			player.teleport(spawnLocation);
			player.getInventory().clear();
		}

		//Schedule game start after delay
		resetTaskId = Bukkit.getScheduler().scheduleSyncDelayedTask(main, () -> {
			setStarted(true);
			start();
		}, resetDelay);

	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		int onlinePlayers = Bukkit.getOnlinePlayers().size();

		if (isStarted()) {
			return;
		}

		switch (onlinePlayers) {
			case 1:
			case 2:
			case 3:
				Bukkit.broadcastMessage(onlinePlayers + "/4 players");
				break;
			case 4:
				Bukkit.broadcastMessage("4/4 players");
				setStarted(true);
				start();
				double x = getConfig().getDouble("gameStartPoint.x");
				double y = getConfig().getDouble("gameStartPoint.y");
				double z = getConfig().getDouble("gameStartPoint.z");
				Location startPoint = new Location(event.getPlayer().getWorld(), x, y, z);

				int width = getConfig().getInt("map.width");
				int length = getConfig().getInt("map.length");
				int height = getConfig().getInt("map.height");
				MapCreator mapCreator = new MapCreator(startPoint.getWorld(), width, height, length, 46);
				mapCreator.createMap(Material.SNOW_BLOCK);

				break;
			default:
				// do nothing
				break;
		}

		if (!isStarted()) {
			FileConfiguration config = getConfig();
			double x = config.getDouble("spawnPoint.x");
			double y = config.getDouble("spawnPoint.y");
			double z = config.getDouble("spawnPoint.z");
			Location spawnLocation = new Location(event.getPlayer().getWorld(), x, y, z);

			for (Player player : Bukkit.getOnlinePlayers()) {
				player.teleport(spawnLocation);
			}
		}
	}


	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		if (isStarted()) {
			Player playerDead = event.getEntity();

			// Update player ranks
			playerRanks.put(playerDead.getUniqueId(), playerRanks.size() + 1);

			// Calculate number of alive players
			int alivePlayers = Bukkit.getOnlinePlayers().size() - playerRanks.size();

			if (alivePlayers > 1) {
				Bukkit.broadcastMessage(playerDead.getName() + " came in " + playerRanks.get(playerDead.getUniqueId()) + ". " + alivePlayers + " players remaining.");
			} else if (alivePlayers == 1) {
				String winnerName = "";
				for (Player player : Bukkit.getOnlinePlayers()) {
					if (!player.isDead()) {
						winnerName = player.getName();
						break;
					}
				}
				Bukkit.broadcastMessage("Game over! " + winnerName + " is the winner!");
				setStarted(false);
			} else {
				Bukkit.broadcastMessage("Game over! No one survived.");
				setStarted(false);
			}
		} else {
			Bukkit.broadcastMessage("NOTHING WILL HAPPEN, GAME ISN'T STARTED.");
		}
	}



	@EventHandler
		public void onPlace(BlockPlaceEvent event) {

		Player player = event.getPlayer();
		Material block = event.getBlock().getType();


			if (block == Material.DIAMOND_BLOCK) {
				if (isStarted()) {
					setStarted(false);
					player.sendMessage("Set to false1");
				} else {
					player.sendMessage("Set to true");
					double x = getConfig().getDouble("gameStartPoint.x");
					double y = getConfig().getDouble("gameStartPoint.y");
					double z = getConfig().getDouble("gameStartPoint.z");
					Location startPoint = new Location(event.getPlayer().getWorld(), x, y, z);

					int width = getConfig().getInt("map.width");
					int length = getConfig().getInt("map.length");
					int height = getConfig().getInt("map.height");
					MapCreator mapCreator = new MapCreator(startPoint.getWorld(), width, height, length, 46);
					mapCreator.createMap(Material.SNOW_BLOCK);

					start();
					setStarted(true);
					this.start();
				}
			}
	}
}



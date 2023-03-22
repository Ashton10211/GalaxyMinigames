package main.minigames.Guardians.GameExtras;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ItemSpawner extends BukkitRunnable {


	private final Location diamondBlockLocation;

	public ItemSpawner(Location diamondBlockLocation) {
		this.diamondBlockLocation = diamondBlockLocation;
	}

	@Override
	public void run() {
		World world = diamondBlockLocation.getWorld();
		if (world.getBlockAt(diamondBlockLocation).getType() == Material.DIAMOND_BLOCK) {
			world.dropItemNaturally(diamondBlockLocation, new ItemStack(Material.IRON_INGOT));
		}
	}
}



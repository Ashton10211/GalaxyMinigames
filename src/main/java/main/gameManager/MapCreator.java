package main.gameManager;

import org.bukkit.Material;
import org.bukkit.World;

public class MapCreator {

	private final World world;  // The world where the map will be created
	private final int startX;   // The starting X coordinate of the map
	private final int startY;   // The starting Y coordinate of the map
	private final int startZ;   // The starting Z coordinate of the map
	private final int size;     // The size of the map (length, width, and height)

	public MapCreator(World world, int startX, int startY, int startZ, int size) {
		this.world = world;
		this.startX = startX;
		this.startY = startY;
		this.startZ = startZ;
		this.size = size;
	}

	public void createMap(Material blockType) {
		for (int x = startX; x < startX + size; x++) {
			for (int y = startY; y < startY + size; y++) {
				for (int z = startZ; z < startZ + size; z++) {
					if (y == startY) {
						// Place blocks on the bottom layer
						world.getBlockAt(x, y, z).setType(blockType);
					} else if (y == startY + size - 1) {
						// Place blocks on the top layer
						world.getBlockAt(x, y, z).setType(blockType);
					} else if (x == startX || x == startX + size - 1 || z == startZ || z == startZ + size - 1) {
						// Place blocks on the sides
						world.getBlockAt(x, y, z).setType(blockType);
					}
				}
			}
		}
	}
}

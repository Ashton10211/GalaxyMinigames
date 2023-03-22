package main.gameManager;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class HatPlugin extends JavaPlugin implements Listener {

	private Map<Player, ItemStack> hatMap;

	@Override
	public void onEnable() {
		hatMap = new HashMap<>();
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		hatMap.put(player, null);
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Inventory clickedInventory = event.getClickedInventory();
		if (clickedInventory == null || event.getSlotType() != InventoryType.SlotType.ARMOR) {
			return;
		}

		Player player = (Player) event.getWhoClicked();
		ItemStack clickedItem = event.getCurrentItem();

		if (clickedItem != null && clickedItem.getType() != Material.AIR) {
			event.setCancelled(true);
			ItemStack currentHat = hatMap.get(player);
			if (currentHat != null) {
				player.getInventory().addItem(currentHat);
			}
			player.getInventory().setItem(39, clickedItem);
			player.updateInventory();
			hatMap.put(player, clickedItem);
		}
	}
}

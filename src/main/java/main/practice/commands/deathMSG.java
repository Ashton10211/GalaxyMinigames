package main.practice.commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;
import java.util.Map;

public class deathMSG implements Listener {


	static Map<Player, String> deathReasons = new HashMap<>();

	@EventHandler
	public void onDeath(PlayerDeathEvent event) {

		Player dead = event.getEntity();
		String howdied = event.getDeathMessage();

		deathReasons.put(dead, howdied);

	}
}

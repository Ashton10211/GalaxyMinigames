package main.gameManager;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

	public class ConfigManager {
		public static FileConfiguration getConfig() {
			// Get the plugin instance
			Plugin plugin = Bukkit.getPluginManager().getPlugin("SpleefCore");

			// Get the config file from the plugin's data folder
			File configFile = new File(plugin.getDataFolder(), "config.yml");

			// Create the default config file if it doesn't exist
			if (!configFile.exists()) {
				plugin.saveResource("config.yml", false);
			}

			// Load the config file into a FileConfiguration object
			YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);

			return config;
		}
	}

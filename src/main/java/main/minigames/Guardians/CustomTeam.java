package main.minigames.Guardians;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Team;

import java.util.Objects;

public class CustomTeam {
	private String name;
	private String prefix;
	private ChatColor color;
	private Crystal crystal;
	// Add any other properties you want for your team

	public CustomTeam(String name, String prefix, ChatColor color) {
		this.name = name;
		this.prefix = prefix;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDisplayName(String name) {
		this.name = name;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public ChatColor getColor() {
		return color;
	}

	public void setColor(ChatColor color) {
		this.color = color;
	}

	public Crystal getCrystal() {
		return crystal;
	}

	public void setCrystal(Crystal crystal) {
		this.crystal = crystal;
	}

	public void setAllowFriendlyFire(boolean b) {
	}

	public void setCanSeeFriendlyInvisibles(boolean b) {
	}

	public void removeCrystal() {
		this.crystal = null;
	}

	public void setOption(Team.Option option, Team.OptionStatus status) {
		Objects.requireNonNull(Objects.requireNonNull(Bukkit.getScoreboardManager()).getMainScoreboard().getTeam(name)).setOption(option, status);
	}

	// Add any other methods you want for your team
}

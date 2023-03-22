package main.minigames.Guardians;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;

public class GuardianConstructor {

	private List<CustomTeam> teams;

	public GuardianConstructor() {
		teams = new ArrayList<>();
		Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

		Block crystal1 = Bukkit.getServer().getWorld("world").getBlockAt(0, 64, 0);
		CustomTeam team1 = new CustomTeam("Elementals", "§aElementals §f| ", ChatColor.GREEN);
		teams.add(team1);
		team1.setCrystal(new Crystal(true, crystal1));
		scoreboard.getTeam("Elementals").addEntry("§a");
		scoreboard.getTeam("Elementals").setAllowFriendlyFire(false);
		scoreboard.getTeam("Elementals").setCanSeeFriendlyInvisibles(true);
		scoreboard.getTeam("Elementals").setColor(ChatColor.GREEN);
		scoreboard.getTeam("Elementals").setOption(org.bukkit.scoreboard.Team.Option.NAME_TAG_VISIBILITY, org.bukkit.scoreboard.Team.OptionStatus.ALWAYS);
		scoreboard.getTeam("Elementals").setOption(org.bukkit.scoreboard.Team.Option.COLLISION_RULE, org.bukkit.scoreboard.Team.OptionStatus.NEVER);

		CustomTeam team2 = new CustomTeam("Technocrats", "§bTechnocrats §f| ", ChatColor.AQUA);
		teams.add(team2);
		scoreboard.registerNewTeam("Technocrats");
		scoreboard.getTeam("Technocrats").setAllowFriendlyFire(false);
		scoreboard.getTeam("Technocrats").setCanSeeFriendlyInvisibles(true);
		scoreboard.getTeam("Technocrats").setColor(ChatColor.AQUA);
		scoreboard.getTeam("Technocrats").setOption(org.bukkit.scoreboard.Team.Option.NAME_TAG_VISIBILITY, org.bukkit.scoreboard.Team.OptionStatus.ALWAYS);
		team2.setPrefix("§bTechnocrats §f| ");

		CustomTeam team3 = new CustomTeam("Mythics", "§dMythics §f| ", ChatColor.LIGHT_PURPLE);
		teams.add(team3);
		scoreboard.registerNewTeam("Mythics");
		scoreboard.getTeam("Mythics").setAllowFriendlyFire(false);
		scoreboard.getTeam("Mythics").setCanSeeFriendlyInvisibles(true);
		scoreboard.getTeam("Mythics").setColor(ChatColor.LIGHT_PURPLE);
		scoreboard.getTeam("Mythics").setOption(org.bukkit.scoreboard.Team.Option.NAME_TAG_VISIBILITY, org.bukkit.scoreboard.Team.OptionStatus.ALWAYS);
		team3.setPrefix("§dMythics §f| ");

		CustomTeam team4 = new CustomTeam("Pirates", "§ePirates §f| ", ChatColor.YELLOW);
		teams.add(team4);
		scoreboard.registerNewTeam("Pirates");
		scoreboard.getTeam("Pirates").setAllowFriendlyFire(false);
		scoreboard.getTeam("Pirates").setCanSeeFriendlyInvisibles(true);
		scoreboard.getTeam("Pirates").setColor(ChatColor.YELLOW);
		scoreboard.getTeam("Pirates").setOption(org.bukkit.scoreboard.Team.Option.NAME_TAG_VISIBILITY, org.bukkit.scoreboard.Team.OptionStatus.ALWAYS);
		team4.setPrefix("§ePirates §f| ");


		Block crystal4 = Bukkit.getServer().getWorld("world").getBlockAt(0, 74, 0);

		CustomTeam team5 = new CustomTeam("Aliens", "§5Aliens §f| ", ChatColor.DARK_PURPLE);
		teams.add(team5);
		scoreboard.registerNewTeam("Aliens");
		teams.get(4).setDisplayName("Aliens");
		teams.get(4).setColor(ChatColor.DARK_PURPLE);
		teams.get(4).setAllowFriendlyFire(false);
		teams.get(4).setCanSeeFriendlyInvisibles(true);
		teams.get(4).setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.ALWAYS);
		teams.get(4).setOption(org.bukkit.scoreboard.Team.Option.COLLISION_RULE, org.bukkit.scoreboard.Team.OptionStatus.NEVER);
		teams.get(4).setPrefix("§5Aliens §f| ");
		teams.get(4).setCrystal(new Crystal(true, crystal4));
	}
}
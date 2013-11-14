package me.YourName.tutorial;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Tutorial extends JavaPlugin implements Listener {
	
	Scoreboard board;

	public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);	
		
		scoreboard();
	}
	
	public void scoreboard(){
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		board = manager.getNewScoreboard();
		
		Objective objective = board.registerNewObjective("Test", "Test2");
		objective.setDisplayName(ChatColor.AQUA + "Statistics");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		Team team = board.registerNewTeam("Team");
		team.setDisplayName(ChatColor.RED + "");
		
		int a = Bukkit.getOnlinePlayers().length;
		int b = Bukkit.getMonsterSpawnLimit();
		int c = Bukkit.getMaxPlayers();
		int d = Bukkit.getViewDistance();
		
		Score score = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "Online Players"));
		score.setScore(a);
		
		Score score2 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "MS Limit"));
		score2.setScore(b);
		
		Score score3 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "Max Players"));
		score3.setScore(c);
		
		Score score4 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "View Distance"));
		score4.setScore(d);
		
	}
	
	@EventHandler
	public void onjoin(PlayerJoinEvent e){
		e.getPlayer().setScoreboard(board);
	}
	
}

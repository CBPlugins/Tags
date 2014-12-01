package org.cbplugins.tags.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class BukkitUtil {

	public static List<Player> getOnlinePlayers() {
		List<Player> players = new ArrayList<Player>();
		for(World w : Bukkit.getWorlds()) {
			for(Player p : w.getPlayers()) {
				players.add(p);
			}
		}
		return players;
	}
	
}

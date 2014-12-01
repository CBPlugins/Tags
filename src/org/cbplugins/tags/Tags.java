package org.cbplugins.tags;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.cbplugins.tags.util.TagUtil;

public class Tags extends JavaPlugin {
	
	public void onEnable() {}

	public static void setTag(Player player, String tag, Player receiver) {
		TagUtil.setTag(player, tag, receiver);
	}
	
}

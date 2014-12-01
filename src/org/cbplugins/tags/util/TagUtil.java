package org.cbplugins.tags.util;

import java.lang.reflect.Field;

import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.PacketPlayOutNamedEntitySpawn;

import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class TagUtil {
	
	public static void setTag(Player player, String tag, Player receiver) {
		if(tag.length() > 16) {
			tag = tag.substring(0, 15);
		}
		String realName = player.getName();
		EntityPlayer ep = ((CraftPlayer)player).getHandle();
		ep.displayName = tag;
		PacketPlayOutNamedEntitySpawn packet = new PacketPlayOutNamedEntitySpawn(ep);
		
		try{
			Field b = packet.getClass().getDeclaredField("b");
			b.setAccessible(true);
			Object gameProfile = b.get(packet);
			Field name = gameProfile.getClass().getDeclaredField("name");
			name.setAccessible(true);
			name.set(gameProfile, tag);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(player != receiver) {
			((CraftPlayer)receiver).getHandle().playerConnection.sendPacket(packet);
		}
		ep.displayName = realName;
	}
	
}

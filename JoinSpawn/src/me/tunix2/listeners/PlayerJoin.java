package me.tunix2.listeners;

import java.util.List;

import me.tunix2.joinspawn.JoinSpawn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
	
	JoinSpawn plugin;
	public PlayerJoin(JoinSpawn instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) 
	{
		
	List<String> excludedWorlds = plugin.getConfig().getStringList("Exclude-worlds");
		
	String message;
	
		// Does the spawn world exist?
		if (Bukkit.getWorld(plugin.getConfig().getString("Spawn-world")) != null)
		{
			// Do excluded worlds exist? Does the excluded world list contain the world the player is in?
			if (excludedWorlds != null && !excludedWorlds.contains(event.getPlayer().getWorld().getName()))
				{
				
					// does the player have permission?
					if(!plugin.getPerms().has(event.getPlayer(), "joinspawn.exempt"))
					{
					event.getPlayer().teleport(Bukkit.getWorld(plugin.getConfig().getString("Spawn-world")).getSpawnLocation());
					
					plugin.getLogger().info("Teleporting " + event.getPlayer().getDisplayName() + " to main world spawn.");
					
					message = plugin.getConfig().getString("Message", null);
	
					
					if (message != null)
					{
						event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',message).replace("[player]", event.getPlayer().getDisplayName()));
					}
				}
			}
			
		}
		else
		{
			plugin.getLogger().info("Cant teleport " + event.getPlayer().getDisplayName() + ", world: " +
					plugin.getConfig().getString("Spawn-world") +
					" does not exist!");
		}
	
	}

}

package me.tunix2.listeners;

import me.tunix2.joinspawn.JoinSpawn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
	
	
	JoinSpawn plugin;
	public PlayerJoin(JoinSpawn instance) 
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) 
	{
		
	plugin.getLogger().info("Teleporting " + event.getPlayer().getDisplayName() + " to main world spawn.");
	String message;
	
		if (Bukkit.getWorld(plugin.getConfig().getString("Spawn-world")) != null)
		{
			event.getPlayer().teleport(Bukkit.getWorld(plugin.getConfig().getString("Spawn-world")).getSpawnLocation());
			
			message = plugin.getConfig().getString("Message", null);
			if (message != null)
			{
				event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',message).replace("[player]", event.getPlayer().getDisplayName()));
			}
			
		}
		else
			plugin.getLogger().info("Cant teleport " + event.getPlayer().getDisplayName() + ", world: " +
					plugin.getConfig().getString("Spawn-world") +
					" does not exist!");
	
	}

}

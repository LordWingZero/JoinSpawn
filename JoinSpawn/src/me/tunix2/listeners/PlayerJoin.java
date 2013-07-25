package me.tunix2.listeners;

import me.tunix2.joinspawn.JoinSpawn;

import org.bukkit.Bukkit;
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
	
		if (Bukkit.getWorld(plugin.getConfig().getString("Spawn-world")) != null)
		{
			event.getPlayer().teleport(Bukkit.getWorld(plugin.getConfig().getString("Spawn-world")).getSpawnLocation());
		}
		else
			plugin.getLogger().info("Cant teleport " + event.getPlayer().getDisplayName() + ", world: " +
					plugin.getConfig().getString("Spawn-world") +
					" does not exist!"
				);
	
	}

}

package me.tunix2.joinspawn;

import java.io.File;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;





import me.tunix2.comands.CommandHandler;
import me.tunix2.listeners.PlayerJoin;
	 
public final class JoinSpawn extends JavaPlugin {
	
	private static JoinSpawn instance;
	private CommandHandler commandHandler;
	private Permission perms = null;
	 
	    @Override
	    public void onEnable(){
			PluginManager pm = getServer().getPluginManager();
		    pm.registerEvents(new PlayerJoin(this), this);
		    
	        //Create or load config
			File configFile = new File(this.getDataFolder(), "config.yml");
			configFile.exists(); // this will tell you if the file exists.
			if (configFile.exists()) {
				this.reloadConfig();
				getLogger().info("Loaded configuration file!");
			} else {
				this.saveDefaultConfig();
				getLogger().info("Created configuration file!");					
			}	
			
			// Ready commands
			commandHandler = new CommandHandler(this);
			
			// VAULT Setup permissions
			setupPermissions();
		    
	    	getLogger().info("Enabled!");
	    }
	 
	    @Override
	    public void onDisable() {
	    	getLogger().info("Disabled!");
	    }
	    
	    private boolean setupPermissions() {
	    	
	        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
	        perms = rsp.getProvider();
	        return perms != null;
	    }
	    
	    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	    	
		    if (args.length == 0) 
		    {
		        	String[] newArgs = new String[1];
		        	newArgs[0] = "help";
		        	
		        	this.commandHandler.handle(sender, newArgs);
			        return true;
		    }
		    else  	
		        this.commandHandler.handle(sender, args);
		    return true;
	    }
	    
		public static JoinSpawn getInstance() {
			return instance;
		}

		public Permission getPerms() {
			return perms;
		}

}

package me.tunix2.comands;

import me.tunix2.joinspawn.JoinSpawn;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;


public class CommandHandler {
	
	
	
	JoinSpawn plugin;

    public CommandHandler(JoinSpawn instance) {
    	plugin = instance;
	}
    
	public boolean handle(CommandSender sender, String[] oldArgs)
    {
		JoinSpawnCommand cmd = null;
		
		// put the first argument as the name. From here we know what to do with it
        String name = oldArgs[0];
        String[] args = new String[oldArgs.length - 1];
        for (int i = 0; i < args.length; i++) 
        {
            args[i] = oldArgs[i + 1];
        }


        if (name.equalsIgnoreCase("reload"))
        	cmd = new CommandReload(plugin, this, sender, args);
        if (name.equalsIgnoreCase("help"))
        	cmd = new CommandHelp(plugin, this, sender, args);

        
        
		if (cmd == null) 
		{
        	cmd = new CommandHelp(plugin, this, sender, oldArgs);
        	cmd.run();	
		}
		
		else
                
        cmd.run();
		return true;
    }
	
	
	
	

}

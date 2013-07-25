package me.tunix2.comands;

import me.tunix2.joinspawn.JoinSpawn;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;


public class CommandReload extends JoinSpawnCommand {
	
	
	JoinSpawn plugin;
	
	public CommandReload(JoinSpawn instance, CommandHandler tempCommandHandler, CommandSender sender,
            String[] args) {
        super(tempCommandHandler, sender, args, "reload");
        plugin = instance;
    }

	@Override
	public boolean run() {
		
		 String title = plugin.getConfig().getString("Title");

			 if (!getSender().hasPermission("joinspawn.reload"))
			 {
				 getSender().sendMessage( ChatColor.RED + "You don't have permission for this command!");
				 return true;
			 }
			 
			 {
				 plugin.reloadConfig();
				 getSender().sendMessage(title + "&aConfig reloaded!");
				 return true;
			 }
		
	}

}

package me.tunix2.comands;

import me.tunix2.joinspawn.JoinSpawn;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;


public class CommandHelp extends JoinSpawnCommand {


	JoinSpawn plugin;
	
	public CommandHelp(JoinSpawn instance, CommandHandler tempCommandHandler, CommandSender sender,
            String[] args) {
        super(tempCommandHandler, sender, args, "help");
        plugin = instance;
    }
	
	@Override
	public boolean run() {
		
		 String title = plugin.getConfig().getString("Title");
		
		 StringBuilder sb = new StringBuilder();
		 
		 sb.append(ChatColor.translateAlternateColorCodes('&',title +  "&7/joinspawn reload"));
		 
		 getSender().sendMessage(" " + sb.toString());
		 
		return true;
		
		
	}

}

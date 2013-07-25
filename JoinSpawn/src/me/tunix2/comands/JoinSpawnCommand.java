package me.tunix2.comands;
import me.tunix2.joinspawn.JoinSpawn;

import org.bukkit.command.CommandSender;

public abstract class JoinSpawnCommand {

    private CommandSender sender;
    protected String[] args;
    protected CommandHandler handler;
    protected String usage;
    
    protected JoinSpawn plugin = JoinSpawn.getInstance();

    public JoinSpawnCommand(CommandHandler tempCommandHandler, CommandSender sender, String[] args, String usage) {
        this.handler = tempCommandHandler;
        this.sender = sender;
        this.args = args;
        this.usage = usage;
    }

    public abstract boolean run();

    public CommandSender getSender() {
        return this.sender;
    }

}
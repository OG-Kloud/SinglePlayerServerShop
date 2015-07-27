package net.kloudspace.spss.commands;

import java.util.List;

import net.kloudspace.spss.properties.PlayerBank;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class AddCommand extends CommandBase{

	@Override
	public String getCommandName() {
		return "addFunds";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "Increase Player Funds";
	}
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		EntityPlayer player = (EntityPlayer)sender;
		if(player.capabilities.isCreativeMode) {
			return true;
		} else {
			return false;
		}
    }

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		EntityPlayer player = this.getPlayer(sender, args[0]);
		PlayerBank bank = PlayerBank.get(player);
		int amount = this.parseInt(sender, args[1]);
		bank.increaseBank(amount);
	}
	
	@Override
    public List addTabCompletionOptions(ICommandSender send, String[] args) {
		return args.length == 1 ? getListOfStringsMatchingLastWord(args, getPlayers()): null;
	}
	
	  protected String[] getPlayers() {
	        return MinecraftServer.getServer().getAllUsernames();
	    }
}

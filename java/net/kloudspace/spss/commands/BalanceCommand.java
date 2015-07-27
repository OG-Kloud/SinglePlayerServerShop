package net.kloudspace.spss.commands;

import net.kloudspace.spss.properties.PlayerBank;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class BalanceCommand extends CommandBase{

	@Override
	public String getCommandName() {
		return "balance";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "Prints the Balance";
	}
	@Override
	public int getRequiredPermissionLevel()
    {
        return 0;
    }
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_)
    {
        return true;
    }

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		if(sender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)sender;
			PlayerBank bank = PlayerBank.get(player);
			IChatComponent msg = new ChatComponentText("$" + PlayerBank.getCurrent(player));
			player.addChatComponentMessage(msg);
		}
	}

}

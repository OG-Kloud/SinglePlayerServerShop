package net.kloudspace.spss.commands;

import java.util.List;

import net.kloudspace.spss.properties.PlayerBank;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;

public class SetCommand extends CommandBase {

	@Override
	public String getCommandName() {
		return "set";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "Sets the current account balance";
	}
	@Override
	public List getCommandAliases()
    {
        return null;
    }
	@Override
	public int getRequiredPermissionLevel()
    {
        return 2;
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
		if(args.length < 1) {
			throw new WrongUsageException("/set {player} {amount} or /set {amount}", new Object[0]);
		} else {
			if(args.length == 1) {
				EntityPlayer player = (EntityPlayer)sender;
				int amount = parseInt(sender, args[0]);
				PlayerBank bank = PlayerBank.get(player);
				bank.set(player, amount);
			}
			if(args.length == 2) {
				EntityPlayer player = CommandBase.getPlayer(sender, args[0]);
				int amount = parseIntBounded(sender, args[1], 0, 50000);
				PlayerBank bank = PlayerBank.get(player);
				bank.set(player, amount);
			}
		}
	}

}

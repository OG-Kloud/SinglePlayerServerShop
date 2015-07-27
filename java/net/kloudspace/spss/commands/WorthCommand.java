package net.kloudspace.spss.commands;

import java.util.List;

import net.kloudspace.spss.properties.Errors;
import net.kloudspace.spss.properties.PlayerBank;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class WorthCommand extends CommandBase{

	@Override
	public String getCommandName() {
		return "worth";
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
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "/worth Prints the worth of the designated Item in chat, if no Item is designated "
				+ "it returns the value of the currently held Item";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		if(sender instanceof EntityPlayer) {
			if(args.length == 1) {
				Item item = CommandBase.getItemByText(sender, args[0]);
				EntityPlayer player = (EntityPlayer)sender;
				int value = PlayerBank.getValue(item);
				if(value != 0) {
					IChatComponent component = new ChatComponentText("Item Value: $" + value);
					player.addChatComponentMessage(component);
				} else {
					player.addChatComponentMessage(Errors.notAvalible);
				}
			} else {
				EntityPlayer player =(EntityPlayer)sender;
				Item item = player.inventory.getCurrentItem().getItem();
				int value = PlayerBank.getValue(item);
				if(value != 0) {
					IChatComponent component = new ChatComponentText("Item Value: $" + value);
					player.addChatComponentMessage(component);
				} else {
					player.addChatComponentMessage(Errors.notAvalible);
				}
			}
		}
	}
	@Override
    public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
        return p_71516_2_.length == 1 ? getListOfStringsFromIterableMatchingLastWord(p_71516_2_, Item.itemRegistry.getKeys()) : null;
    }

}

package net.kloudspace.spss.commands;

import java.util.List;

import net.kloudspace.spss.economy.Account;
import net.kloudspace.spss.properties.Errors;
import net.kloudspace.spss.properties.PlayerBank;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class BuyCommand extends CommandBase{

	@Override
	public String getCommandName() {
		return "buy";
	}

	@Override
	public String getCommandUsage(ICommandSender commandSender) {
		return "Buy an Item/Block from the server shop";
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
	public void processCommand(ICommandSender commandSender, String[] args) {
		if(commandSender instanceof EntityPlayer) {
			if (args.length < 1) {
				throw new WrongUsageException("/buy {item} or /buy {item} {stacksize}", new Object[0]);
			} else {
				EntityPlayer player = (EntityPlayer)commandSender;
				Item item = getItemByText(commandSender, args[0]);
				int i = 1;
				int j = 0;
				if (args.length >= 2)
	            {
	                i = parseIntBounded(commandSender, args[1], 1, 64);
	            }
				if(!Account.itemIncluded(item)) {
					player.addChatComponentMessage(Errors.notAvalible);
					return;
				}
				int amount = Account.multiply(PlayerBank.getValue(item), i);
				ItemStack itemStack =new ItemStack(item, i);
				PlayerBank bank = PlayerBank.get(player);
				if(Account.hasEnough(player, amount)) {
					Account.subtract(player, amount);
					IChatComponent balance = new ChatComponentText("New Balance: $" + PlayerBank.get(player).getCurrent(player));
					EntityItem entityItem = player.dropPlayerItemWithRandomChoice(itemStack, false);
					entityItem.delayBeforeCanPickup = 0;
					player.addChatComponentMessage(balance);
				} else {
					player.addChatComponentMessage(Errors.insufficent);
				}
			}
		}
	}
	@Override
    public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
        return p_71516_2_.length == 1 ? getListOfStringsFromIterableMatchingLastWord(p_71516_2_, Item.itemRegistry.getKeys()) : null;
    }

    protected String[] getPlayers() {
        return MinecraftServer.getServer().getAllUsernames();
    }
}
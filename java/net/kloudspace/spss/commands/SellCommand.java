package net.kloudspace.spss.commands;

import net.kloudspace.spss.economy.Account;
import net.kloudspace.spss.properties.Errors;
import net.kloudspace.spss.properties.PlayerBank;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class SellCommand extends CommandBase {

	@Override
	public String getCommandName() {
		return "sell";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "Sells currently held Item/Block";
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
			Item item = player.inventory.getCurrentItem().getItem();
			int i = 1;
			int j = 0;
			if(args.length >= 1) {
				i = parseIntBounded(sender, args[0], 1, 64);
				System.out.println("i = "+i);
			}
//			System.out.println("i = " + i);
			if(!Account.itemIncluded(item)) {
				player.addChatComponentMessage(Errors.notAvalible);
				return;
			}
			int amount = Account.multiply(PlayerBank.getValue(item), i);
			ItemStack itemStack = new ItemStack(item, i);
			PlayerBank bank = PlayerBank.get(player);
			int stack = player.inventory.getCurrentItem().stackSize;
			if(i > stack) {
				player.addChatComponentMessage(Errors.stackToSmall);
				return;
			}
			Account.add(player, amount);
			IChatComponent balance = new ChatComponentText("New Balance: $" + PlayerBank.get(player).getCurrent(player));
			int slot = player.inventory.currentItem;
			player.inventory.decrStackSize(slot, i);
			player.addChatComponentMessage(balance);
		}
	}
}

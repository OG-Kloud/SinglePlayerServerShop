package net.kloudspace.spss.economy;

import net.kloudspace.spss.properties.PlayerBank;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

public class Account {
	
	public int balance(EntityPlayer player) {
		return PlayerBank.get(player).getCurrent(player);
	}
	
	public static boolean set(EntityPlayer player, int amount) {
		PlayerBank bank = PlayerBank.get(player);
		bank.set(player, amount);
		if(bank.getCurrent(player) == amount) return true;
		return false;
	}
	
	public static boolean add(EntityPlayer player, int amount) {
		if(player != null) {
			PlayerBank bank = PlayerBank.get(player);
			bank.increaseBank(amount);
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean subtract(EntityPlayer player, int amount) {
		if(player != null) {
			PlayerBank bank = PlayerBank.get(player);
			bank.decrease(amount);
			return true;
		} else {
			return false;
		}
	}
	
	public static int multiply(int amount1, int amount2) {
		int total = amount1 * amount2;
		return total;
	}
	
	public static int divide(int amount1, int amount2) {
		int total = amount1/amount2;
		return total;
	}
	
	public static boolean hasEnough(EntityPlayer player, int amount) {
		if(player != null) {
			PlayerBank bank = PlayerBank.get(player);
			int current = bank.getCurrent(player);
			return current >= amount;
		} else {
			return false;
		}
	}
	public static boolean itemIncluded(Item item) {
		if(PlayerBank.value.containsKey(item)){
			return true;
		} else {
			return false;
		}
	}
	
	
	
}

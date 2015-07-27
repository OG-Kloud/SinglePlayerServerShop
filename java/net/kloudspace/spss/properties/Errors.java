package net.kloudspace.spss.properties;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class Errors {
	
	public static IChatComponent insufficent = new ChatComponentText("Insufficent Funds");
	public static IChatComponent notAvalible = new ChatComponentText("Item not found in map, Please stay tuned to future updates");
	public static IChatComponent invalidNumber = new ChatComponentText("Number out of Bounds, Pluse use a number between 1 and 64");
	public static IChatComponent stackToSmall = new ChatComponentText("The currently held stack does not contain enought Items to prosses this command");
	
}

package net.kloudspace.spss.links;

import static net.minecraft.init.Blocks.acacia_stairs;
import static net.minecraft.init.Blocks.activator_rail;
import static net.minecraft.init.Blocks.anvil;

import java.util.HashMap;

import net.minecraft.block.Block;


public class BlockMap {
	public static HashMap<Block, Integer> value = new HashMap<Block, Integer>();
	
	public static void init() {
		value.put(acacia_stairs, 5);
		value.put(activator_rail, 55);
		value.put(anvil, 85);
	}

}

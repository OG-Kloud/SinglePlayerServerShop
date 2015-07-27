package net.kloudspace.spss.properties;

import static net.minecraft.init.Blocks.bookshelf;
import static net.minecraft.init.Blocks.coal_ore;
import static net.minecraft.init.Blocks.cobblestone;
import static net.minecraft.init.Blocks.detector_rail;
import static net.minecraft.init.Blocks.diamond_ore;
import static net.minecraft.init.Blocks.dirt;
import static net.minecraft.init.Blocks.dispenser;
import static net.minecraft.init.Blocks.glass;
import static net.minecraft.init.Blocks.gold_block;
import static net.minecraft.init.Blocks.gold_ore;
import static net.minecraft.init.Blocks.golden_rail;
import static net.minecraft.init.Blocks.grass;
import static net.minecraft.init.Blocks.gravel;
import static net.minecraft.init.Blocks.iron_block;
import static net.minecraft.init.Blocks.iron_ore;
import static net.minecraft.init.Blocks.lapis_block;
import static net.minecraft.init.Blocks.lapis_ore;
import static net.minecraft.init.Blocks.log;
import static net.minecraft.init.Blocks.log2;
import static net.minecraft.init.Blocks.noteblock;
import static net.minecraft.init.Blocks.obsidian;
import static net.minecraft.init.Blocks.piston;
import static net.minecraft.init.Blocks.planks;
import static net.minecraft.init.Blocks.sand;
import static net.minecraft.init.Blocks.sandstone;
import static net.minecraft.init.Blocks.sponge;
import static net.minecraft.init.Blocks.sticky_piston;
import static net.minecraft.init.Blocks.stone;
import static net.minecraft.init.Blocks.tnt;
import static net.minecraft.init.Blocks.web;
import static net.minecraft.init.Items.apple;
import static net.minecraft.init.Items.arrow;
import static net.minecraft.init.Items.baked_potato;
import static net.minecraft.init.Items.bed;
import static net.minecraft.init.Items.beef;
import static net.minecraft.init.Items.blaze_powder;
import static net.minecraft.init.Items.blaze_rod;
import static net.minecraft.init.Items.boat;
import static net.minecraft.init.Items.bone;
import static net.minecraft.init.Items.book;
import static net.minecraft.init.Items.bow;
import static net.minecraft.init.Items.bowl;
import static net.minecraft.init.Items.bread;
import static net.minecraft.init.Items.brewing_stand;
import static net.minecraft.init.Items.brick;
import static net.minecraft.init.Items.bucket;
import static net.minecraft.init.Items.cake;
import static net.minecraft.init.Items.carrot;
import static net.minecraft.init.Items.carrot_on_a_stick;
import static net.minecraft.init.Items.cauldron;
import static net.minecraft.init.Items.chainmail_boots;
import static net.minecraft.init.Items.chainmail_chestplate;
import static net.minecraft.init.Items.chainmail_helmet;
import static net.minecraft.init.Items.chainmail_leggings;
import static net.minecraft.init.Items.chest_minecart;
import static net.minecraft.init.Items.chicken;
import static net.minecraft.init.Items.clay_ball;
import static net.minecraft.init.Items.clock;
import static net.minecraft.init.Items.coal;
import static net.minecraft.init.Items.comparator;
import static net.minecraft.init.Items.compass;
import static net.minecraft.init.Items.cooked_beef;
import static net.minecraft.init.Items.cooked_chicken;
import static net.minecraft.init.Items.cooked_fished;
import static net.minecraft.init.Items.cooked_porkchop;
import static net.minecraft.init.Items.cookie;
import static net.minecraft.init.Items.diamond;
import static net.minecraft.init.Items.diamond_axe;
import static net.minecraft.init.Items.diamond_boots;
import static net.minecraft.init.Items.diamond_chestplate;
import static net.minecraft.init.Items.diamond_helmet;
import static net.minecraft.init.Items.diamond_hoe;
import static net.minecraft.init.Items.diamond_horse_armor;
import static net.minecraft.init.Items.diamond_leggings;
import static net.minecraft.init.Items.diamond_pickaxe;
import static net.minecraft.init.Items.diamond_shovel;
import static net.minecraft.init.Items.diamond_sword;
import static net.minecraft.init.Items.egg;
import static net.minecraft.init.Items.emerald;
import static net.minecraft.init.Items.ender_eye;
import static net.minecraft.init.Items.ender_pearl;
import static net.minecraft.init.Items.experience_bottle;
import static net.minecraft.init.Items.feather;
import static net.minecraft.init.Items.fermented_spider_eye;
import static net.minecraft.init.Items.fire_charge;
import static net.minecraft.init.Items.fish;
import static net.minecraft.init.Items.fishing_rod;
import static net.minecraft.init.Items.flint;
import static net.minecraft.init.Items.flint_and_steel;
import static net.minecraft.init.Items.flower_pot;
import static net.minecraft.init.Items.furnace_minecart;
import static net.minecraft.init.Items.ghast_tear;
import static net.minecraft.init.Items.glass_bottle;
import static net.minecraft.init.Items.glowstone_dust;
import static net.minecraft.init.Items.gold_ingot;
import static net.minecraft.init.Items.gold_nugget;
import static net.minecraft.init.Items.golden_apple;
import static net.minecraft.init.Items.golden_axe;
import static net.minecraft.init.Items.golden_boots;
import static net.minecraft.init.Items.golden_carrot;
import static net.minecraft.init.Items.golden_chestplate;
import static net.minecraft.init.Items.golden_helmet;
import static net.minecraft.init.Items.golden_hoe;
import static net.minecraft.init.Items.golden_horse_armor;
import static net.minecraft.init.Items.golden_leggings;
import static net.minecraft.init.Items.golden_pickaxe;
import static net.minecraft.init.Items.golden_shovel;
import static net.minecraft.init.Items.golden_sword;
import static net.minecraft.init.Items.gunpowder;
import static net.minecraft.init.Items.lava_bucket;

import java.util.HashMap;

import net.kloudspace.spss.Common;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerBank implements IExtendedEntityProperties{
	
	public final static String PLAYER_BANK = "PlayerBank";
	private final EntityPlayer player;
	private static int currentBank, maxBank;
	
	public PlayerBank(EntityPlayer play) {
		player = play;
		this.currentBank = this.getCurrent(play);
		this.maxBank = 50000;
	}
	
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(PLAYER_BANK, new PlayerBank(player));
	}
	
	public static final PlayerBank get(EntityPlayer player) {
		return (PlayerBank) player.getExtendedProperties(PLAYER_BANK);
	}
	
	public static int getCurrent(EntityPlayer player) {
		PlayerBank bank = get(player);
		return bank.currentBank;
	}
	
	public static HashMap<Item, Integer> value = new HashMap<Item, Integer>();
	public static HashMap<Block, Integer> values = new HashMap<Block, Integer>();
	private static int drops = 1;
	private static int fuel = 2;
	private static double gn = 0.75;
	private static int base =1;
	private static int gold = (int)(gn*9);
	private static int wood = (int)(gn*2);
	private static int iron = (int)(gn*18);
	private static int dia = (int)(gn*72);
	private static int cook = 10;
	private static int nBase = 8;
	
	
	public static void init() {
		value.put(apple, base);
		value.put(arrow, base);
		value.put(baked_potato, (base+cook));
		value.put(bed, 15);
		value.put(beef, base);
		value.put(blaze_powder, nBase);
		value.put(blaze_rod, (nBase*3));
		value.put(boat, 5);
		value.put(bone, base);
		value.put(book, (base*4));
		value.put(bow, (base*6));
		value.put(bowl, wood*3);
		value.put(bread, (base*3));
		value.put(brewing_stand, ((base*3)+iron));
		value.put(brick, 2);
		value.put(bucket, (iron*3));
		value.put(lava_bucket, ((iron*3)+20));
		value.put(comparator, ((gold*3)+(base*3)+(nBase*3)));
		value.put(cake, 16);
		value.put(carrot, base);
		value.put(carrot_on_a_stick, 12);
		value.put(cauldron, (iron*7));
		value.put(chainmail_boots, (iron+13));
		value.put(chainmail_chestplate, (iron*17));
		value.put(chainmail_helmet, (iron*14));
		value.put(chainmail_leggings, (iron*16));
		value.put(chest_minecart, ((iron*5)+(base*8)));
		value.put(chicken, base);
		value.put(clay_ball, base);
		value.put(clock, (gold*5));
		value.put(coal, 5);
		value.put(compass, (iron*5));
		value.put(cooked_beef, (base+cook));
		value.put(cooked_chicken, (base+cook));
		value.put(cooked_fished, (base+cook));
		value.put(cooked_porkchop, (base+cook));
		value.put(cookie, 3);
		value.put(diamond, dia);
		value.put(diamond_axe, (dia*3));
		value.put(diamond_boots, dia*4);
		value.put(diamond_chestplate, (dia*8));
		value.put(diamond_helmet, (dia*5));
		value.put(diamond_hoe, dia*2);
		value.put(diamond_horse_armor, 250);
		value.put(diamond_leggings, (dia*7));
		value.put(diamond_pickaxe, dia*3);
		value.put(diamond_shovel, dia);
		value.put(diamond_sword, (dia*2));
		//value.put(dye, 3);
		value.put(egg, base);
		value.put(emerald, dia);
//		value.put(enchanted_book, 99);
		value.put(ender_eye, nBase);
		value.put(ender_pearl, nBase);
		value.put(experience_bottle, 12);
		value.put(feather, base);
		value.put(fermented_spider_eye, (base*5));
		value.put(fire_charge, (nBase));
		value.put(fish, base);
		value.put(fishing_rod, 8);
		value.put(flint, base);
		value.put(flint_and_steel, (base+iron));
		value.put(flower_pot, base);
		value.put(furnace_minecart, ((iron*5)+(base*7)));
		value.put(ghast_tear, nBase);
		value.put(glass_bottle, 3);
		value.put(glowstone_dust, nBase);
		value.put(gold_ingot, gold);
		value.put(gold_nugget, (int)gn);
		value.put(golden_apple, (gold*8)+base);
		value.put(golden_axe, (gold*3));
		value.put(golden_boots, (gold*4));
		value.put(golden_carrot, base*5);
		value.put(golden_chestplate, (gold*8));
		value.put(golden_helmet, (gold*5));
		value.put(golden_hoe, (gold*2));
		value.put(golden_horse_armor, 199);
		value.put(golden_leggings, (gold*7));
		value.put(golden_pickaxe, (gold*3));
		value.put(golden_shovel, gold);
		value.put(golden_sword, (gold*3));
		value.put(gunpowder, base);
		value.put(Item.getItemFromBlock(Blocks.acacia_stairs), 5);
		value.put(Item.getItemFromBlock(Blocks.activator_rail), (gold*6));
		value.put(Item.getItemFromBlock(Blocks.anvil), iron*51);
		value.put(Item.getItemFromBlock(Blocks.bed), 10);
		value.put(Item.getItemFromBlock(Blocks.bedrock), 25000);
		value.put(Item.getItemFromBlock(Blocks.birch_stairs), 5);
		value.put(Item.getItemFromBlock(Blocks.bookshelf), 20);
		value.put(Item.getItemFromBlock(Blocks.brick_block), 4);
		value.put(Item.getItemFromBlock(Blocks.brick_stairs), 5);
		value.put(Item.getItemFromBlock(Blocks.cactus), 3);
		value.put(Item.getItemFromBlock(Blocks.clay), 3);
		value.put(Item.getItemFromBlock(Blocks.coal_block), 25);
		value.put(Item.getItemFromBlock(Blocks.coal_ore), 16);
		value.put(Item.getItemFromBlock(Blocks.cobblestone), 1);
		value.put(Item.getItemFromBlock(Blocks.cobblestone_wall), 8);
		value.put(Item.getItemFromBlock(Blocks.dark_oak_stairs), 5);
		value.put(Item.getItemFromBlock(Blocks.detector_rail), gold*6);
		value.put(Item.getItemFromBlock(Blocks.diamond_block), dia*9);
		value.put(Item.getItemFromBlock(Blocks.diamond_ore), 128);
		value.put(Item.getItemFromBlock(Blocks.dirt), 1);
		value.put(Item.getItemFromBlock(Blocks.dispenser), 13+iron);
		value.put(Item.getItemFromBlock(Blocks.dragon_egg), 10000);
		value.put(Item.getItemFromBlock(Blocks.dropper), 13+iron);
		value.put(Item.getItemFromBlock(Blocks.daylight_detector), ((nBase*3)+3));
		value.put(Item.getItemFromBlock(Blocks.emerald_block), dia*9);
		value.put(Item.getItemFromBlock(Blocks.emerald_ore), 128);
		value.put(Item.getItemFromBlock(Blocks.enchanting_table), 150);
		value.put(Item.getItemFromBlock(Blocks.end_stone), 55);
		value.put(Item.getItemFromBlock(Blocks.ender_chest), dia*8);
		value.put(Item.getItemFromBlock(Blocks.fence), 8);
		value.put(Item.getItemFromBlock(Blocks.fence_gate), 12);
		value.put(Item.getItemFromBlock(Blocks.furnace), 8);
		value.put(Item.getItemFromBlock(Blocks.glass), 2);
		value.put(Item.getItemFromBlock(Blocks.glass_pane), 5);
		value.put(Item.getItemFromBlock(Blocks.glowstone), nBase*4);
		value.put(Item.getItemFromBlock(Blocks.gold_block), gold*9);
		value.put(Item.getItemFromBlock(Blocks.gold_ore), 32);
		value.put(Item.getItemFromBlock(Blocks.golden_rail), gold*6);
		value.put(Item.getItemFromBlock(Blocks.gravel), 1);
		value.put(Item.getItemFromBlock(Blocks.grass), 2);
		value.put(Item.getItemFromBlock(Blocks.hay_block), 9);
		value.put(Item.getItemFromBlock(Blocks.heavy_weighted_pressure_plate), iron*2);
		value.put(Item.getItemFromBlock(Blocks.hopper), iron*7);
		value.put(Item.getItemFromBlock(Blocks.ice), 3);
		value.put(Item.getItemFromBlock(Blocks.iron_bars), iron*6);
		value.put(Item.getItemFromBlock(Blocks.iron_block), iron*9);
		value.put(Item.getItemFromBlock(Blocks.iron_door), iron*6);
		value.put(Item.getItemFromBlock(Blocks.iron_ore), 64);
		value.put(Item.getItemFromBlock(Blocks.jukebox), 3);
		value.put(Item.getItemFromBlock(Blocks.jungle_stairs), 5);
		value.put(Item.getItemFromBlock(Blocks.ladder), 4);
		value.put(Item.getItemFromBlock(Blocks.lapis_block), iron*9);
		value.put(Item.getItemFromBlock(Blocks.lapis_ore), 64);
		value.put(Item.getItemFromBlock(Blocks.light_weighted_pressure_plate), gold*2);
		value.put(Item.getItemFromBlock(Blocks.melon_block), 16);
		value.put(Item.getItemFromBlock(Blocks.mossy_cobblestone), 1);
		value.put(Item.getItemFromBlock(Blocks.mycelium), 16);
		value.put(Item.getItemFromBlock(Blocks.nether_brick), nBase);
		value.put(Item.getItemFromBlock(Blocks.nether_brick_fence), 8);
		value.put(Item.getItemFromBlock(Blocks.nether_brick_stairs), 5);
		value.put(Item.getItemFromBlock(Blocks.netherrack), 1);
		value.put(Item.getItemFromBlock(Blocks.noteblock), 3);
		value.put(Item.getItemFromBlock(Blocks.oak_stairs), 5);
		value.put(Item.getItemFromBlock(Blocks.obsidian), dia);
		value.put(Item.getItemFromBlock(Blocks.packed_ice), 7);
		value.put(Item.getItemFromBlock(Blocks.planks), 1);
		value.put(Item.getItemFromBlock(Blocks.pumpkin), 16);
		value.put(Item.getItemFromBlock(Blocks.piston), 7+iron);
		value.put(Item.getItemFromBlock(Blocks.quartz_block), nBase*4);
		value.put(Item.getItemFromBlock(Blocks.quartz_ore), nBase);
		value.put(Item.getItemFromBlock(Blocks.quartz_stairs), 5);
		value.put(Item.getItemFromBlock(Blocks.rail), iron*3);
		value.put(Item.getItemFromBlock(Blocks.redstone_block), iron*9);
		value.put(Item.getItemFromBlock(Blocks.redstone_lamp), iron*4);
		value.put(Item.getItemFromBlock(Blocks.redstone_ore), 32);
		value.put(Item.getItemFromBlock(Blocks.sandstone), 2);
		value.put(Item.getItemFromBlock(Blocks.sandstone_stairs), 5);
		value.put(Item.getItemFromBlock(Blocks.snow), 4);
		value.put(Item.getItemFromBlock(Blocks.soul_sand), nBase);
		value.put(Item.getItemFromBlock(Blocks.spruce_stairs), 5);
		value.put(Item.getItemFromBlock(Blocks.stone), 1);
		value.put(Item.getItemFromBlock(Blocks.stone_brick_stairs), 5);
		value.put(Item.getItemFromBlock(Blocks.stone_button), 3);
		value.put(Item.getItemFromBlock(Blocks.stone_pressure_plate), 2);
		value.put(Item.getItemFromBlock(Blocks.stone_stairs), 5);
		value.put(Item.getItemFromBlock(Blocks.stonebrick), 4);
		value.put(Item.getItemFromBlock(Blocks.tnt), 15);
	}
	
	public static int getValue(Item item) {
		
		if(value.containsKey(item)) {
			int i = value.get(item);
			return i;
		} else {
		return 0;
		}
	}
	public static int getValue(Item item, int num) {
		if(value.containsKey(item)) {
			int i = value.get(item);
			int j = i* num;
			return j;
		} else {
			return 0;
		}
	}
	public static int getBlockValue(Block block) {
		if(values.containsKey(block)) {
			int i = values.get(block);
			return i;
		}else {
			return 0;
		}
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound prop = new NBTTagCompound();
		compound.setDouble("currentBank", currentBank);
		compound.setDouble("maxBank", maxBank);
		compound.setTag(PLAYER_BANK, prop);
		
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound prop = (NBTTagCompound) compound.getTag(PLAYER_BANK);
		this.currentBank = compound.getInteger("currentBank");
		this.maxBank = compound.getInteger("maxBank");
		System.out.println("Bank from NBT"  + "Current: " + this.currentBank + "/" + "Max: " + this.maxBank);
	}

	@Override
	public void init(Entity entity, World world) {
		
	}
	
	public static boolean decrease(int amount) {
		boolean sufficient = amount <= currentBank;
		if(sufficient && amount != 0) {
			int newTotal = currentBank - amount;
			currentBank = newTotal;
		}
		return sufficient;
	}
	public static boolean hasEnough(EntityPlayer player, int amount) {
		PlayerBank bank = PlayerBank.get(player);
		int i = bank.getCurrent(player);
		if(i - amount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void set(EntityPlayer player, int i) {
		PlayerBank bank = get(player);
		bank.currentBank = i;
	}
	
	public static boolean increaseBank(int amount) {
		boolean allowed = currentBank + amount <=50000;
		
		if(allowed) {
			int newTotal = currentBank + amount;
			currentBank = newTotal;
		}
		return allowed;
	}
	
	private static String getSaveKey(EntityPlayer player) {
		return player.getDisplayName() + ":" + PLAYER_BANK;
		}
	
	public static void saveProxyData(EntityPlayer player) {
		PlayerBank playerData = PlayerBank.get(player);
		NBTTagCompound savedData = new NBTTagCompound();

		playerData.saveNBTData(savedData);

		Common.storeEntityData(getSaveKey(player), savedData);
		}
	public static void loadProxyData(EntityPlayer player) {
		PlayerBank playerData = PlayerBank.get(player);
		NBTTagCompound savedData = Common.getEntityData(getSaveKey(player));

		if(savedData != null) {
		playerData.loadNBTData(savedData);
		}
	}
}
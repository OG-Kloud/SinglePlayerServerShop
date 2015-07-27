package net.kloudspace.spss;

import net.kloudspace.spss.commands.AddCommand;
import net.kloudspace.spss.commands.BalanceCommand;
import net.kloudspace.spss.commands.BuyCommand;
import net.kloudspace.spss.commands.SellCommand;
import net.kloudspace.spss.commands.SetCommand;
import net.kloudspace.spss.commands.WorthCommand;
import net.kloudspace.spss.events.EntityConstructingEvents;
import net.kloudspace.spss.events.LivingDeathEvents;
import net.kloudspace.spss.properties.PlayerBank;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = _Mod.MODID, version = _Mod.VERSION)
public class _Mod
{
    public static final String MODID = "singleplayershop";
    public static final String VERSION = "1.0.1";
    public static final String NAME = "Single Player Server Shop";
    
    @Instance
    public static _Mod instance;
    
    @SidedProxy(clientSide="net.kloudspace.spss.client.Client",serverSide="net.kloudspace.spss.Common")
    public static Common proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	PlayerBank.init();
    	MinecraftForge.EVENT_BUS.register(new EntityConstructingEvents());
    	MinecraftForge.EVENT_BUS.register(new LivingDeathEvents());
    }
    
    @EventHandler
    public void serverStart(FMLServerStartingEvent event) {
    	MinecraftServer server = MinecraftServer.getServer();
    	ICommandManager command = server.getCommandManager();
    	ServerCommandManager manager = (ServerCommandManager)command;
    	manager.registerCommand(new BuyCommand());
    	manager.registerCommand(new AddCommand());
    	manager.registerCommand(new BalanceCommand());
    	manager.registerCommand(new SellCommand());
    	manager.registerCommand(new WorthCommand());
    	manager.registerCommand(new SetCommand());
    }
}

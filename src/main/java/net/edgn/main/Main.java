package net.edgn.main;

import net.edgn.commands.help.HelpPage1;
import net.edgn.commands.raids.RaidInfo;
import net.edgn.commands.raids.ShowPartyRaidCompletions;
import net.edgn.commands.raids.ShowRaidCompletions;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
	
    public static final String MODID = "edgntna";
    public static final String NAME = "edgn mod";
    public static final String VERSION = "1.1";
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    }

	@Mod.EventHandler
    public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new ShowPartyRaidCompletions());
    	//Aide Commandes
    	ClientCommandHandler.instance.registerCommand(new HelpPage1());
    	//Raids Commandes
    	ClientCommandHandler.instance.registerCommand(new ShowRaidCompletions());
    	ClientCommandHandler.instance.registerCommand(new RaidInfo());
    	
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
}


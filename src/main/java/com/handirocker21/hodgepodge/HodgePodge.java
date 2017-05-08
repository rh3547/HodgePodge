package com.handirocker21.hodgepodge;

import com.handirocker21.hodgepodge.init.ModBlocks;
import com.handirocker21.hodgepodge.init.ModCrafting;
import com.handirocker21.hodgepodge.init.ModItems;
import com.handirocker21.hodgepodge.init.ModTools;
import com.handirocker21.hodgepodge.proxy.CommonProxy;
import com.handirocker21.hodgepodge.utils.Utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class HodgePodge {
	
	// The custom event handler
	com.handirocker21.hodgepodge.handlers.EventHandler eventHandler = new com.handirocker21.hodgepodge.handlers.EventHandler();
	
	@Instance
	public static HodgePodge instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Utils.getLogger().info("Pre Initialization");
		
		// Initialize items and blocks
		ModItems.init();
		ModBlocks.init();
		ModTools.init();
		
		// Register items and blocks
		ModItems.register();
		ModBlocks.register();	
		ModTools.register();
		
		// Initialize proxys (register renders)
		proxy.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		Utils.getLogger().info("Initialization");
		
		// Register events
		eventHandler.registerEvents();
		
		// Register crafting recipes
		ModCrafting.registerCraftingRecipes();
		ModCrafting.registerFurnaceRecipes();
		ModCrafting.registerToolRecipes();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Utils.getLogger().info("Post Initialization");
	}
	
	/*
	 * Our custom creative tab.
	 */
	public static CreativeTabs tabHodgePodge = new CreativeTabs("tab_hodgepodge") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.mobMatter);
		}
	};
}

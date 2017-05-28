package com.handirocker21.hodgepodge;

import java.util.List;

import com.handirocker21.hodgepodge.handlers.GuiHandler;
import com.handirocker21.hodgepodge.init.ModBlocks;
import com.handirocker21.hodgepodge.init.ModCrafting;
import com.handirocker21.hodgepodge.init.ModEntities;
import com.handirocker21.hodgepodge.init.ModFluids;
import com.handirocker21.hodgepodge.init.ModItems;
import com.handirocker21.hodgepodge.init.ModTools;
import com.handirocker21.hodgepodge.network.PacketRequestUpdatePedestal;
import com.handirocker21.hodgepodge.network.PacketUpdatePedestal;
import com.handirocker21.hodgepodge.proxy.CommonProxy;
import com.handirocker21.hodgepodge.utils.Utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class HodgePodge {
	
	// The custom event handler
	com.handirocker21.hodgepodge.handlers.EventHandler eventHandler = new com.handirocker21.hodgepodge.handlers.EventHandler();
	
	
	public static SimpleNetworkWrapper wrapper;

	@Instance
	public static HodgePodge instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static FluidRegistry registry;
	
	// Must be called before preInit
	static {
		FluidRegistry.enableUniversalBucket();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Utils.getLogger().info("Pre Initialization");

		// Initialize items and blocks
		ModFluids.init();
		ModItems.init();
		ModBlocks.init();
		ModTools.init();
		
		// Register items and blocks
		ModItems.register();
		ModBlocks.register();	
		ModTools.register();

		// Register GUI handler
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
			
		wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
		wrapper.registerMessage(new PacketUpdatePedestal.Handler(), PacketUpdatePedestal.class, 0, Side.CLIENT);
		wrapper.registerMessage(new PacketRequestUpdatePedestal.Handler(), PacketRequestUpdatePedestal.class, 1, Side.SERVER);
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
		
		// Register mobs
		ModEntities.register();
		
		proxy.init();
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
		public Item getTabIconItem() {
			return ModItems.mobMatter;
		}
		
		@SideOnly(Side.CLIENT)
		@Override
		public void displayAllRelevantItems(List<ItemStack> items) {
			items.add(UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket,
					FluidRegistry.getFluid(Reference.HodgePodgeBlocks.MOBMATTER_FLUID_BLOCK.getUnlocalizedName())));
			super.displayAllRelevantItems(items);
		}
	};
}

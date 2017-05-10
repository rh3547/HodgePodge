package com.handirocker21.hodgepodge.init;

import com.handirocker21.hodgepodge.HodgePodge;
import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.blocks.BlockPoweredGem;
import com.handirocker21.hodgepodge.blocks.pedestal.BlockPedestal;
import com.handirocker21.hodgepodge.utils.Utils;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	/*
	 * Blocks
	 */
	public static Block poweredGemBlock;
	public static BlockPedestal pedestal;

	/**
	 * Initialize Blocks.
	 */
	public static void init() {
		poweredGemBlock = new BlockPoweredGem(); 
		pedestal = new BlockPedestal();
	}
	
	/**
	 * Register all blocks.
	 */
	public static void register() {
		registerBlock(poweredGemBlock);
		registerBlock(pedestal);
	}
	
	/**
	 * Register all block renders.
	 */
	public static void registerRenders() {
		registerRender(poweredGemBlock);
		registerRender(pedestal);
	}
	
	/**
	 * Register the given block.
	 * @param block
	 */
	private static void registerBlock(Block block) {
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered block " + block.getUnlocalizedName().substring(5));

		block.setCreativeTab(HodgePodge.tabHodgePodge);
	}
	
	/**
	 * Register the given block's model render.
	 * @param block
	 */
	private static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(
				new ResourceLocation(Reference.MOD_ID, block.getUnlocalizedName().substring(5)), "inventory"));
		
		Utils.getLogger().info("Register render for " + block.getUnlocalizedName().substring(5));
	}

}


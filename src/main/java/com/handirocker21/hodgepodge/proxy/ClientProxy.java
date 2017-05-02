package com.handirocker21.hodgepodge.proxy;

import com.handirocker21.hodgepodge.Reference;

import init.ModBlocks;
import init.ModItems;
import init.ModTools;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ClientProxy implements CommonProxy {

	@Override
	public void init() {
		
		/*
		 * Register renders client side only.
		 */
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		ModTools.registerRenders();
	}

	@Override
	public void registerTileEntities() {
		
	}

	@Override
	public void registerModelBakery() {
		
	}
}

package com.handirocker21.hodgepodge.proxy;

import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.init.ModBlocks;
import com.handirocker21.hodgepodge.init.ModItems;
import com.handirocker21.hodgepodge.init.ModTools;

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

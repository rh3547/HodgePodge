package com.handirocker21.hodgepodge.proxy;

import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.blocks.pedestal.TESRPedestal;
import com.handirocker21.hodgepodge.init.ModBlocks;
import com.handirocker21.hodgepodge.init.ModEntities;
import com.handirocker21.hodgepodge.init.ModItems;
import com.handirocker21.hodgepodge.init.ModTools;
import com.handirocker21.hodgepodge.tileentity.TileEntityPedestal;

import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy implements CommonProxy {

	@Override
	public void init() {
		/*
		 * Register renders client side only.
		 */
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		ModTools.registerRenders();
		ModEntities.registerRenders();
		registerTileEntities();
		registerRenderers();		
	}

	@Override
	public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityPedestal.class, Reference.MOD_ID + "TileEntityPedestal");

	}
	
	@Override
	public String localize(String unlocalized, Object... args) {
		return I18n.format(unlocalized, args);
	}

	@Override
	public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPedestal.class, new TESRPedestal());
		
	}

}

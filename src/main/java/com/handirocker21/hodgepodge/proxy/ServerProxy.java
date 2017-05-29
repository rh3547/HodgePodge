package com.handirocker21.hodgepodge.proxy;

import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.tileentity.TileEntityPedestal;

import net.minecraft.client.resources.I18n;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ServerProxy implements CommonProxy {
	
	@Override
	public void preInit() {
		
	}
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void registerTileEntities() {
		
	}

	@Override
	public String localize(String unlocalized, Object... args) {
		return I18n.format(unlocalized, args);
	}

	@Override
	public void registerRenderers() {
		
	}
}

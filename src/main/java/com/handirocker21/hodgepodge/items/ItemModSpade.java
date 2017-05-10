package com.handirocker21.hodgepodge.items;

import net.minecraft.item.ItemSpade;

public class ItemModSpade extends ItemSpade {

	public ItemModSpade(ToolMaterial material, String unlocalizedName, String registryName) {
		super(material);
		
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
	}
}

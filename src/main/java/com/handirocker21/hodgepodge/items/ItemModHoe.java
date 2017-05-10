package com.handirocker21.hodgepodge.items;

import net.minecraft.item.ItemHoe;

public class ItemModHoe extends ItemHoe {

	public ItemModHoe(ToolMaterial material, String unlocalizedName, String registryName) {
		super(material);
		
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
	}
}

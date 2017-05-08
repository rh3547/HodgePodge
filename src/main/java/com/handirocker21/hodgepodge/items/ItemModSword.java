package com.handirocker21.hodgepodge.items;

import net.minecraft.item.ItemSword;

public class ItemModSword extends ItemSword {

	public ItemModSword(ToolMaterial material, String unlocalizedName, String registryName) {
		super(material);
		
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
	}
}

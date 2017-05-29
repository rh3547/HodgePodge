package com.handirocker21.hodgepodge.meshes;

import com.handirocker21.hodgepodge.init.ModTools;
import com.handirocker21.hodgepodge.items.ItemNightsBane;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;

public class NightsBaneMeshDefinition implements ItemMeshDefinition {

	@Override
	public ModelResourceLocation getModelLocation(ItemStack stack) {
		
		if(stack.getItem() == ModTools.nightsBane) {
			ItemNightsBane bane = (ItemNightsBane)stack.getItem();
			
			if (bane.isUpgraded()) {
				
				switch (bane.getPowerHits()) {
					case 4:
						return new ModelResourceLocation(ModTools.nightsBane.getRegistryName() + "_ph4", "inventory");
						
					case 3:
						return new ModelResourceLocation(ModTools.nightsBane.getRegistryName() + "_ph3", "inventory");
						
					case 2:
						return new ModelResourceLocation(ModTools.nightsBane.getRegistryName() + "_ph2", "inventory");
						
					case 1:
						return new ModelResourceLocation(ModTools.nightsBane.getRegistryName() + "_ph1", "inventory");
						
					default:
						return new ModelResourceLocation(ModTools.nightsBane.getRegistryName() + "_night", "inventory");
				}
			}
			else {
				return new ModelResourceLocation(ModTools.nightsBane.getRegistryName(), "inventory");
			}
		}
		
		return null;
	}
}

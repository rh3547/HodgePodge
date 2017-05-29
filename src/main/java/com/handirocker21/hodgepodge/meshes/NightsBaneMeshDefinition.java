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
			
			if (!stack.hasTagCompound())
				return new ModelResourceLocation(ModTools.nightsBane.getRegistryName(), "inventory");
			
			if (stack.getTagCompound().getBoolean("doUpgrade")) {
				
				switch (stack.getTagCompound().getInteger("powerHits")) {
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

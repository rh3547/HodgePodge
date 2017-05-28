package com.handirocker21.hodgepodge.fluids;

import com.handirocker21.hodgepodge.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidMobMatter extends Fluid {
	public static final String name = Reference.HodgePodgeBlocks.MOBMATTER_FLUID_BLOCK.getRegistryName();
	
	/**
	 * Constructor that initializes a fluid.
	 * Assigning a name and references to the still and flow texture locations.
	 */
	public FluidMobMatter() {
		super(name, new ResourceLocation(Reference.MOD_ID + ":" + "blocks/" + name  + "_still"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "blocks/" + name  + "_flow"));
		this.setLuminosity(1);
	}

}
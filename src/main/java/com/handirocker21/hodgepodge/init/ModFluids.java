package com.handirocker21.hodgepodge.init;

import com.handirocker21.hodgepodge.HodgePodge;
import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.blocks.BlockMobMatter;
import com.handirocker21.hodgepodge.fluids.FluidMobMatter;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModFluids {
	
	public static ModelResourceLocation mobmatter_location = new ModelResourceLocation(Reference.MOD_ID + ":" + Reference.HodgePodgeBlocks.MOBMATTER_FLUID_BLOCK.getUnlocalizedName(), "fluid" );
	public static FluidMobMatter fluidMobMatter; 
	public static BlockMobMatter blockMobMatter;
	
	/**
	 * Initializes fluids and fluid blocks. 
	 */
	public static void init() { 
		fluidMobMatter = new FluidMobMatter();
		
		FluidRegistry.registerFluid(fluidMobMatter);
		FluidRegistry.addBucketForFluid(fluidMobMatter);
		blockMobMatter = new BlockMobMatter(fluidMobMatter);
		
		GameRegistry.registerBlock(blockMobMatter, Reference.HodgePodgeBlocks.MOBMATTER_FLUID_BLOCK.getRegistryName());
		ModFluids.registerRenders();
	}
	
	/**
	 * Registers renders for fluids.
	 */
	public static void registerRenders() {
		registerRender(blockMobMatter, mobmatter_location);
	}
	
	/**
	 * Registers renders by setting item mesh and state mapper for fluids.
	 * @param fluidBlock
	 * @param location
	 */
	public static void registerRender(BlockFluidClassic fluidBlock, ModelResourceLocation location) {
		Item item = Item.getItemFromBlock(fluidBlock);
		
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
			
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return location;
			}
		});
		
		ModelLoader.setCustomStateMapper(fluidBlock, new StateMapperBase(){

			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return location;
			}
			
		});
	}
}

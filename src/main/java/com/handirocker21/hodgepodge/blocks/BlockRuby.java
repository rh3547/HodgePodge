package com.handirocker21.hodgepodge.blocks;

import java.util.Random;

import com.handirocker21.hodgepodge.HodgePodge;
import com.handirocker21.hodgepodge.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockRuby extends Block {

	public BlockRuby() {
		super(Material.IRON);
		
		setUnlocalizedName(Reference.HodgePodgeBlocks.RUBY_BLOCK.getUnlocalizedName());
		setRegistryName(Reference.HodgePodgeBlocks.RUBY_BLOCK.getRegistryName());
		
		setHardness(6.0F);
		setResistance(15.0F);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}
}

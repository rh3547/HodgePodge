package com.handirocker21.hodgepodge.blocks;

import java.util.Random;

import com.handirocker21.hodgepodge.HodgePodge;
import com.handirocker21.hodgepodge.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockPoweredGem extends Block {

	public BlockPoweredGem() {
		super(Material.IRON);
		
		setUnlocalizedName(Reference.HodgePodgeBlocks.POWERED_GEM_BLOCK.getUnlocalizedName());
		setRegistryName(Reference.HodgePodgeBlocks.POWERED_GEM_BLOCK.getRegistryName());
		
		setHardness(6.0F);
		setResistance(15.0F);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}
	
	/**
     * Can this block provide power. Only wire currently seems to have this change based on its state.
     */
	@Override
    public boolean canProvidePower(IBlockState state)
    {
        return true;
    }
	
	@Override
    public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return 15;
    }
}

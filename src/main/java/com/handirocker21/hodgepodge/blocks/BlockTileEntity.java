package com.handirocker21.hodgepodge.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import com.handirocker21.hodgepodge.Reference;

public abstract class BlockTileEntity<TE extends TileEntity> extends Block {
	
	/**
	 * Constructor that initializes material and name for tile entity blocks.
	 * @param material
	 * @param name
	 */
	public BlockTileEntity(Material material, String name) {
		super(material);		
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	/**
	 * Gets the tile entity class.
	 * @return
	 */
	public abstract Class<TE> getTileEntityClass();
	
	/**
	 * Gets the tile entity in the world.
	 * @param world
	 * @param pos
	 * @return
	 */
	public TE getTileEntity(IBlockAccess world, BlockPos pos) {
		return (TE)world.getTileEntity(pos);
	}
	
	/**
	 * Returns a boolean if a block state has tile entity.
	 */
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	/**
	 * Creates a tile entity.
	 */
	@Nullable
	@Override
	public abstract TE createTileEntity(World world, IBlockState state);
}
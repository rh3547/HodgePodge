package com.handirocker21.hodgepodge.blocks;

import com.handirocker21.hodgepodge.HodgePodge;
import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.fluids.FluidMobMatter;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidBlock;

public class BlockMobMatter extends BlockFluidClassic {

	/**
	 * Constructor that initializes a fluid block.
	 * @param fluid
	 */
	public BlockMobMatter(Fluid fluid){
		super(fluid, Material.WATER);
		setUnlocalizedName(Reference.HodgePodgeBlocks.MOBMATTER_FLUID_BLOCK.getUnlocalizedName());
	}

	/**
	 * Gets the render type for the fluid block and returns a model.
	 */
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state){
		return EnumBlockRenderType.MODEL;
	}

	/**
	 * Called when an entity collides with the block.
	 * Gives the entity that collides a hunger potion effect.
	 */
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if(entityIn instanceof EntityLivingBase) {
			((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(17), 20 * 1));
		}
	}

	/**
	 * Called after the block is set in the chunk data, but before the tile entity is set.
	 * Override to call the collidingFluids() method.
	 */
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		super.onBlockAdded(world, pos, state);
		collidingFluids(pos, world);
	}

	/**
	 * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
	 * change. Override to call the collidingFluids() method.
	 */
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock) {
		super.neighborChanged(state, world, pos, neighborBlock);
		collidingFluids(pos, world);
	}

	/**
	 * Checks if the custom fluid is colliding with another fluid.
	 * @param pos
	 * @param world
	 */
	private void collidingFluids(BlockPos pos, World world) {
		for(EnumFacing facing : EnumFacing.values()) {
			Block block = world.getBlockState(pos.offset(facing)).getBlock();
			if(block == Blocks.LAVA || block == Blocks.FLOWING_LAVA) {
				world.createExplosion(null, (float)pos.getX() + 0.5F, (float)pos.getY() + 0.5F, (float)pos.getZ() + 0.5F, 3F, false);
			}
		}
	}

	/**
	 * Checks if the fluid block is covered.
	 * @param world
	 * @param pos
	 * @return
	 */
	private boolean isCoveredWithFluid(IBlockAccess world, BlockPos pos) {
		IBlockState here = world.getBlockState(pos);
		IBlockState up = world.getBlockState(pos.down(densityDir));
		if (here.getBlock() == this && (up.getMaterial().isLiquid() || up.getBlock() instanceof IFluidBlock)) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the extended block state for the fluid.
	 * Override to fix fluid model rendering with gaps.
	 * Known forge issue: https://github.com/MinecraftForge/MinecraftForge/issues/2993
	 */
	@Override
	public IBlockState getExtendedState(IBlockState oldState, IBlockAccess worldIn, BlockPos pos) {
		IExtendedBlockState state = (IExtendedBlockState)oldState;
		state = state.withProperty(FLOW_DIRECTION, (float)getFlowDirection(worldIn, pos));
		float[][] height = new float[3][3];
		float[][] corner = new float[2][2];
		height[1][1] = getFluidHeightForRender(worldIn, pos);
		if(height[1][1] == 1) {
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 2; j++) {
					corner[i][j] = 1;
				}
			}
		}else{
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(i != 1 || j != 1) {
						height[i][j] = getFluidHeightForRender(worldIn, pos.add(i - 1, 0, j - 1));
					}
				}
			}
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 2; j++) {
					corner[i][j] = getFluidHeightAverage(height[i][j], height[i][j + 1], height[i + 1][j], height[i + 1][j + 1]);
				}
			}
		}

		// Check for down flow above corners
		if(isCoveredWithFluid(worldIn, pos.add(-1, 0, -1)) || isCoveredWithFluid(worldIn, pos.add(-1, 0,  0)) || isCoveredWithFluid(worldIn, pos.add(0, 0, -1)))
			corner[0][0] = 1;
		if(isCoveredWithFluid(worldIn, pos.add(-1, 0,  0)) || isCoveredWithFluid(worldIn, pos.add(-1, 0,  1)) || isCoveredWithFluid(worldIn, pos.add(0, 0,  1)))
			corner[0][1] = 1;
		if(isCoveredWithFluid(worldIn, pos.add( 0, 0, -1)) || isCoveredWithFluid(worldIn, pos.add( 1, 0, -1)) || isCoveredWithFluid(worldIn, pos.add(1, 0,  0)))
			corner[1][0] = 1;
		if(isCoveredWithFluid(worldIn, pos.add( 1, 0,  0)) || isCoveredWithFluid(worldIn, pos.add( 0, 0,  1)) || isCoveredWithFluid(worldIn, pos.add(1, 0,  1)))
			corner[1][1] = 1;

		state = state.withProperty(LEVEL_CORNERS[0], corner[0][0]);
		state = state.withProperty(LEVEL_CORNERS[1], corner[0][1]);
		state = state.withProperty(LEVEL_CORNERS[2], corner[1][1]);
		state = state.withProperty(LEVEL_CORNERS[3], corner[1][0]);
		return state;
	}
}
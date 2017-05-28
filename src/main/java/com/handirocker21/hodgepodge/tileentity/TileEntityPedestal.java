package com.handirocker21.hodgepodge.tileentity;

import javax.annotation.Nullable;

import com.handirocker21.hodgepodge.HodgePodge;
import com.handirocker21.hodgepodge.network.PacketRequestUpdatePedestal;
import com.handirocker21.hodgepodge.network.PacketUpdatePedestal;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityPedestal extends TileEntity {

	public long lastChangeTime;

	public ItemStackHandler inventory = new ItemStackHandler(1) {
		
		/**
		 * Called when the contents of the tile entity's inventory are changed.
		 */
		@Override
		protected void onContentsChanged(int slot) {
			if (!worldObj.isRemote) {
				lastChangeTime = worldObj.getTotalWorldTime();
				HodgePodge.wrapper.sendToAllAround(
						new PacketUpdatePedestal(TileEntityPedestal.this), new NetworkRegistry.TargetPoint(worldObj.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
			}
		}
	};
	
	/**
	 * Called from the chunk when this is first added to the world. 
	 * Happens after validate and after it has been placed into the chunk tile entity map.
	 */
	@Override
	public void onLoad() {
		if (worldObj.isRemote) {
			HodgePodge.wrapper.sendToServer(new PacketRequestUpdatePedestal(this));
		}
	}
	
	/**
	 * Return an AxisAlignedBB that controls the visible scope of a TileEntitySpecialRenderer associated with this tile entity.
	 */
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(getPos(), getPos().add(1, 2, 1));
	}
	
	/**
	 * Writes to NBTTagCompound, the serialized inventory data, and last change time.
	 */
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("inventory", inventory.serializeNBT());
		compound.setLong("lastChangeTime", lastChangeTime);
		return super.writeToNBT(compound);
	}
	
	/**
	 * Reads from the NBTTagCompound, the deserialized inventory data, and last change time.
	 */
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		inventory.deserializeNBT(compound.getCompoundTag("inventory"));
		lastChangeTime = compound.getLong("lastChangeTime");
		super.readFromNBT(compound);
	}
	
	/**
	 * Determines if this tile entity has support for the item handler capability on the specific side.
	 */
	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
	}
	
	/**
	 * Retrieves the handler for the item handler capability on the specific side for the tile entity.
	 */
	@Nullable
	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)inventory : super.getCapability(capability, facing);
	}
}
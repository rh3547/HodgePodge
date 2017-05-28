package com.handirocker21.hodgepodge.network;

import com.handirocker21.hodgepodge.tileentity.TileEntityPedestal;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketUpdatePedestal implements IMessage {
	
	private BlockPos pos;
	private ItemStack stack;
	private long lastChangeTime;
	
	/**
	 * Deconstruct the block position, stack, and last change time to bytes.
	 */
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeLong(pos.toLong());
		ByteBufUtils.writeItemStack(buf, stack);
		buf.writeLong(lastChangeTime);
	}
	
	/**
	 * Convert from the block position, stack, and last change time from different types.
	 */
	@Override
	public void fromBytes(ByteBuf buf) {
		pos = BlockPos.fromLong(buf.readLong());
		stack = ByteBufUtils.readItemStack(buf);
		lastChangeTime = buf.readLong();
	}
	
	/**
	 * Initializes the position, stack, and last change time for tile entity.
	 * @param pos
	 * @param stack
	 * @param lastChangeTime
	 */
	public PacketUpdatePedestal(BlockPos pos, ItemStack stack, long lastChangeTime) {
		this.pos = pos;
		this.stack = stack;
		this.lastChangeTime = lastChangeTime;
	}
	
	/**
	 * Gets the tile entity position, stack in current slot, and last change time.
	 * @param te
	 */
	public PacketUpdatePedestal(TileEntityPedestal te) {
		this(te.getPos(), te.inventory.getStackInSlot(0), te.lastChangeTime);
	}
	
	/**
	 * Empty constructor.
	 */
	public PacketUpdatePedestal() {}
	
	public static class Handler implements IMessageHandler<PacketUpdatePedestal, IMessage> {
		
		/**
		 * Called when a message is received of the appropriate type.
		 * You can optionally return a reply message, or null if no reply is needed.
		 * Handles the packet to update the inventory for the tile entity.
		 */
		@Override
		public IMessage onMessage(final PacketUpdatePedestal message, MessageContext ctx) {
			Minecraft.getMinecraft().addScheduledTask(() -> {
				TileEntityPedestal te = (TileEntityPedestal)Minecraft.getMinecraft().theWorld.getTileEntity(message.pos);
				te.inventory.setStackInSlot(0, message.stack);
				te.lastChangeTime = message.lastChangeTime;
			});
			return null;
		}
	
	}
}

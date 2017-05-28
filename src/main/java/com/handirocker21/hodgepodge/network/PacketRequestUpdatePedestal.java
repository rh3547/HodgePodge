package com.handirocker21.hodgepodge.network;

import com.handirocker21.hodgepodge.tileentity.TileEntityPedestal;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketRequestUpdatePedestal implements IMessage {

	private BlockPos pos;
	private int dimension;
	
	/**
	 * Constructor that initializes the tile entity's block position and dimension.
	 * @param pos
	 * @param dimension
	 */
	public PacketRequestUpdatePedestal(BlockPos pos, int dimension) {
		this.pos = pos;
		this.dimension = dimension;
	}
	
	/**
	 * Gets the tile entity's dimension and position for tile entity.
	 * @param te
	 */
	public PacketRequestUpdatePedestal(TileEntityPedestal te) {
		this(te.getPos(), te.getWorld().provider.getDimension());
	}
	
	/**
	 * Empty constructor.
	 */
	public PacketRequestUpdatePedestal() {}
	
	/**
	 * Deconstructs the position and dimension into the supplied byte buffer.
	 */
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeLong(pos.toLong());
		buf.writeInt(dimension);
	}
	
	/**
	 * Convert the position and dimension from different types.
	 */
	@Override
	public void fromBytes(ByteBuf buf) {
		pos = BlockPos.fromLong(buf.readLong());
		dimension = buf.readInt();
	}
	
	public static class Handler implements IMessageHandler<PacketRequestUpdatePedestal, PacketUpdatePedestal> {
		
		/**
		 * Called when a message is received of the appropriate type. 
		 * You can optionally return a reply message, or null if no reply is needed.
		 * Sends packet to the server to update the tile entity.
		 */
		@Override
		public PacketUpdatePedestal onMessage(PacketRequestUpdatePedestal message, MessageContext ctx) {
			World world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(message.dimension);
			TileEntityPedestal te = (TileEntityPedestal)world.getTileEntity(message.pos);
			if (te != null) {
				return new PacketUpdatePedestal(te);
			} else {
				return null;
			}
		}
	
	}

}
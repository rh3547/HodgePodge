package com.handirocker21.hodgepodge.events;

import java.util.Random;

import com.handirocker21.hodgepodge.utils.Utils;

import init.ModItems;
import init.ModTools;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SoulStealerEvent {

	@SubscribeEvent
	public void onEvent(LivingHurtEvent event) {
		if (Utils.randChance(50)) {
			if (event.getSource().getEntity() instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)event.getSource().getEntity();
				
				if (player.getHeldItemMainhand().getItem() == ModTools.soulStealer) {
					BlockPos pos = event.getEntity().getPosition();
					EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.soul));
					player.getEntityWorld().spawnEntity(item);
				}
			}
		}
	}
}

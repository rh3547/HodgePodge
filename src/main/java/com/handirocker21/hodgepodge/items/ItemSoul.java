package com.handirocker21.hodgepodge.items;

import java.util.List;

import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.utils.Utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemSoul extends Item {
	
	public ItemSoul() {
		setUnlocalizedName(Reference.HodgePodgeItems.SOUL.getUnlocalizedName());
		setRegistryName(Reference.HodgePodgeItems.SOUL.getRegistryName());
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World world, EntityPlayer player, EnumHand hand) {
		
		if (player.getHealth() < player.getMaxHealth()) {
			player.heal(2F);
			player.getHeldItem(hand).stackSize--;
		}
		
		return super.onItemRightClick(itemStackIn, world, player, hand);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		
		tooltip.add(TextFormatting.LIGHT_PURPLE + Utils.getLang().localize("soul.tooltip"));
	}
}

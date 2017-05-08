package com.handirocker21.hodgepodge.items;

import java.util.List;

import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.utils.Utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

public class ItemSoulCistern extends Item {
	
	public ItemSoulCistern() {
		setUnlocalizedName(Reference.HodgePodgeItems.SOUL_CISTERN.getUnlocalizedName());
		setRegistryName(Reference.HodgePodgeItems.SOUL_CISTERN.getRegistryName());
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		
		tooltip.add(TextFormatting.DARK_PURPLE + Utils.getLang().localize("soulcistern.tooltip"));
	}
}

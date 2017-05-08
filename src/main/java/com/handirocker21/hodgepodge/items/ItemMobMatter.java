package com.handirocker21.hodgepodge.items;

import java.util.List;

import com.handirocker21.hodgepodge.HodgePodge;
import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.utils.Utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

public class ItemMobMatter extends Item {
	
	public ItemMobMatter() {
		setUnlocalizedName(Reference.HodgePodgeItems.MOB_MATTER.getUnlocalizedName());
		setRegistryName(Reference.HodgePodgeItems.MOB_MATTER.getRegistryName());
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		
		tooltip.add(TextFormatting.DARK_GREEN + Utils.getLang().localize("mobmatter.tooltip"));
	}
}

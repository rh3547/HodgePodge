package com.handirocker21.hodgepodge.items;

import com.handirocker21.hodgepodge.HodgePodge;
import com.handirocker21.hodgepodge.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.world.World;

public class ItemRubyGummy extends ItemFood {

	public ItemRubyGummy() {
		super(6, 0.8F, false);
		
		setUnlocalizedName(Reference.HodgePodgeItems.RUBY_GUMMY.getUnlocalizedName());
		setRegistryName(Reference.HodgePodgeItems.RUBY_GUMMY.getRegistryName());
	}
	
	@Override
	public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player){
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(10), 100));
	}
}

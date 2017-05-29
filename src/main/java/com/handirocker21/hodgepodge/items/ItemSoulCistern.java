package com.handirocker21.hodgepodge.items;

import java.util.List;

import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.init.ModItems;
import com.handirocker21.hodgepodge.init.ModSounds;
import com.handirocker21.hodgepodge.init.ModTools;
import com.handirocker21.hodgepodge.utils.Utils;

import net.minecraft.client.audio.MovingSoundMinecart;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.audio.SoundRegistry;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemSoulCistern extends Item {
	private long lastTime;
	private boolean soundPlaying = false;
	public ItemSoulCistern() {
		setUnlocalizedName(Reference.HodgePodgeItems.SOUL_CISTERN.getUnlocalizedName());
		setRegistryName(Reference.HodgePodgeItems.SOUL_CISTERN.getRegistryName());
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);

		tooltip.add(TextFormatting.DARK_PURPLE + Utils.getLang().localize("soulcistern.tooltip"));
	}
		
	@Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
    	
		// Loop the whisper sound while held
    	if(entityIn != null && entityIn instanceof EntityPlayer){
       		EntityPlayer p = (EntityPlayer)entityIn;
       		
			if (p != null && p.getHeldItemMainhand() != null && p.getHeldItemMainhand().getItem() == this) {
	    		if (!soundPlaying) {
	        		lastTime = worldIn.getWorldTime();
	        		soundPlaying = true;
	        		
	        		p.playSound(ModSounds.cisternWhispers, 0.2F, 1.0F);
	    		}
	    		else {
	    	  		long time = worldIn.getWorldTime();
	    	  		if (time - lastTime >= (20 * 14)) {
	    	  			soundPlaying = false;
	    	  		}
	    		}
    		}
    	}
    }
}

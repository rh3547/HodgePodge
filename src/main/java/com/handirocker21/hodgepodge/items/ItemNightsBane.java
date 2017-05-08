package com.handirocker21.hodgepodge.items;

import java.util.List;

import com.handirocker21.hodgepodge.utils.Utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemNightsBane extends ItemSword {
	
	private final int SUPER_HITS_MAX = 5;
	private final int SUPER_HITS_COOLDOWN = 30;
	
	private boolean doUpgrade = false;
	private int superHits = 0;
	private long lastTime = 0;
	private boolean timeCaptured = false;
	private long delta = 0;
	
	public ItemNightsBane(ToolMaterial material, String unlocalizedName, String registryName) {
		super(material);
		
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
		
		this.superHits = SUPER_HITS_MAX;
	}
	
	/*
	 * On update, check that the world time is after 13000 (night time).
	 * If so, put the sword into upgrade mode.
	 */
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		/*
		 * If it is night time (greater than 13000),
		 * put the sword into "upgraded" mode.
		 */
		long time = worldIn.getWorldTime();
		
		if (time >= 13000) {
			if (!this.doUpgrade) {
				this.doUpgrade = true;
				this.superHits = SUPER_HITS_MAX;
			}
			
			// If all super hits have been used, start cooldown
			if (this.superHits == 0) {
				if (!this.timeCaptured) {
					this.timeCaptured = true;
					this.lastTime = time;
					this.delta = time;
				}
				
				// Show cooldown message every second
				if (this.delta != 0 && (time - this.delta >= (20))) {
					this.delta = time;
					if (entityIn instanceof EntityPlayer) {
						EntityPlayer player = (EntityPlayer)entityIn;
						if (player.getHeldItemMainhand().getItem() == this) {
							long cool = ((20 * SUPER_HITS_COOLDOWN) - (time - this.lastTime)) / 20;
							
							if (cool == 0)
								player.sendMessage(new TextComponentString("Super Hits Ready!"));
							else
								player.sendMessage(new TextComponentString("Super Hits Cooldown: " + cool + "s"));
						}
					}
				}
				
				// Reset super hits after cooldown
				if ((time - this.lastTime) >= (20 * SUPER_HITS_COOLDOWN)) {
					this.superHits = SUPER_HITS_MAX;
					this.lastTime = 0;
					this.timeCaptured = false;
				}
			}
			
			// Add night vision
			if (entityIn instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)entityIn;
				
				if (player.getHeldItemMainhand().getItem() == this) {
					player.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 20));
				}
			}
		}
		else {
			this.doUpgrade = false;
		}
		
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	/*
	 * When an entity is hit with this sword, override default logic
	 * and cause damage ourselves. This is because we want to cause
	 * more damage when the sword is in upgrade mode.
	 */
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		
		// If upgrade mode is on, perform hits differently
		if (this.doUpgrade) {
			
			float damageMult = 5F;
			
			if (this.superHits > 0) {
				damageMult = 7F;
				this.superHits--;
				
				// Super hits remaining message
				if (this.superHits == 0)
					((EntityPlayer) attacker).sendMessage(new TextComponentString("Super Hits Expended, 30s cooldown"));
				else
					((EntityPlayer) attacker).sendMessage(new TextComponentString("Super Hits Remaining: " + this.superHits));
			}
			
			if (attacker instanceof EntityPlayer) {
				target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), damageMult * this.getDamageVsEntity());
			}
			else {
				target.attackEntityFrom(DamageSource.causeMobDamage(attacker), damageMult * this.getDamageVsEntity());
			}
			
			return true; // Prevent any further propagation
		}
		
		return super.hitEntity(stack, target, attacker);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		
		tooltip.add(TextFormatting.DARK_RED + Utils.getLang().localize("rubidiansword.tooltip"));
	}
}

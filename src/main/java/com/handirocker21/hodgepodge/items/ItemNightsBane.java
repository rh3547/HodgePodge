package com.handirocker21.hodgepodge.items;

import java.util.List;
import java.util.Random;

import com.handirocker21.hodgepodge.init.ModSounds;
import com.handirocker21.hodgepodge.utils.Cooldown;
import com.handirocker21.hodgepodge.utils.Utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ItemNightsBane extends ItemSword {
	
	private static final int POWER_HITS_MAX = 4;
	private static final int POWER_HITS_COOLDOWN = 10;
	private static final int POWER_HIT_STACK_DAMAGE = 4;
	
	public ItemNightsBane(ToolMaterial material, String unlocalizedName, String registryName) {
		super(material);
		
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
	}
	
	/*
	 * On update, check that the world time is after 13000 (night time).
	 * If so, put the sword into upgrade mode.
	 */
	@Override
	public void onUpdate(ItemStack stackIn, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		// Set initial NBT data
		if (!stackIn.hasTagCompound()) {
			stackIn.setTagCompound(new NBTTagCompound());
			stackIn.getTagCompound().setBoolean("doUpgrade", false);
			stackIn.getTagCompound().setInteger("powerHits", POWER_HITS_MAX);
			stackIn.getTagCompound().setLong("startTime", 0);
			stackIn.getTagCompound().setBoolean("cooldownRunning", false);
		}
		
		if(entityIn instanceof EntityPlayer && stackIn.hasTagCompound()) {
			NBTTagCompound tag = stackIn.getTagCompound();
			EntityPlayer player = (EntityPlayer)entityIn;

			long time = worldIn.getWorldTime();
			
			/*
			 * If it is night time (between 13000 and 24000),
			 * put the sword into "upgraded" mode.
			 */
			if (time >= 13000 && time <= 23999) {
				if (!tag.getBoolean("doUpgrade")) {
					tag.setBoolean("doUpgrade", true);
					tag.setInteger("powerHits", POWER_HITS_MAX);
				}
				
				// If power hits left is less than max, start cooldown to gain one back
				if (tag.getInteger("powerHits") < POWER_HITS_MAX) {
					if (!tag.getBoolean("cooldownRunning")) {
						tag.setLong("startTime", time);
						tag.setBoolean("cooldownRunning", true);
					}
					
					if (Cooldown.checkCooldown(tag.getLong("startTime"), time, POWER_HITS_COOLDOWN)) {
						tag.setInteger("powerHits", tag.getInteger("powerHits") + 1);
						tag.setBoolean("cooldownRunning", false);
						
						// Play sound indicating a power hit was gained
						worldIn.playSound(null, player.getPosition(), ModSounds.nightsbanePh, SoundCategory.PLAYERS, 0.6F, 1.0F);
						
						// Show some particles
						try {
							if (worldIn instanceof WorldServer) {
								WorldServer sWorld = (WorldServer)worldIn;
							
								Random rand = player.getRNG();
								for (int i = 0; i < 2; ++i)
					            {
									double d3 = player.posX + rand.nextGaussian() / 4D;
						            double d4 = player.posY + 1.0D + rand.nextGaussian() / 4D;
						            double d5 = player.posZ + rand.nextGaussian() / 4D;
						            
						            for (int j = 0; j < 2; ++j)
					                {
										sWorld.spawnParticle(EnumParticleTypes.FLAME, 
												d3, d4, d5, 
												2, 0.0D, 0.0D, 0.0D, 0.2D, new int[0]);
										
										if ((j * i) % 2 == 0)
											sWorld.spawnParticle(EnumParticleTypes.CRIT_MAGIC, 
													d3, d4, d5, 
													1, 0.0D, 0.0D, 0.0D, 0.45D, new int[0]);
										else
											sWorld.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
													d3, d4, d5, 
													1, 0.0D, 0.0D, 0.0D, 0.6D, new int[0]);
					                }
					            }
							}
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
				// Add night vision and speed
				if (isSelected) {
					player.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 20));
					player.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 20));
				}
	
			}
			else {
				tag.setBoolean("doUpgrade", false);
			}
		}
	}
	
	/*
	 * When an entity is hit with this sword, override default logic
	 * and cause damage ourselves. This is because we want to cause
	 * more damage when the sword is in upgrade mode.
	 */
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		int stackDamage = 1;
		
		if (!stack.hasTagCompound())
			return true;
		
		NBTTagCompound tag = stack.getTagCompound();
			
		// If upgrade mode is on, perform hits differently
		if (tag.getBoolean("doUpgrade")) {
			
			float damageMult = 5F;
			boolean doPowerHit = false;
			
			if (tag.getInteger("powerHits") > 0) {
				damageMult = 7F;
				stackDamage = POWER_HIT_STACK_DAMAGE;
				doPowerHit = true;
				tag.setInteger("powerHits", tag.getInteger("powerHits") - 1);
			}
			
			if (attacker instanceof EntityPlayer) {
				target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), damageMult * this.getDamageVsEntity());
			}
			else {
				target.attackEntityFrom(DamageSource.causeMobDamage(attacker), damageMult * this.getDamageVsEntity());
			}
			
			// If this hit is a power hit, do some flashy effects!
			if (doPowerHit) {
				
				// Spawn particles if power hit
				Random rand = target.getRNG();
				WorldServer sWorld = (WorldServer)target.worldObj;
				for (int i = 0; i < 2; ++i)
	            {
					double d3 = target.posX + rand.nextGaussian() / 4D;
		            double d4 = target.posY + rand.nextGaussian() / 4D;
		            double d5 = target.posZ + rand.nextGaussian() / 4D;
		            
		            for (int j = 0; j < 16; ++j)
	                {
						sWorld.spawnParticle(EnumParticleTypes.DRAGON_BREATH, 
								d3, d4, d5, 
								3, 0.0D, 0.0D, 0.0D, 0.2D, new int[0]);
						
						if ((j * i) % 2 == 0)
							sWorld.spawnParticle(EnumParticleTypes.FLAME, 
									d3, d4, d5, 
									1, 0.0D, 0.0D, 0.0D, 0.45D, new int[0]);
						else
							sWorld.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, 
									d3, d4, d5, 
									3, 0.0D, 0.0D, 0.0D, 0.6D, new int[0]);
	                }
	            }
				
				// Play power hit sound effect
        		target.playSound(ModSounds.nightsbaneKill, 1.0F, 1.0F);
			}
			
			// Add slowness to the target hit
			target.addPotionEffect(new PotionEffect(Potion.getPotionById(2), (20 * 5)));
		}
		
		stack.damageItem(stackDamage, attacker);
		
		return true; // Prevent further propagation
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		
		tooltip.add(TextFormatting.DARK_RED + Utils.getLang().localize("rubidiansword.tooltip"));
	}
	
	/**
	 * Return a boolean defining if this is currently in upgrade mode.
	 * @return doUpgrade
	 */
	public boolean isUpgraded(ItemStack stack) {
		if (stack.hasTagCompound()) {
			stack.getTagCompound().getBoolean("doUpgrade");
		}
		
		return false;
	}
	
	/**
	 * Return the number of power hits remaining.
	 * @return powerHits
	 */
	public int getPowerHits(ItemStack stack) {
		if (stack.hasTagCompound()) {
			stack.getTagCompound().getInteger("powerHits");
		}
		
		return 0;
	}
}

package items;

import java.util.List;

import com.handirocker21.hodgepodge.utils.Utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemRubidianSword extends ItemSword {
	
	private final int SUPER_HITS_MAX = 5;
	private final int SUPER_HITS_COOLDOWN = 30;
	
	private boolean doUpgrade = false;
	private int superHits = 0;
	private long lastTime = 0;
	private boolean timeCaptured = false;
	
	public ItemRubidianSword(ToolMaterial material, String unlocalizedName, String registryName) {
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
			
			if (this.superHits == 0) {
				if (!this.timeCaptured) {
					this.timeCaptured = true;
					this.lastTime = time;
				}
				
				if ((time - this.lastTime) >= (20 * SUPER_HITS_COOLDOWN)) {
					this.superHits = SUPER_HITS_MAX;
					this.lastTime = 0;
					this.timeCaptured = false;
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
			}
			
			((EntityPlayer) attacker).sendMessage(new TextComponentString("Super Hits Remaining: " + this.superHits));
			
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

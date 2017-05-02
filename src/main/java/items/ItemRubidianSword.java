package items;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;

import com.handirocker21.hodgepodge.utils.Utils;

import init.ModTools;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class ItemRubidianSword extends ItemSword {
	
	private boolean doUpgrade = false;
	
	public ItemRubidianSword(ToolMaterial material, String unlocalizedName, String registryName) {
		super(material);
		
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		/*
		 * If it is night time (greater than 13000),
		 * put the sword into "upgraded" mode.
		 */
		long time = worldIn.getWorldTime();
		
		if (time >= 13000) {
			this.doUpgrade = true;
		}
		else {
			this.doUpgrade = false;
		}
		
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		
		if (this.doUpgrade) {
			if (attacker instanceof EntityPlayer) {
				target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 3F * this.getDamageVsEntity());
			}
			else {
				target.attackEntityFrom(DamageSource.causeMobDamage(attacker), 3F * this.getDamageVsEntity());
			}
		}
		
		return true;
	}
}

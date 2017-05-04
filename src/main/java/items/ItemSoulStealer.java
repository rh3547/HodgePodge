package items;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;
import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.utils.Utils;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.util.EnumHelper;

public class ItemSoulStealer extends ItemTool {
	
	private static final Set<Block> EFFECTIVE_BLOCKS = Sets.newHashSet(new Block[] {});

	public ItemSoulStealer() {
		super(EnumHelper.addToolMaterial(Reference.MOD_ID + ":soulstealer", 0, 20, 0, 1, 0), EFFECTIVE_BLOCKS);
		
		setUnlocalizedName(Reference.HodgePodgeItems.SOUL_STEALER.getUnlocalizedName());
		setRegistryName(Reference.HodgePodgeItems.SOUL_STEALER.getRegistryName());
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		
		tooltip.add(TextFormatting.DARK_PURPLE + Utils.getLang().localize("soulstealer.tooltip"));
	}
}

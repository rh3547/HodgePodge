package init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static void register() {
		/*
		 * Shaped recipes.
		 */
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.rubyBlock), 
				"RRR", 
				"RRR", 
				"RRR", 
				'R', ModItems.ruby); // Ruby block from 9 rubys
		
		/*
		 * Shapeless recipes.
		 */
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ruby, 9), ModBlocks.rubyBlock, ModBlocks.rubyBlock); // 9 rubys from ruby block
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ruby),  Items.EMERALD, Items.REDSTONE);				// Ruby from emerald and redstone
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.rubyGummy, 6), ModItems.ruby, Items.SLIME_BALL);		// Ruby gummys from ruby and slimeball
		
		/*
		 * Smelting recipes.
		 */
		GameRegistry.addSmelting(Blocks.OBSIDIAN, new ItemStack(ModItems.obsidianIngot, 1), 0.5F); // Obsidian ingot from obsidian
	}
}
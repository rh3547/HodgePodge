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
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.obsidianPickaxe), 
				"OOO", 
				" S ", 
				" S ", 
				'O', ModItems.obsidianIngot,
				'S', Items.STICK); // Obsidian pickaxe
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.obsidianAxe), 
				"OO ", 
				"OS ", 
				" S ", 
				'O', ModItems.obsidianIngot,
				'S', Items.STICK); // Obsidian axe 1
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.obsidianAxe), 
				" OO", 
				" SO", 
				" S ", 
				'O', ModItems.obsidianIngot,
				'S', Items.STICK); // Obsidian axe 2
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.obsidianHoe), 
				"OO ", 
				" S ", 
				" S ", 
				'O', ModItems.obsidianIngot,
				'S', Items.STICK); // Obsidian hoe 1
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.obsidianHoe), 
				" OO", 
				" S ", 
				" S ", 
				'O', ModItems.obsidianIngot,
				'S', Items.STICK); // Obsidian hoe 2
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.obsidianSpade), 
				" O ", 
				" S ", 
				" S ", 
				'O', ModItems.obsidianIngot,
				'S', Items.STICK); // Obsidian spade
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.obsidianSword), 
				" O ", 
				" O ", 
				" S ", 
				'O', ModItems.obsidianIngot,
				'S', Items.STICK); // Obsidian sword
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.rubidian), 
				"ORO", 
				"ROR", 
				"ORO", 
				'O', ModItems.obsidianIngot,
				'R', ModBlocks.rubyBlock); // Rubidian
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.rubidianSword), 
				" R ", 
				"IRI", 
				" I ", 
				'I', Blocks.IRON_BARS,
				'R', ModItems.rubidian); // Rubidian sword
		
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

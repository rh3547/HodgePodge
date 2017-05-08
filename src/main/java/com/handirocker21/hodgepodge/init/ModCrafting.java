package com.handirocker21.hodgepodge.init;

import net.minecraft.block.BlockCompressedPowered;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {
	
	/**
	 * CRAFTING
	 * ============================================
	 * Register the mod's crafting recipes.
	 */
	public static void registerCraftingRecipes() {
		/*
		 * Shaped recipes.
		 */
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.poweredGemBlock), 
				"GGG", 
				"GGG", 
				"GGG", 
				'G', ModItems.poweredGem); // Powered gem block from 9 powered gems
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.poweredGem), 
				" R ", 
				"RER", 
				" R ", 
				'E', Items.EMERALD,
				'R', Items.REDSTONE); // Powered gem from emerald and 4 redstone
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.soulStealer), 
				" O ", 
				" M ", 
				" S ", 
				'S', Items.STICK,
				'M', ModItems.mobMatter,
				'O', ModItems.obsidianIngot); // Soul Stealer
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.soulCistern), 
				"SSS",
				"SOS",
				"SSS",
				'S', ModItems.soul,
				'O', ModItems.obsidianIngot); // Soul Cistern
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.soulCore), 
				"GOG", 
				"OSO", 
				"GOG", 
				'O', ModItems.obsidianIngot,
				'G', ModBlocks.poweredGemBlock,
				'S', ModItems.soulCistern); // Soul core
		
		/*
		 * Shapeless recipes.
		 */
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.poweredGem, 9), ModBlocks.poweredGemBlock, ModBlocks.poweredGemBlock); 	// 9 powered gems from powered gem block
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gemmy, 6), ModItems.poweredGem, Items.SLIME_BALL);						// Gemmys from powered gem and slimeball
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.mobMatter, 1), Items.ROTTEN_FLESH, Items.SPIDER_EYE, Items.BONE,
				Items.ENDER_PEARL, Items.GHAST_TEAR, Items.GUNPOWDER, Items.BLAZE_ROD, Items.SLIME_BALL, Items.LEATHER);				// Mob matter from mob drops				
	}
	
	/**
	 * FURNACE
	 * ============================================
	 * Register the mod's furnace smelting recipes.
	 */
	public static void registerFurnaceRecipes() {
		GameRegistry.addSmelting(Blocks.OBSIDIAN, new ItemStack(ModItems.obsidianIngot, 1), 0.5F); // Obsidian ingot from obsidian
	}
	
	/**
	 * TOOLS
	 * ============================================
	 * Register the mod's tool recipes.
	 */
	public static void registerToolRecipes() {
		/*
		 * Generic tools.
		 */
		registerPickaxeRecipes(ModItems.obsidianIngot, Items.STICK, ModTools.obsidianPickaxe);
		registerAxeRecipes(ModItems.obsidianIngot, Items.STICK, ModTools.obsidianAxe);
		registerSpadeRecipes(ModItems.obsidianIngot, Items.STICK, ModTools.obsidianSpade);
		registerHoeRecipes(ModItems.obsidianIngot, Items.STICK, ModTools.obsidianHoe);
		registerSwordRecipes(ModItems.obsidianIngot, Items.STICK, ModTools.obsidianSword);
		
		/*
		 * Unique tools.
		 */
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.nightsBane), 
				" S ", 
				"ISI", 
				" I ", 
				'I', Blocks.IRON_BARS,
				'S', ModItems.soulCore); // Night's bane
	}
	
	/**
	 * Register possible recipes for a generic pickaxe.
	 */
	private static void registerPickaxeRecipes(Item ingot, Item stick, Item pickaxe) {
		GameRegistry.addShapedRecipe(new ItemStack(pickaxe), "III", " S ", " S ", 'I', ingot, 'S', stick);
	}
	
	/**
	 * Register possible recipes for a generic axe.
	 */
	private static void registerAxeRecipes(Item ingot, Item stick, Item axe) {
		GameRegistry.addShapedRecipe(new ItemStack(axe), "II ", "IS ", " S ", 'I', ingot, 'S', stick);
		GameRegistry.addShapedRecipe(new ItemStack(axe), " II", " SI", " S ", 'I', ingot, 'S', stick);
		GameRegistry.addShapedRecipe(new ItemStack(axe), "II ", "SI ", "S  ", 'I', ingot, 'S', stick);
		GameRegistry.addShapedRecipe(new ItemStack(axe), " II", " IS", "  S", 'I', ingot, 'S', stick);
	}
	
	/**
	 * Register possible recipes for a generic spade.
	 */
	private static void registerSpadeRecipes(Item ingot, Item stick, Item spade) {
		GameRegistry.addShapedRecipe(new ItemStack(spade), " I ", " S ", " S ", 'I', ingot, 'S', stick);
		GameRegistry.addShapedRecipe(new ItemStack(spade), "I  ", "S  ", "S  ", 'I', ingot, 'S', stick);
		GameRegistry.addShapedRecipe(new ItemStack(spade), "  I", "  S", "  S", 'I', ingot, 'S', stick);
	}
	
	/**
	 * Register possible recipes for a generic hoe.
	 */
	private static void registerHoeRecipes(Item ingot, Item stick, Item hoe) {
		GameRegistry.addShapedRecipe(new ItemStack(hoe), "II ", " S ", " S ", 'I', ingot, 'S', stick);
		GameRegistry.addShapedRecipe(new ItemStack(hoe), " II", " S ", " S ", 'I', ingot, 'S', stick);
		GameRegistry.addShapedRecipe(new ItemStack(hoe), "II ", "S  ", "S  ", 'I', ingot, 'S', stick);
		GameRegistry.addShapedRecipe(new ItemStack(hoe), " II", "  S", "  S", 'I', ingot, 'S', stick);
	}
	
	/**
	 * Register possible recipes for a generic sword.
	 */
	private static void registerSwordRecipes(Item ingot, Item stick, Item sword) {
		GameRegistry.addShapedRecipe(new ItemStack(sword), " I ", " I ", " S ", 'I', ingot, 'S', stick);
		GameRegistry.addShapedRecipe(new ItemStack(sword), "I  ", "I  ", "S  ", 'I', ingot, 'S', stick);
		GameRegistry.addShapedRecipe(new ItemStack(sword), "  I", "  I", "  S", 'I', ingot, 'S', stick);
	}
}

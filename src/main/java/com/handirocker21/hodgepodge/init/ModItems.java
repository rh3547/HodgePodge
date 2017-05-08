package com.handirocker21.hodgepodge.init;

import com.handirocker21.hodgepodge.HodgePodge;
import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.items.ItemGemmy;
import com.handirocker21.hodgepodge.items.ItemMobMatter;
import com.handirocker21.hodgepodge.items.ItemObsidianIngot;
import com.handirocker21.hodgepodge.items.ItemPoweredGem;
import com.handirocker21.hodgepodge.items.ItemSoul;
import com.handirocker21.hodgepodge.items.ItemSoulCistern;
import com.handirocker21.hodgepodge.items.ItemSoulCore;
import com.handirocker21.hodgepodge.utils.Utils;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	/*
	 * Items
	 */
	public static Item obsidianIngot;
	public static Item poweredGem;
	public static Item gemmy;
	public static Item soulCore;
	public static Item soul;
	public static Item soulCistern;
	public static Item mobMatter;
	
	/**
	 * Initialize items.
	 */
	public static void init() {
		obsidianIngot = new ItemObsidianIngot();
		poweredGem = new ItemPoweredGem();
		gemmy = new ItemGemmy();
		soulCore = new ItemSoulCore();
		soul = new ItemSoul();
		soulCistern = new ItemSoulCistern();
		mobMatter = new ItemMobMatter();
	}
	
	/**
	 * Register all items.
	 */
	public static void register() {
		registerItem(obsidianIngot);
		registerItem(poweredGem);
		registerItem(gemmy);
		registerItem(soulCore);
		registerItem(soul);
		registerItem(soulCistern);
		registerItem(mobMatter);
	}
	
	/**
	 * Register all item renders.
	 */
	public static void registerRenders() {
		registerRender(obsidianIngot);
		registerRender(poweredGem);
		registerRender(gemmy);
		registerRender(soulCore);
		registerRender(soul);
		registerRender(soulCistern);
		registerRender(mobMatter);
	}
	
	/**
	 * Register the given item.
	 * @param item
	 */
	private static void registerItem(Item item) {
		GameRegistry.register(item);
		item.setCreativeTab(HodgePodge.tabHodgePodge);
		Utils.getLogger().info("Registered item " + item.getUnlocalizedName().substring(5));
	}
	
	/**
	 * Register the given item's model render.
	 * @param item
	 */
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(
				new ResourceLocation(Reference.MOD_ID, item.getUnlocalizedName().substring(5)), "inventory"));
		
		Utils.getLogger().info("Register render for " + item.getUnlocalizedName().substring(5));
	}
}

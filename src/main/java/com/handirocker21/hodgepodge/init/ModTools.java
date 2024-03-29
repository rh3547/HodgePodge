package com.handirocker21.hodgepodge.init;

import com.handirocker21.hodgepodge.HodgePodge;
import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.items.ItemModAxe;
import com.handirocker21.hodgepodge.items.ItemModHoe;
import com.handirocker21.hodgepodge.items.ItemModPickaxe;
import com.handirocker21.hodgepodge.items.ItemModSpade;
import com.handirocker21.hodgepodge.items.ItemModSword;
import com.handirocker21.hodgepodge.items.ItemNightsBane;
import com.handirocker21.hodgepodge.items.ItemSoulStealer;
import com.handirocker21.hodgepodge.meshes.NightsBaneMeshDefinition;
import com.handirocker21.hodgepodge.utils.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModTools {
	
	public static final ToolMaterial obsidianMaterial = EnumHelper.addToolMaterial(
			Reference.MOD_ID + ":obsidian", 4, 1500, 3.0F, 2.0F, 12); // Obsidian ingot material
	public static final ToolMaterial soulCoreMaterial = EnumHelper.addToolMaterial(
			Reference.MOD_ID + ":soulcore", 4, 1500, 6.0F, 3.0F, 15); // Rubidian material
	
	public static ItemPickaxe obsidianPickaxe;
	public static ItemModAxe obsidianAxe;
	public static ItemHoe obsidianHoe;
	public static ItemSpade obsidianSpade;
	public static ItemSword obsidianSword;
	public static ItemNightsBane nightsBane;
	public static ItemSoulStealer soulStealer;
	
	/**
	 * Initialize tools.
	 * Called in preInit.
	 */
	public static void init() {
		obsidianPickaxe = new ItemModPickaxe(obsidianMaterial, Reference.HodgePodgeTools.OBSIDIAN_PICKAXE.getUnlocalizedName(), Reference.HodgePodgeTools.OBSIDIAN_PICKAXE.getRegistryName());
		obsidianAxe = new ItemModAxe(obsidianMaterial, Reference.HodgePodgeTools.OBSIDIAN_AXE.getUnlocalizedName(), Reference.HodgePodgeTools.OBSIDIAN_AXE.getRegistryName());
		obsidianHoe = new ItemModHoe(obsidianMaterial, Reference.HodgePodgeTools.OBSIDIAN_HOE.getUnlocalizedName(), Reference.HodgePodgeTools.OBSIDIAN_HOE.getRegistryName());
		obsidianSpade = new ItemModSpade(obsidianMaterial, Reference.HodgePodgeTools.OBSIDIAN_SPADE.getUnlocalizedName(), Reference.HodgePodgeTools.OBSIDIAN_SPADE.getRegistryName());
		obsidianSword = new ItemModSword(obsidianMaterial, Reference.HodgePodgeTools.OBSIDIAN_SWORD.getUnlocalizedName(), Reference.HodgePodgeTools.OBSIDIAN_SWORD.getRegistryName());
		nightsBane = new ItemNightsBane(soulCoreMaterial, Reference.HodgePodgeTools.NIGHTS_BANE.getUnlocalizedName(), Reference.HodgePodgeTools.NIGHTS_BANE.getRegistryName());
		soulStealer = new ItemSoulStealer();
	}
	
	/**
	 * Register all tools.
	 * Called in preInit.
	 */
	public static void register() {
		registerItem(obsidianPickaxe);
		registerItem(obsidianAxe);
		registerItem(obsidianHoe);
		registerItem(obsidianSpade);
		registerItem(obsidianSword);
		registerItem(nightsBane);
		registerItem(soulStealer);
	}
	
	/**
	 * Register all tool renders.
	 * Called in init.
	 */
	public static void registerRenders() {
		registerRender(obsidianPickaxe);
		registerRender(obsidianAxe);
		registerRender(obsidianHoe);
		registerRender(obsidianSpade);
		registerRender(obsidianSword);
		registerRender(soulStealer);
	}
	
	/**
	 * Register all more advanced models.
	 * Called in preInit.
	 */
	public static void registerCustomModels() {
		ModelLoader.setCustomMeshDefinition(nightsBane, new NightsBaneMeshDefinition());
	}
	
	/**
	 * Register the given tool's custom model.
	 */
	public static void registerCustomModel(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, 
		        new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	/**
	 * Register all the tools' different model variants.
	 * Called in init.
	 */
	public static void registerModelVariants() {
		ModelBakery.registerItemVariants(nightsBane, 
		        new ModelResourceLocation(nightsBane.getRegistryName(), "inventory"),
		        new ModelResourceLocation(nightsBane.getRegistryName() + "_night", "inventory"),
		        new ModelResourceLocation(nightsBane.getRegistryName() + "_ph4", "inventory"),
		        new ModelResourceLocation(nightsBane.getRegistryName() + "_ph3", "inventory"),
		        new ModelResourceLocation(nightsBane.getRegistryName() + "_ph2", "inventory"),
		        new ModelResourceLocation(nightsBane.getRegistryName() + "_ph1", "inventory")
		);
	}
	
	/**
	 * Register the given tool.
	 * @param item
	 */
	private static void registerItem(Item item) {
		GameRegistry.register(item);
		item.setCreativeTab(HodgePodge.tabHodgePodge);
		Utils.getLogger().info("Registered item " + item.getUnlocalizedName().substring(5));
	}
	
	/**
	 * Register the given tool's model render.
	 * @param item
	 */
	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));

		Utils.getLogger().info("Register render for " + item.getUnlocalizedName().substring(5));
	}
}	

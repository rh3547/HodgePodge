package init;

import com.handirocker21.hodgepodge.HodgePodge;
import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.utils.Utils;

import items.ItemModAxe;
import items.ItemModHoe;
import items.ItemModPickaxe;
import items.ItemModSpade;
import items.ItemModSword;
import items.ItemRubidianSword;
import items.ItemSoulStealer;
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

public class ModTools {
	
	public static final ToolMaterial obsidianMaterial = EnumHelper.addToolMaterial(
			Reference.MOD_ID + ":obsidian", 4, 1500, 3.0F, 2.0F, 12); // Obsidian ingot material
	public static final ToolMaterial rubidianMaterial = EnumHelper.addToolMaterial(
			Reference.MOD_ID + ":rubidian", 4, 2000, 6.0F, 3.0F, 15); // Rubidian material
	
	public static ItemPickaxe obsidianPickaxe;
	public static ItemModAxe obsidianAxe;
	public static ItemHoe obsidianHoe;
	public static ItemSpade obsidianSpade;
	public static ItemSword obsidianSword;
	public static ItemSword rubidianSword;
	public static ItemSoulStealer soulStealer;
	
	/**
	 * Initialize tools.
	 */
	public static void init() {
		obsidianPickaxe = new ItemModPickaxe(obsidianMaterial, Reference.HodgePodgeTools.OBSIDIAN_PICKAXE.getUnlocalizedName(), Reference.HodgePodgeTools.OBSIDIAN_PICKAXE.getRegistryName());
		obsidianAxe = new ItemModAxe(obsidianMaterial, Reference.HodgePodgeTools.OBSIDIAN_AXE.getUnlocalizedName(), Reference.HodgePodgeTools.OBSIDIAN_AXE.getRegistryName());
		obsidianHoe = new ItemModHoe(obsidianMaterial, Reference.HodgePodgeTools.OBSIDIAN_HOE.getUnlocalizedName(), Reference.HodgePodgeTools.OBSIDIAN_HOE.getRegistryName());
		obsidianSpade = new ItemModSpade(obsidianMaterial, Reference.HodgePodgeTools.OBSIDIAN_SPADE.getUnlocalizedName(), Reference.HodgePodgeTools.OBSIDIAN_SPADE.getRegistryName());
		obsidianSword = new ItemModSword(obsidianMaterial, Reference.HodgePodgeTools.OBSIDIAN_SWORD.getUnlocalizedName(), Reference.HodgePodgeTools.OBSIDIAN_SWORD.getRegistryName());
		rubidianSword = new ItemRubidianSword(rubidianMaterial, Reference.HodgePodgeTools.RUBIDIAN_SWORD.getUnlocalizedName(), Reference.HodgePodgeTools.RUBIDIAN_SWORD.getRegistryName());
		soulStealer = new ItemSoulStealer();
	}
	
	/**
	 * Register all tools.
	 */
	public static void register() {
		registerItem(obsidianPickaxe);
		registerItem(obsidianAxe);
		registerItem(obsidianHoe);
		registerItem(obsidianSpade);
		registerItem(obsidianSword);
		registerItem(rubidianSword);
		registerItem(soulStealer);
	}
	
	/**
	 * Register all tool renders.
	 */
	public static void registerRenders() {
		registerRender(obsidianPickaxe);
		registerRender(obsidianAxe);
		registerRender(obsidianHoe);
		registerRender(obsidianSpade);
		registerRender(obsidianSword);
		registerRender(rubidianSword);
		registerRender(soulStealer);
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
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(
				new ResourceLocation(Reference.MOD_ID, item.getUnlocalizedName().substring(5)), "inventory"));
		
		Utils.getLogger().info("Register render for " + item.getUnlocalizedName().substring(5));
	}
}	

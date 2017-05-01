package init;

import com.handirocker21.hodgepodge.HodgePodge;
import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.utils.Utils;

import items.ItemObsidianIngot;
import items.ItemRuby;
import items.ItemRubyGummy;
import net.minecraft.client.Minecraft;
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
	public static Item ruby;
	public static Item rubyGummy;
	
	/**
	 * Initialize items.
	 */
	public static void init() {
		obsidianIngot = new ItemObsidianIngot();
		ruby = new ItemRuby();
		rubyGummy = new ItemRubyGummy();
	}
	
	/**
	 * Register all items.
	 */
	public static void register() {
		registerItem(obsidianIngot);
		registerItem(ruby);
		registerItem(rubyGummy);
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
	 * Register all item renders.
	 */
	public static void registerRenders() {
		registerRender(obsidianIngot);
		registerRender(ruby);
		registerRender(rubyGummy);
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

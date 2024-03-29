package com.handirocker21.hodgepodge.init;

import com.handirocker21.hodgepodge.HodgePodge;
import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.mobs.entities.EntityHodgePodge;
import com.handirocker21.hodgepodge.mobs.models.ModelHodgePodge;
import com.handirocker21.hodgepodge.mobs.renderers.RenderHodgePodge;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {
	
	/**
	 * Calls the registerEntity() method.
	 */
	public static void register() {
		ModEntities.registerEntity();
	}
	
	/**
	 * Registers renders for entities.
	 */
	public static void registerRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityHodgePodge.class, new RenderHodgePodge(Minecraft.getMinecraft().getRenderManager(), new ModelHodgePodge(), 0.5F));
	}
	
	/**
	 * Registers an entity.
	 */
	public static void registerEntity() {
		EntityRegistry.registerModEntity(EntityHodgePodge.class, "hodgepodge", 300, HodgePodge.instance, 64, 1, true, 0x57046B, 0xBA49D6);
		EntityRegistry.addSpawn(EntityHodgePodge.class, 10, 1, 6, EnumCreatureType.CREATURE, Biomes.PLAINS);
	}
}
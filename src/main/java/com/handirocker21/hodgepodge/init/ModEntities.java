package com.handirocker21.hodgepodge.init;

import com.handirocker21.hodgepodge.HodgePodge;
import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.mobs.entities.EntityHodgePodge;
import com.handirocker21.hodgepodge.mobs.models.ModelHodgePodge;
import com.handirocker21.hodgepodge.mobs.renderers.RenderHodgePodge;
import com.handirocker21.hodgepodge.mobs.renderers.RenderHodgePodgeFactory;
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

	public static void register() {
		ModEntities.registerEntity();
	}
	
	public static void registerRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityHodgePodge.class, RenderHodgePodgeFactory.INSTANCE);
	}
	
	public static void registerEntity() {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "textures/entities/hodgepodge.png"),  EntityHodgePodge.class, "hodgepodge", 300, HodgePodge.instance, 64, 1, false, 0x57046B, 0xBA49D6);
		EntityRegistry.addSpawn(EntityHodgePodge.class, 10, 1, 6, EnumCreatureType.CREATURE, Biomes.PLAINS);
	}
}
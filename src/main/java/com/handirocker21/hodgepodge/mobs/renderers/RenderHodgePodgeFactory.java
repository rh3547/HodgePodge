package com.handirocker21.hodgepodge.mobs.renderers;

import com.handirocker21.hodgepodge.mobs.entities.EntityHodgePodge;
import com.handirocker21.hodgepodge.mobs.models.ModelHodgePodge;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHodgePodgeFactory implements IRenderFactory<EntityHodgePodge> {

	public static final RenderHodgePodgeFactory INSTANCE = new RenderHodgePodgeFactory();

	@Override
	public Render<? super EntityHodgePodge> createRenderFor(RenderManager manager) {
		return new RenderHodgePodge(manager, new ModelHodgePodge(), 0.5f);
	}
}
package com.handirocker21.hodgepodge.mobs.renderers;

import com.handirocker21.hodgepodge.Reference;
import com.handirocker21.hodgepodge.mobs.entities.EntityHodgePodge;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderHodgePodge extends RenderLiving<EntityHodgePodge> {
	
	private static final ResourceLocation HODGEPODGE_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entities/hodgepodge.png");
	protected ResourceLocation hodgepodgeTexture;
	
	/**
	 * Constructor that initializes the renderer for the entity.
	 * @param rendermanagerIn
	 * @param modelbaseIn
	 * @param shadowsizeIn
	 */
	public RenderHodgePodge(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
		super(rendermanagerIn, modelbaseIn, shadowsizeIn);
	}

	/**
	 * Gets the entity's texture location.
	 */
	@Override
	protected ResourceLocation getEntityTexture(EntityHodgePodge entity) {
		return HODGEPODGE_TEXTURE;
	}
}
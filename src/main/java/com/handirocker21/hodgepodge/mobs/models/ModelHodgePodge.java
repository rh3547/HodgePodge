package com.handirocker21.hodgepodge.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

/**
 * HodgePodge model class
 */
@SideOnly(Side.CLIENT)
public class ModelHodgePodge extends ModelBase {
    public ModelRenderer villagerArms;
    public ModelRenderer villagerArms_1;
    public ModelRenderer villagerArms_2;
    public ModelRenderer rightVillagerLeg;
    public ModelRenderer villagerBody;
    public ModelRenderer villagerBody_1;
    public ModelRenderer villagerHead;
    public ModelRenderer leftVillagerLeg;
    public ModelRenderer Hood;

    public ModelHodgePodge() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.villagerArms = new ModelRenderer(this, 44, 22);
        this.villagerArms.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.villagerArms.addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4);
        this.setRotationAngles(this.villagerArms, -0.7500000253993603F, 0.0F, 0.0F);
        this.villagerArms_1 = new ModelRenderer(this, 44, 22);
        this.villagerArms_1.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.villagerArms_1.addBox(4.0F, -2.0F, -2.0F, 4, 8, 4);
        this.setRotationAngles(this.villagerArms_1, -0.7500000253993603F, 0.0F, 0.0F);
        this.villagerArms_2 = new ModelRenderer(this, 40, 38);
        this.villagerArms_2.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.villagerArms_2.addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4);
        this.setRotationAngles(this.villagerArms_2, -0.7500000253993603F, 0.0F, 0.0F);
        this.rightVillagerLeg = new ModelRenderer(this, 0, 22);
        this.rightVillagerLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.rightVillagerLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.villagerBody = new ModelRenderer(this, 16, 20);
        this.villagerBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.villagerBody.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 6);
        this.villagerBody_1 = new ModelRenderer(this, 0, 38);
        this.villagerBody_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.villagerBody_1.addBox(-4.0F, 0.0F, -3.0F, 8, 18, 6);
        this.villagerHead = new ModelRenderer(this, 0, 0);
        this.villagerHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.villagerHead.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8);
        this.leftVillagerLeg = new ModelRenderer(this, 0, 22);
        this.leftVillagerLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.leftVillagerLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.leftVillagerLeg.mirror = true;
        this.Hood = new ModelRenderer(this, 32, 0);
        this.Hood.setRotationPoint(-0.1F, -0.1F, 0.1F);
        this.Hood.addBox(-3.8F, -10.0F, -4.0F, 8, 10, 8);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float rotationYaw, float rotationPitch, float scale) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.villagerArms.offsetX, this.villagerArms.offsetY, this.villagerArms.offsetZ);
        GlStateManager.translate(this.villagerArms.rotationPointX * scale, this.villagerArms.rotationPointY * scale, this.villagerArms.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.villagerArms.offsetX, -this.villagerArms.offsetY, -this.villagerArms.offsetZ);
        GlStateManager.translate(-this.villagerArms.rotationPointX * scale, -this.villagerArms.rotationPointY * scale, -this.villagerArms.rotationPointZ * scale);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.villagerArms.render(scale);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix(); 
        GlStateManager.translate(this.villagerArms_1.offsetX, this.villagerArms_1.offsetY, this.villagerArms_1.offsetZ);
        GlStateManager.translate(this.villagerArms_1.rotationPointX * scale, this.villagerArms_1.rotationPointY * scale, this.villagerArms_1.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.villagerArms_1.offsetX, -this.villagerArms_1.offsetY, -this.villagerArms_1.offsetZ);
        GlStateManager.translate(-this.villagerArms_1.rotationPointX * scale, -this.villagerArms_1.rotationPointY * scale, -this.villagerArms_1.rotationPointZ * scale);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.villagerArms_1.render(scale);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.villagerArms_2.offsetX, this.villagerArms_2.offsetY, this.villagerArms_2.offsetZ);
        GlStateManager.translate(this.villagerArms_2.rotationPointX * scale, this.villagerArms_2.rotationPointY * scale, this.villagerArms_2.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.villagerArms_2.offsetX, -this.villagerArms_2.offsetY, -this.villagerArms_2.offsetZ);
        GlStateManager.translate(-this.villagerArms_2.rotationPointX * scale, -this.villagerArms_2.rotationPointY * scale, -this.villagerArms_2.rotationPointZ * scale);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.villagerArms_2.render(scale);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.rightVillagerLeg.render(scale);
        GlStateManager.disableBlend();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.villagerBody.render(scale);
        GlStateManager.disableBlend();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.villagerBody_1.render(scale);
        GlStateManager.disableBlend();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.villagerHead.render(scale);
        GlStateManager.disableBlend();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.leftVillagerLeg.render(scale);
        GlStateManager.disableBlend();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.scale(1.3F, 1.2F, 1.5F);
        this.Hood.render(scale);
        GlStateManager.disableBlend();
    }

    public void setRotationAngles(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		this.villagerHead.rotateAngleY = netHeadYaw * 0.017453292F;
		this.villagerHead.rotateAngleX = headPitch * 0.017453292F;
		
		this.Hood.rotateAngleY = this.villagerHead.rotateAngleY;
		this.Hood.rotateAngleX = this.villagerHead.rotateAngleX;
		
		this.villagerArms.rotationPointY = 3.0F;
		this.villagerArms.rotationPointZ = -1.0F;
		this.villagerArms.rotateAngleX = -0.75F;
		
		this.rightVillagerLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		this.leftVillagerLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		this.rightVillagerLeg.rotateAngleY = 0.0F;
		this.leftVillagerLeg.rotateAngleY = 0.0F;
	}
}

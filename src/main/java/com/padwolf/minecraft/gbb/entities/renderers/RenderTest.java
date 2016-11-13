package com.padwolf.minecraft.gbb.entities.renderers;

import com.padwolf.minecraft.gbb.GBB;
import com.padwolf.minecraft.gbb.entities.EntityTARDIS;
import com.padwolf.minecraft.gbb.entities.EntityTest;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderTest extends RenderLiving<EntityTest>{

	protected ResourceLocation texture = new ResourceLocation(GBB.MODID + ":textures/entities/tardis.png");
	
    public RenderTest(RenderManager renderManager, ModelBase par1ModelBase, float parShadowSize)
    {
        super(renderManager, par1ModelBase, parShadowSize);
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
	@Override
	protected ResourceLocation getEntityTexture(EntityTest entity) {
		// TODO Auto-generated method stub
		return texture;
	}
	
}

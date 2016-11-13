package com.padwolf.minecraft.gbb.entities.renderers;

import com.padwolf.minecraft.gbb.entities.EntityTARDIS;
import com.padwolf.minecraft.gbb.entities.models.ModelTARDIS;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTARDISFactory implements IRenderFactory<EntityTARDIS>{
	
	public static final RenderTARDISFactory INSTANCE = new RenderTARDISFactory();
	
	@Override
	public Render<? super EntityTARDIS> createRenderFor(RenderManager manager) {
		// TODO Auto-generated method stub
		return new RenderTARDIS(manager, new ModelTARDIS(), 0.75f);
	}

}

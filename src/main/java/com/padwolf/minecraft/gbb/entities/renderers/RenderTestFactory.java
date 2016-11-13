package com.padwolf.minecraft.gbb.entities.renderers;

import com.padwolf.minecraft.gbb.entities.EntityTARDIS;
import com.padwolf.minecraft.gbb.entities.EntityTest;
import com.padwolf.minecraft.gbb.entities.models.ModelTARDIS;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTestFactory implements IRenderFactory<EntityTest>{
	
	public static final RenderTestFactory INSTANCE = new RenderTestFactory();
	
	@Override
	public Render<? super EntityTest> createRenderFor(RenderManager manager) {
		// TODO Auto-generated method stub
		return new RenderTest(manager, new ModelTARDIS(), 0.75f);
	}

}

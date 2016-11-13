package com.padwolf.minecraft.gbb;

import org.lwjgl.input.Keyboard;

import com.padwolf.minecraft.gbb.entities.EntityTARDIS;
import com.padwolf.minecraft.gbb.entities.EntityTest;
import com.padwolf.minecraft.gbb.entities.models.ModelTARDIS;
import com.padwolf.minecraft.gbb.entities.renderers.RenderTARDIS;
import com.padwolf.minecraft.gbb.entities.renderers.RenderTARDISFactory;
import com.padwolf.minecraft.gbb.entities.renderers.RenderTestFactory;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyCommon {
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		System.out.println("Registering Renderers");
		RenderingRegistry.registerEntityRenderingHandler(EntityTARDIS.class, 
			      RenderTARDISFactory.INSTANCE);
		//RenderingRegistry.registerEntityRenderingHandler(EntityTest.class, 
		//	      RenderTestFactory.INSTANCE);
		System.out.println("Renderers Registered");
	}

	@Override
	public void init(FMLInitializationEvent e) {
		//Minecraft.getMinecraft().getRenderManager().entityRenderMap.put
		//(EntityTARDIS.class, new RenderTARDIS(Minecraft.getMinecraft().getRenderManager(),
		//		new ModelTARDIS(), 0.75f));
		super.init(e);
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
}

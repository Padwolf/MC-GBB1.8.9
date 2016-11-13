package com.padwolf.minecraft.gbb.refs;

import com.padwolf.minecraft.gbb.GBB;
import com.padwolf.minecraft.gbb.network.messages.EntityUpdateMessage;
import com.padwolf.minecraft.gbb.network.mhandlers.EntityUpdateMessageHandler;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class Globals {
	
	public static SimpleNetworkWrapper network;
	
	public GbbItems items = new GbbItems();
	public GbbBlocks blocks = new GbbBlocks();
	public GbbEntities entities = new GbbEntities();
	
	public Globals(){
		network = GBB.CHANNEL;
	}
	
	public void preInit(){
		network.registerMessage(EntityUpdateMessageHandler.class, EntityUpdateMessage.class, 0, Side.SERVER);
		blocks.preInit();
		entities.preInit();
	}
	
	public void init(){
		blocks.init();
		entities.init();
	}
	
	public void postInit(){
		blocks.postInit();
		entities.postInit();
	}
}

package com.padwolf.minecraft.gbb.refs;

import java.util.Iterator;
import java.util.Map;

import com.padwolf.minecraft.gbb.GBB;
import com.padwolf.minecraft.gbb.entities.EntityTARDIS;
import com.padwolf.minecraft.gbb.entities.EntityTest;

import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class GbbEntities {
	
	Class<EntityTARDIS> entityTardis = EntityTARDIS.class;
	
	public void preInit(){
		
	}
	
	public void init(){
		
		System.out.println("Registering TARDIS");
		
		EntityRegistry.registerModEntity(EntityTARDIS.class, "TARDIS", 1, GBB.instance, 80, 3, true);
		EntityRegistry.registerEgg(EntityTARDIS.class, 0x0000FF, 0x000000);
		//EntityRegistry.registerModEntity(EntityTest.class, "Test", 1, GBB.instance, 80, 3, true);
		//EntityRegistry.registerEgg(EntityTest.class, 0xFFFF00, 0xFFFFFF);
		
		Map<String, EntityEggInfo> m = EntityRegistry.getEggs();
		
		Iterator<String> i = m.keySet().iterator();
		
		while (i.hasNext()){
			System.out.println(m.get(i.next()).name);
		}
		
	}
	
	public void postInit(){
		
	}
	
}

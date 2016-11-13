package com.padwolf.minecraft.gbb;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ProxyCommon {
	
	public void preInit (FMLPreInitializationEvent e) {
		GBB.instance.GLOBALS.preInit();
	}

    public void init(FMLInitializationEvent e) {
    	GBB.instance.GLOBALS.init();
    }

    public void postInit(FMLPostInitializationEvent e) {
    	GBB.instance.GLOBALS.postInit();
    }
	
}

package com.padwolf.minecraft.gbb;

import com.padwolf.minecraft.gbb.refs.Globals;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = GBB.MODID, version = GBB.VERSION)
public class GBB
{
    public static final String MODID = "greatbluebox";
    public static final String VERSION = "indev";
    public final Globals GLOBALS = new Globals();
    public static SimpleNetworkWrapper CHANNEL = NetworkRegistry.INSTANCE.newSimpleChannel("GreatBlueBox");
    
    @Instance
    public static GBB instance = new GBB();
    
    @SidedProxy(clientSide="com.padwolf.minecraft.gbb.ProxyClient", serverSide="com.padwolf.minecraft.gbb.ProxyServer")
    public static ProxyCommon proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){proxy.preInit(event);}
    
    @EventHandler
    public void init(FMLInitializationEvent event){proxy.init(event);}
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){proxy.postInit(event);}
}

package com.padwolf.minecraft.gbb.refs;

import com.padwolf.minecraft.gbb.blocks.BlockSpacetimeEssence;
import com.padwolf.minecraft.gbb.blocks.GbbBlockRenderRegister;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class GbbBlocks {
	public static BlockSpacetimeEssence spacetimeEssence = new BlockSpacetimeEssence();
	
	public void preInit(){
		GameRegistry.registerBlock(spacetimeEssence, "spacetimeEssence");
	}
	
	public void init(){
		GbbBlockRenderRegister.registerBlockRenderer();
	}
	
	public void postInit(){
		
	}
}

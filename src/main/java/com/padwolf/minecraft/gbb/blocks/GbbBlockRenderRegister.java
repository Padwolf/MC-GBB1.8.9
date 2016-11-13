package com.padwolf.minecraft.gbb.blocks;

import com.padwolf.minecraft.gbb.GBB;
import com.padwolf.minecraft.gbb.refs.GbbBlocks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class GbbBlockRenderRegister {
	
	public static void registerBlockRenderer(){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(GbbBlocks.spacetimeEssence), 0, new ModelResourceLocation(GBB.MODID + ":spacetimeEssence", "inventory"));
	}
}

package com.padwolf.minecraft.gbb.blocks;

import com.padwolf.minecraft.gbb.GBB;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSpacetimeEssence extends Block{

	public BlockSpacetimeEssence() {
		super(Material.sand);
		
		this.setUnlocalizedName("spacetimeEssence");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(1);
        this.setResistance(1000000);
        
        setLightLevel((float) (Math.PI/10));
        
	}
	
	@Override
	public boolean isOpaqueCube() {
		return true;
	}

}

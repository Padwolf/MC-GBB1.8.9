package com.padwolf.minecraft.gbb.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTARDIS extends ModelBase{
	
	public ModelRenderer main;
	
	public int textureWidth = 80;
	public int textureHeight = 40;
	
	public ModelTARDIS(){
		main = new ModelRenderer(this, 0, 0);
		main.addBox(-12, 0, -12, 24, 48, 24);
		main.setRotationPoint(-12, 24, -12);
		main.setTextureSize(textureWidth, textureHeight);
		main.rotateAngleX = 0;
		main.rotateAngleY = 0;
		main.rotateAngleZ = 0;
		
	}
	
	@Override
	public void render(Entity entityIn, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_,
			float p_78088_6_, float scale) {
		super.render(entityIn, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, scale);
	}
	
	@Override
	public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_,
			float p_78087_5_, float p_78087_6_, Entity entityIn) {
		// TODO Auto-generated method stub
		super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, entityIn);
	}
	
//	@Override
//	public void render(Entity entity, float time, float swingSuppress, float arg_4, float headY,
//			float headX, float arg_7) {
//	}
	
}

package com.padwolf.minecraft.gbb.network.mhandlers;

import com.padwolf.minecraft.gbb.entities.EntityTARDIS;
import com.padwolf.minecraft.gbb.network.messages.EntityUpdateMessage;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class EntityUpdateMessageHandler implements IMessageHandler<EntityUpdateMessage, IMessage>{

	@Override
	public IMessage onMessage(final EntityUpdateMessage message, final MessageContext ctx) {
		IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj; // or Minecraft.getMinecraft() on the client
        mainThread.addScheduledTask(new Runnable() {
            @Override
            public void run() {
                EntityTARDIS entity = (EntityTARDIS) (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : ctx.getServerHandler().playerEntity).worldObj.getEntityByID(message.entityId);
                
                entity.setSyncDataCompound(message.entityDataCompound);
            	//System.out.println(String.format("Received %s from %s", message.entityId, ctx.getServerHandler().playerEntity.getDisplayName()));
            }
        });
        return null;
	}

}

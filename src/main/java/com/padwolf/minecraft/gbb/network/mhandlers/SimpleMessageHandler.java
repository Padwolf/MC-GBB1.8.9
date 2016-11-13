package com.padwolf.minecraft.gbb.network.mhandlers;

import com.padwolf.minecraft.gbb.network.messages.SimpleMessage;

import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SimpleMessageHandler implements IMessageHandler<SimpleMessage, IMessage>{

	@Override
	public IMessage onMessage(final SimpleMessage message, final MessageContext ctx) {
		// TODO Auto-generated method stub
		IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj; // or Minecraft.getMinecraft() on the client
        mainThread.addScheduledTask(new Runnable() {
            @Override
            public void run() {
                System.out.println(String.format("Received %s from %s", message.text, ctx.getServerHandler().playerEntity.getDisplayName()));
            }
        });
        return null;
	}
}

package com.padwolf.minecraft.gbb.network.messages;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class SimpleMessage implements IMessage{
	
	public String text;

    public SimpleMessage() { }

    public SimpleMessage(String text) {
        this.text = text;
    }
	
	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		
	}

}

package com.padwolf.minecraft.gbb.network.messages;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class EntityUpdateMessage implements IMessage{
	
	public int entityId;
	public NBTTagCompound entityDataCompound;

    public EntityUpdateMessage() { }

    public EntityUpdateMessage(int entityId, NBTTagCompound entitySyncDataCompound) {
        this.entityId = entityId;
        this.entityDataCompound = entitySyncDataCompound;
    }
	
	@Override
	public void fromBytes(ByteBuf buf) {
		entityId = buf.readInt();
		entityDataCompound = ByteBufUtils.readTag(buf);
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(entityId);
		ByteBufUtils.writeTag(buf, entityDataCompound);
		
	}
}

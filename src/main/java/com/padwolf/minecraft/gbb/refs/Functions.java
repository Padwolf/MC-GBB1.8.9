package com.padwolf.minecraft.gbb.refs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class Functions {
	public static void sendChatMessage(EntityPlayer player, String message){
		player.addChatMessage(new ChatComponentText(message));
	}
}

package spleefmanager.misc;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class Generic {
	public static void sendPublicNotice(World world, String string) {
		if (!world.isRemote) {
			MinecraftServer.getServer().getConfigurationManager().sendChatMsg(string);
		}
	}

	public static void sendPrivateChat(EntityPlayer player, String string) {
		if (!player.worldObj.isRemote) {
			player.sendChatToPlayer(string);
		}
	}
	
	public static void sendMultiLinesChat(boolean isPrivate, EntityPlayer player, String[] string) {
		if (!player.worldObj.isRemote) {
			if (isPrivate) {
				for (int i = 0; i < string.length; i++) {
					player.sendChatToPlayer(string[i]);
				} // end for
			} else {
				for (int i = 0; i <= string.length; i++) {
					MinecraftServer.getServer().getConfigurationManager().sendChatMsg(string[i]);
				} // end for
			} // end if
		} // end if
	} // end method
	
}

package spleefmanager.misc;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class Generic {
	public static void sendPublicNotice(World world, String string) {
		if (!world.isRemote) {
			//MinecraftServer.getServer().getConfigurationManager().sendPacketToAllPlayers(par1Packet);
		}
	}

	public static void sendPrivateChat(EntityPlayer player, String string) {
		if (!player.worldObj.isRemote) {
			player.sendChatToPlayer(string);
		}
	}
}

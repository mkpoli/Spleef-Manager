package spleefmanager.proxy;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends Proxy {

	public ClientProxy() {
	}
	@Override
	public void Init() {
		MinecraftForgeClient.preloadTexture(ITEMS_PNG);
	}
}

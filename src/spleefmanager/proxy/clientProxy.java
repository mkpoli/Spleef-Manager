package spleefmanager.proxy;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends Proxy {

	public ClientProxy() {
		MinecraftForgeClient.preloadTexture(ITEMS_PNG);
	}
	@Override
	public void Init() {
	}
}

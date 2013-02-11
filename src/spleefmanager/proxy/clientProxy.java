package spleefmanager.proxy;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends Proxy {

	public ClientProxy() {
		// TODO Auto-generated constructor stub
		MinecraftForgeClient.preloadTexture(ITEMS_PNG);
	}
	@Override
	public void Init()
	{
		
	}
}

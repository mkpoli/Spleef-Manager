package spleefmanager.Proxy;

import net.minecraftforge.client.MinecraftForgeClient;

public class clientProxy extends Proxy {

	public clientProxy() {
		// TODO Auto-generated constructor stub
		MinecraftForgeClient.preloadTexture(ITEMS_PNG);
	}
	@Override
	public void Init()
	{
		
	}
}

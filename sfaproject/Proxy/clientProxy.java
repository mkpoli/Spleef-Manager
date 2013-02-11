package sfaproject.Proxy;

import net.minecraftforge.client.MinecraftForgeClient;

public class clientProxy extends Proxy {
		@Override
		public void registerRenderers()
		{
			MinecraftForgeClient.preloadTexture(ITEMS_PNG);
		}
}

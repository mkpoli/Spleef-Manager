package sfaproject.Element.Item;

import sfaproject.SFAMOD;
import sfaproject.Proxy.Proxy;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class itemFloorRestorer extends Item {

	public itemFloorRestorer(int par1) {
		super(par1);
		
		 // Constructor Configuration
		maxStackSize = 64;
        setCreativeTab(SFAMOD.CT);
        setIconIndex(0);
        setItemName("itemfr");
	}

	@Override
    public String getTextureFile() {
        return Proxy.ITEMS_PNG;
	}
	
	@Override
    public float getStrVsBlock(ItemStack itemstack, Block block, int metadata)
    {
        return 0;
    }
	
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        return false;
    }

	//Replacing Func
	private boolean SetSpleefBlock(World world,int ax,int bx,int az,int bz,int y){

		return false;
	}
	
}

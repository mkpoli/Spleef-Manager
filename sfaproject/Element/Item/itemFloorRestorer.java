package sfaproject.Element.Item;

import sfaproject.SFAMOD;
import sfaproject.Proxy.Proxy;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class itemFloorRestorer extends Item {

/*	private int x1;
	private int z1;
	private int x2;
	private int z2;
	private int ys; */
	
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
	
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int x, int y, int z, int side, float par8, float par9, float par10)
    {
		if (world.isRemote) return true;
		
		/*
		if(hasUsed){
			x2=x;
			z2=z;
			System.out.println("第二个选择点" + x2 +","+ ys +","+ z2 );
 			}
		else {
			x1=x;
			z1=z;
			ys=y;
			System.out.println("第一个选择点" + x1 +","+ y +","+ z1 );
			} 
			  */
    	
    //	SetSpleefBlock(world, x1, x2, z1, z2, y);
    	
        return false;
    }

	//Replacing Func
	private boolean SetSpleefBlock(World world,int x1,int x2,int z1,int z2,int y){

		return false;
	}
	
}

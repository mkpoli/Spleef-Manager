package spleefmanager.Element.Item;

import spleefmanager.spfManager;
import spleefmanager.Proxy.Proxy;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class itemFloorRestorer extends Item {

	private static int x1;
	private static int z1;
	private static int x2;
	private static int z2;
	private static int y1;
	private static int y2;
	public static boolean hasUsed=false;
	public itemFloorRestorer(int par1) {
		super(par1);
		
		 // Constructor Configuration
		maxStackSize = 64;
        setCreativeTab(spfManager.CT);
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
	
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2, World world, int x, int y, int z, int side, float par8, float par9, float par10)
    {
		if (world.isRemote) return true;
		if(hasUsed){
			x2=x;
			z2=z;
			y2=y;
			par2.sendChatToPlayer("Second selection point chosen. (" + x2 + "," + y2 + "," + z2 + ")");	
	    	if( y1 ==y2 ){
	    		//TODO:用NBT保存数据，在聊天窗口中询问生成的区域名称
	    		//最终保存用Command实现？
	    		SetSpleefBlock(world, x1, x2, z1, z2, y1,538);
	    		//以上或许可以用SetArea/RestoreArea命令中的方法替代
	    		hasUsed=false; //复位
	    		x1=x2=y1=y2=z1=z2=0;
	    		return true;
	    	}else{
	    		par2.sendChatToPlayer("Exception : Two points aren't at the same height.");
	    		hasUsed=false;
	    		return true;
	    	}
 		}
		else {
			x1=x;
			z1=z;
			y1=y;
			par2.sendChatToPlayer("First selection point chosen. (" + x1 + "," + y1 + "," + z1 + ")");
			hasUsed=true;
		} 

        return true;
    }

	//Replacing Func
	private boolean SetSpleefBlock(World world,int x1,int x2,int z1,int z2,int y,int blockID){
		int c;
		c=x1>x2?x1:x2;
		x1=x1>x2?x2:x1; //x1 smaller one
		x2=c;
		
		c=z1>z2?z1:z2;
		z1=z1>z2?z2:z1;
		z2=c;
		for(int i=x1;i<x2;i++){
			for(int j=z1;j<z2;j++)
				world.setBlock(i, y, j, blockID);
		}
		return true;
	}
	
}

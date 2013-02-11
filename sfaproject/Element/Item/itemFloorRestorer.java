package spleefmanager.Element.Item;

import spleefmanager.spfManager;
import spleefmanager.Misc.Generic;
import spleefmanager.Proxy.Proxy;
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
	public boolean hasUsed=false;
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
		
		int x1,z2,x2,z1,z21,y1 = 0,y2 = 0;
		if(hasUsed){
			x2=x;
			z21=z;
			y2=y;
			par2.sendChatToPlayer("选择了第一个选择点。");
			hasUsed=false;
 		}
		else {
			x1=x;
			z1=z;
			y1=y;
			par2.sendChatToPlayer("选择了第二个选择点.");
		} 
    	if( !hasUsed || y1!=y2){
    		return false;
    	}
    	Generic.sendPublicNotice(world, "Tring Chatting");
    	Generic.sendPrivateChat(par2, "Tring Private Chatting");
		//	SetSpleefBlock(world, x1, x2, z1, z2, y);
		//TODO:用NBT保存数据，在聊天窗口中询问生成的区域名称
		//最终保存用Command实现？
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

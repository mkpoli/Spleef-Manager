package spleefmanager.element.Item;

import spleefmanager.SpfManager;
import spleefmanager.proxy.Proxy;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFloorRestorer extends Item {

	public static int x1; //First Blocks'x
	public static int y1;
	public static int z1; 
	public static int x2; //Second Blocks'x
	public static int y2;
	public static int z2;
	
	public static boolean hasUsed = false;
	public static boolean setComplete = false;
	
	
	//process funcs
	
	// Constructor Configuration
	public ItemFloorRestorer(int par1) {
		super(par1);
		maxStackSize = 64;
        setCreativeTab(SpfManager.CT);
        setIconIndex(0);
        setItemName("itemfr");
	}

	@Override
    public String getTextureFile() {
        return Proxy.ITEMS_PNG;
	}
	
	@Override
    public float getStrVsBlock(ItemStack itemstack, Block block, int metadata) {
        return 0;
    }
	
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2, World world,
    											int x, int y, int z, int side, float par8, float par9, float par10) {
		if (world.isRemote) return true;
		
		if (hasUsed) {
			
			x2 = x;
			z2 = z;
			y2 = y;
			par2.sendChatToPlayer("Second selection point chosen. (" + x2 + "," + y2 + "," + z2 + ")");	
			
	    	if (y1 == y2 ) {
	    		hasUsed=false; //复位
	    		setComplete=true;
	    		par2.sendChatToPlayer("Points setting completed . Please use /spfset name or /spfset name BlockID to set the Spleef Arena area.");
	    		return true;
	    	 } else {
	    		par2.sendChatToPlayer("Exception : Two points aren't at the same height.");
	    		hasUsed = false;
	    		return true;
	    	 } // end if
	    	
 		} else {
 			
			x1 = x;
			z1 = z;
			y1 = y;
			par2.sendChatToPlayer("First selection point chosen. (" + x1 + "," + y1 + "," + z1 + ")");
			hasUsed = true;
			setComplete=false;
			
		} // end if
        return true;
    }

}

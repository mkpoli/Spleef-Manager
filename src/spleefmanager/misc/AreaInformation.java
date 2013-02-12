package spleefmanager.misc;

import org.lwjgl.util.glu.PartialDisk;

import com.google.common.base.Optional;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import spleefmanager.SpfManager;
import spleefmanager.misc.Generic;


public class AreaInformation {
	/*
	 * �˴���ʱʹ������
	 * ���ܸ���ģ��
	 * ��ʱ�����鷽ʽ�����������
	 */
//	private static Area[] arr;
//	private static int areaCount=0;
	private String[] stringInfo = {"-----------------Area Information-------------", null, null, null , null ,"----------------------------------------------"};
	private Area area;
	//���캯��
	public AreaInformation() {
	}

	public Area readAreaInformationFromFile(String name) {
		int x1 = SpfManager.nbt.getInteger(name +"x1");
		int x2 = SpfManager.nbt.getInteger(name +"x2");
		int z1 = SpfManager.nbt.getInteger(name +"z1");
		int z2 = SpfManager.nbt.getInteger(name +"z2");
		int y = SpfManager.nbt.getInteger(name +"y");
		int bID = SpfManager.nbt.getInteger(name +"BlockID");
//		arr[] = new Area(x1,z1,x2,z2,y,bID,name);
		area = new Area(x1,z1,x2,z2,y,bID,name);
		return area;
	}
	
	
	/**ServerCommand use this prototype
	 *  Save area's information(CommandSender, x1, z1, x2, z2, y, BlockID and name).
	 *  
	 *  @return false
	 *  Printout ("Area creating failed.").
	 *  @return true
	 *  do nothing
	*/
	public boolean saveAreaInformation(ICommandSender ics, int x1,int z1,int x2,int z2,int y,int BlockID,String name)
	{
	/*	for(int i=0;i<areaCount;i++)
		{
			//detect name conflict
			if(area.sAreaName == name)
				ics.sendChatToPlayer("Area Existing , delete it first plz ... ");
			return false;
		}
*/
		if (isExistingArea(name)) {
			ics.sendChatToPlayer("The area you given is existing, delete it first plz.");
			return false;
		}
/*	可能被处理掉，暂不考虑
	if (areaCount >= 100){
			ics.sendChatToPlayer("Can't store more areas,please delete some.");
		}

		areaCount++;
		arr[areaCount-1]=new Area(x1,z1,x2,z2,y,BlockID,name);
*/
		
		SpfManager.nbt.setInteger(name + "x1", x1);
		SpfManager.nbt.setInteger(name + "z1", z1);
		SpfManager.nbt.setInteger(name + "x2", x2);
		SpfManager.nbt.setInteger(name + "z2", z2);
		SpfManager.nbt.setInteger(name + "y", y);
		SpfManager.nbt.setInteger(name + "BlockID" , BlockID);
		SpfManager.nbt.setString(name, name);
		
		return true;
	}
	
/*	
	//Item uses this prototype
	public boolean saveAreaInformation(EntityPlayer par ,
			int x1,int z1,int x2,int z2,int y,int BlockID,String name) {
		//detect name conflict
		for(int i=0;i<areaCount;i++){
			if(area.sAreaName == name)
				par.sendChatToPlayer("Area Existing , delete it first plz ... ");
			return false;
		}
		
		if(areaCount >= 100){
			par.sendChatToPlayer("Can't store more areas,please delete some.");
		}
		
		SpfManager.nbt.setInteger(name + "x1", x1);
		SpfManager.nbt.setInteger(name + "z1", z1);
		SpfManager.nbt.setInteger(name + "x2", x2);
		SpfManager.nbt.setInteger(name + "z2", z2);
		SpfManager.nbt.setInteger(name + "y", y);
		SpfManager.nbt.setInteger(name + "BlockID",BlockID);
		SpfManager.nbt.setString(name,name);
		par.sendChatToPlayer("Sucessfully create the area <" + name + ">");
		
		return true;
	}
*/

	public boolean restoreArea(ICommandSender ics,String name) {
		if (isExistingArea(name)) {
			ics.sendChatToPlayer("Exist!");
			Area area = readAreaInformationFromFile(name);
			ics.sendChatToPlayer("area seted");
			SetSpleefBlock(CommandBase.getCommandSenderAsPlayer(ics).worldObj,
					area.x1, area.z1, area.x2, area.z2, area.y, area.BlockID);
			ics.sendChatToPlayer("SetSpleefBlocked");
			return true; 
		} else {
			ics.sendChatToPlayer("not Exist!");
/*			
		for(int i=0;i<areaCount;i++){
			if(name == area.sAreaName){	
				SetSpleefBlock(CommandBase.getCommandSenderAsPlayer(par).worldObj, area.x1,area.z1, area.x2,area.z2, area.y, area.BlockID);
				par.sendChatToPlayer("Area sucessfully restored. ");		
			}
		}
		par.sendChatToPlayer("Area not found, it has not been restored.");
 																														*/
		return false;
		}
	}

	private void SetSpleefBlock(World world,int x1,int z1,int x2,int z2,int y,int blockID) {
		int bx; 
		int sx;
		int bz;
		int sz;
			
		bx = (x1 > x2) ? x1 : x2;
		sx = (x1 > x2) ? x2 : x1; 
			
		bz = (z1 > z2) ? z1 : z2;
		sz = (z1 > z2) ? z2 : z1;

		for (int i = sx; i < bx; i++)
			for (int j = sz; j < bz; j++)
				world.setBlock(i, y, j, blockID);
		return;
	}
	
/*	//Ҫ��������м�Block�Ĺ���ô?
	public boolean deleteArea(String name , ICommandSender par){
		for(int i=0;i<areaCount;i++)
		{
			if(area.sAreaName == name){
				area=arr[areaCount];
				par.sendChatToPlayer("Area " + name + " sucessfully deleted.");
				return true;
			}
		}
		par.sendChatToPlayer("Not found,area was not deleted.");
		return false;
	}
	*/
	
	public boolean deleteArea(String name , ICommandSender par){
//		SpfManager.nbt.removeTag(name);
		return false;
	}
	
	public void showAreaInformation(EntityPlayer par,String name) {
		if (isExistingArea(name)) {
			readAreaInformationFromFile(name);
			stringInfo[1] = "Area Name : " + name;
			stringInfo[2] = "Area range : " + area.x1 + " " + area.z1;
			stringInfo[3] = "      To   : " + area.x2 + " " + area.z2;
			stringInfo[4] = "Filled Block : " + new  ItemStack(SpfManager.blocksb).getItemName();
			Generic.sendMultiLinesChat(true, par, stringInfo);
			return;
		}
			return;
/*		for(int i=0;i<areaCount;i++){
			if(area.sAreaName == name){
				par.sendChatToPlayer("-----------------Area Information-------------");
				par.sendChatToPlayer("Area Name : " + name);
				par.sendChatToPlayer("Area range : " + area.x1 + " " + area.z1);
				par.sendChatToPlayer("      To   : " + area.x2 + " " + area.z2);
				par.sendChatToPlayer("Filled Block : " + new  ItemStack(SpfManager.blocksb).getItemName() );				
				par.sendChatToPlayer("----------------------------------------------");
				return;
			}
			
		}
*		par.sendChatToPlayer("No required area found.");
		return;
		*/
	}
	
	public void showAreaInformation(EntityPlayer par,String name,int BlockID) {
		if (isExistingArea(name)) {
			readAreaInformationFromFile(name);
			stringInfo[1] = "Area Name : " + name;
			stringInfo[2] = "Area range : " + area.x1 + " " + area.z1;
			stringInfo[3] = "      To   : " + area.x2 + " " + area.z2;
			stringInfo[4] = "Filled Block : " + new  ItemStack(SpfManager.blocksb).getItemName();
			Generic.sendMultiLinesChat(true, par, stringInfo);
			return;
		}
			return;
/*		for(int i=0;i<areaCount;i++){
			if(area.sAreaName == name){
				par.sendChatToPlayer("-----------------Area Information-------------");
				par.sendChatToPlayer("Area Name : " + name);
				par.sendChatToPlayer("Area range : " + area.x1 + " " + area.z1);
				par.sendChatToPlayer("      To   : " + area.x2 + " " + area.z2);
				par.sendChatToPlayer("Filled Block : " + new ItemStack(BlockID, 0, 0).getItemName());				
				par.sendChatToPlayer("----------------------------------------------");
				
				return
				};
		par.sendChatToPlayer("No required area found.");
		return;
		*/
	}
	
	
/*	public void showAreaInformation(EntityPlayer par){
		
		for(int i=0;i<areaCount;i++){
			par.sendChatToPlayer("-----------------Area Information-------------");
			par.sendChatToPlayer("Area Name : " + area.sAreaName);
			par.sendChatToPlayer("Area range : " + area.x1 + " " + area.z1);
			par.sendChatToPlayer("      To   : " + area.x2 + " " + area.z2);
			par.sendChatToPlayer("Filled Block : " + new  ItemStack(SpfManager.blocksb).getItemName() );				
			par.sendChatToPlayer("----------------------------------------------");
		}
	}
	*/
	
	/**
	 * Determines the given string(Area Name) is existing or not.
	 * @param name
	 * The name of area
	 * @return true
	 * It's existing.
	 * @return false
	 * It isn't existing.
	 */
	private boolean isExistingArea(String name) {
	/*	try {
			SpfManager.nbt.getString(name);
			return true;
		} catch (Exception e) {
			return false;
		}
	}	*/
		if(SpfManager.nbt.hasKey(name)) {
			return true;

		} else {
			return false;
		}
		
		
/*		
		if (SpfManager.nbt.getString(name) == "") {
			return false;
		} else {
			return true;
		}
		
		*/
	}	
}
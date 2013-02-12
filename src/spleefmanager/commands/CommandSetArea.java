package spleefmanager.commands;

import spleefmanager.SpfManager;
import spleefmanager.element.Item.ItemFloorRestorer;
import spleefmanager.misc.AreaInformation;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandKill;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import spleefmanager.misc.*;
//Command setting the Spleef Area.
//Takes 0 or 4 Arguments.
//0:Client only.rightclick on two seperate blocks to set area(Height must be exactly the same)
//4:Both server&client.giving area x1,y1,x2,y2 as Spleef area
//Stores information inside serverside files.
//command name : setSpleefArea

public class CommandSetArea extends CommandBase{

	private String usage = "/spfset <x1> <z1> <x2> <z2> <y><BlockID><name>";
	public String getCommandName(){
		return "spfset";
	}
	
	public void processCommand(ICommandSender ics, String[] pars) {
/*		var1.sendChatToPlayer("Please choose the first block by right click"); */
		if (pars.length == 7) {
			int x1 = Integer.parseInt(pars[0]);
			int z1 = Integer.parseInt(pars[1]);
			int x2 = Integer.parseInt(pars[2]);
			int z2 = Integer.parseInt(pars[3]);
			int y = Integer.parseInt(pars[4]);
			int BlockID=Integer.parseInt(pars[5]);
			String name = pars[6];
			SpfManager.areaInf.saveAreaInformation(ics, x1, z1, x2, z2, y, BlockID , name);
		} 
		else if(pars.length==6){
			int x1 = Integer.parseInt(pars[0]);
			int z1 = Integer.parseInt(pars[1]);
			int x2 = Integer.parseInt(pars[2]);
			int z2 = Integer.parseInt(pars[3]);
			int y = Integer.parseInt(pars[4]);
			int BlockID=SpfManager.blocksb.blockID;
			String name = pars[6];
			SpfManager.areaInf.saveAreaInformation(ics, x1, z1, x2, z2, y, BlockID , name);
		}
		//1 para:name 2para:name and BlockID
		else if(pars.length==1){
			if(ItemFloorRestorer.setComplete){
				int x1=ItemFloorRestorer.x1;;
				int z1=ItemFloorRestorer.x2;
				int x2=ItemFloorRestorer.z1;
				int z2=ItemFloorRestorer.z2;
				int y=ItemFloorRestorer.y1;
				int BlockID=SpfManager.blocksb.blockID;
				String name=pars[0];
				SpfManager.areaInf.saveAreaInformation(ics, x1, z1, x2, z2, y, BlockID, name);
				ItemFloorRestorer.setComplete=false;
				ics.sendChatToPlayer("Area successfully created.");
				SpfManager.areaInf.showAreaInformation(getCommandSenderAsPlayer(ics),name);
			}
		}
		else if(pars.length==2){
			if(ItemFloorRestorer.setComplete){
				int x1=ItemFloorRestorer.x1;;
				int z1=ItemFloorRestorer.x2;
				int x2=ItemFloorRestorer.z1;
				int z2=ItemFloorRestorer.z2;
				int y=ItemFloorRestorer.y1;
				int BlockID=Integer.parseInt(pars[1]);
				String name=pars[0];
				SpfManager.areaInf.saveAreaInformation(ics, x1, z1, x2, z2, y, BlockID, name);
				ItemFloorRestorer.setComplete=false;
			}
		}
		else throw new WrongUsageException(usage, new Object[0]);
        
	}
	
	public int getRequiredPermissionLevel() {
		return 0;
	}
	
	@Override
    public String getCommandUsage(ICommandSender par1ICommandSender) {
        return usage;
    }

}

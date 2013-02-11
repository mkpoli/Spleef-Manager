package spleefmanager.commands;

import spleefmanager.SpfManager;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandKill;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;

//Command setting the Spleef Area.
//Takes 0 or 4 Arguments.
//0:Client only.rightclick on two seperate blocks to set area(Height must be exactly the same)
//4:Both server&client.giving area x1,y1,x2,y2 as Spleef area
//Stores information inside serverside files.
//command name : setSpleefArea

public class CommandSetArea extends CommandBase{

	private String usage = "/spfset <x1> <z1> <x2> <z2> <y> <name>";
	public String getCommandName(){
		return "spfset";
	}
	
	public void processCommand(ICommandSender ics, String[] pars) {
/*		var1.sendChatToPlayer("Please choose the first block by right click"); */
		if (pars.length == 6) {
			int x1 = Integer.parseInt(pars[0]);
			int z1 = Integer.parseInt(pars[1]);
			int x2 = Integer.parseInt(pars[2]);
			int z2 = Integer.parseInt(pars[3]);
			int y = Integer.parseInt(pars[4]);
			String name = pars[5];
			SpfManager.nbt.setInteger(name + "x1", x1);
			SpfManager.nbt.setInteger(name + "z1", z1);
			SpfManager.nbt.setInteger(name + "x2", x2);
			SpfManager.nbt.setInteger(name + "z2", z2);
			SpfManager.nbt.setInteger(name + "y", y);
		//	SpfManager.nbt.setString("name",name);
			ics.sendChatToPlayer("Sucessfully create the area <" + name + ">");
		} else {
            throw new WrongUsageException(usage, new Object[0]);
        }
	}
	
	public int getRequiredPermissionLevel() {
		return 0;
	}
	
	@Override
    public String getCommandUsage(ICommandSender par1ICommandSender) {

        return usage;
    }

}

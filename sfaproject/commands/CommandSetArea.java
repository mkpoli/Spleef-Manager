package spleefmanager.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandKill;
import net.minecraft.command.ICommandSender;

//Command setting the Spleef Area.
//Takes 0 or 4 Arguments.
//0:Client only.rightclick on two seperate blocks to set area(Height must be exactly the same)
//4:Both server&client.giving area x1,y1,x2,y2 as Spleef area
//Stores information inside serverside files.
//command name : setSpleefArea

public class CommandSetArea extends CommandKill{

	public String getCommandName(){
		return "spfset";
	}
	public void processCommand(ICommandSender var1, String[] var2) {
		// TODO Auto-generated method stub
		var1.sendChatToPlayer("Not finished yet xDDDDD");
		
	}
	public int getRequiredPermissionLevel()
	{
		return 0;
	}

}

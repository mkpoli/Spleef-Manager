package spleefmanager.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import spleefmanager.SpfManager;
	
//Takes 1 or 0 Argument.
//1 Argument:delete the specific area by name
//0 Argument:Show instructions & give spleefarea lists.
public class CommandDelArea extends CommandBase {
	private String usage = "/spfdel <name>";

	public CommandDelArea() {
	}

	@Override
	public String getCommandName() {
		return "spfdel";
	}

	@Override
	public void processCommand(ICommandSender ics, String[] pars) {
		if (pars.length == 1) {
			String name = pars[0]; //低级错误啊有木有> >
			
			if( SpfManager.areaInf.deleteArea(name) ){
				ics.sendChatToPlayer("Area has  been removed.");
			} else {
				ics.sendChatToPlayer("Fatal Error : Area has not been rmoved.");
			}
			
		} else {
			
			throw new WrongUsageException(usage, new Object[0]);
		}
		
	}
	
	@Override
    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return usage;
    }

}

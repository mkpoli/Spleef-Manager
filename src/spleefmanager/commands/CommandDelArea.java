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
			String name = pars[5];
	/*		SpfManager.nbt.setInteger(name + "x1" , 0 );
			SpfManager.nbt.setInteger(name + "z1", z1);
	 	SpfManager.nbt.setInteger(name + "x2", x2);
			SpfManager.nbt.setInteger(name + "z2", z2);
			SpfManager.nbt.setInteger(name + "y", y);
																										*/
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

package spleefmanager.commands;

import java.util.jar.Attributes.Name;

import spleefmanager.SpfManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSnow;
import net.minecraft.command.*;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class CommandRestoreArea extends CommandBase {
	private String usage = "/spfrestore <name>";
	
	
	public CommandRestoreArea() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getCommandName()
	{
		return "spfrestore";
	}
	
	@Override
	public void processCommand(ICommandSender ics, String[] pars) {
		
		if (pars.length == 1) {
			String name = pars[0];
			SpfManager.areaInf.restoreArea(ics, name);
		} 
		else {
			throw new WrongUsageException(usage, new Object[0]);
		}
	}
	
	@Override
    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return usage;
    }
}

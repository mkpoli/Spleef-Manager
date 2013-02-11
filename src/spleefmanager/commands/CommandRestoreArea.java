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
		// TODO Auto-generated method stub
		// TODO Add functions reading from world.
		if (pars.length == 1) {
			String name = pars[0];
			World world = getCommandSenderAsPlayer(ics).worldObj;
			int x1 = SpfManager.nbt.getInteger(name +"x1");
			int x2 = SpfManager.nbt.getInteger(name +"x2");
			int z1 = SpfManager.nbt.getInteger(name +"z1");
			int z2 = SpfManager.nbt.getInteger(name +"z2");
			int y = SpfManager.nbt.getInteger(name +"y");
			SetSpleefBlock(world, x1, x2, z1, z2, y, SpfManager.blocksb.blockID);
			ics.sendChatToPlayer("Sucessfully restore the area <" + name + ">");
		} else {
			throw new WrongUsageException(usage, new Object[0]);
		}
	
	
		/*	World world=getCommandSenderAsPlayer(var1).worldObj;
		ReplaceBlock(world,x1,y1,x2,y2,z); */
	}
	
	//Replacing Func
	private boolean SetSpleefBlock(World world,int x1,int x2,int z1,int z2,int y,int blockID) {
		int bx; 
		int sx;
		int bz;
		int sz;
		
		//p>m
		//p= 1 or 2 bigger one
		//m = 1 or 2 smaller one
		
		bx = (x1>x2) ? x1 : x2;
		sx = (x1>x2) ? x2 : x1; 
		
		bz = (z1 > z2) ? z1 : z2;
		sz = z1 = (z1 > z2) ? z2 : z1;

		for (int i = sx; i < bx; i++) {
			for (int j = sz; j < bz; j++)
				world.setBlock(i, y, j, blockID);
		}
		
/*		for (int i = sx; i < bx; i++) {
			for (int j = sz; j < bz; j++)
				world.setBlock(i, y++, j, 0);
		}
		
		for (int i = sx; i < bx; i++) {
			for (int j = sz; j < bz; j++)
				world.setBlock(i, y+2, j, 0);
				
		}
																			*/
		return true;
	}
	
	@Override
    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return usage;
    }
}

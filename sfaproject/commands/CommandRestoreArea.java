package spleefmanager.commands;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSnow;
import net.minecraft.command.*;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class CommandRestoreArea extends CommandBase {
	
	public CommandRestoreArea() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getCommandName()
	{
		return "spfrestore";
	}
	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		// TODO Auto-generated method stub
		// TODO Add functions reading from world.
		int x1=0,y1=0,x2=0,y2=0,z=0;
		World world=getCommandSenderAsPlayer(var1).worldObj;
		ReplaceBlock(world,x1,y1,x2,y2,z);
	}
	
	private void ReplaceBlock(World world,int x1,int y1,int x2,int y2,int z)
	{
		int c;
		c=x1>x2?x1:x2;
		x1=x1>x2?x2:x1; //x1 smaller one
		x2=c;
		c=y1>y2?y1:y2;
		y1=y1>y2?y2:y1;
		y2=c;
		for(int i=x1;i<x2;i++){
			for(int j=y1;j<y2;j++)
				world.setBlock(i, j, z, Block.snow.blockID);
		}
		return;
	}
}

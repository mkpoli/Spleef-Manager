package sfaproject.Element.Block;

import sfaproject.SFAMOD;
import sfaproject.Proxy.Proxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class blockSpleef extends Block{

	public blockSpleef(int par1,int par2) {
		super(par1, par2, Material.snow);
		//setting
		setBlockName("Spleef_Block");
		setHardness(0.1F);
		setStepSound(soundSnowFootstep);
		setCreativeTab(SFAMOD.CT);
	}

}
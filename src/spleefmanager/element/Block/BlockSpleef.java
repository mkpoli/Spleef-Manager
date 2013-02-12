package spleefmanager.element.Block;

import spleefmanager.SpfManager;
import spleefmanager.proxy.Proxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSpleef extends Block{

	public BlockSpleef(int par1,int par2) {
		super(par1, par2, Material.craftedSnow);
		
		setCreativeTab(SpfManager.CT);
		setBlockName("Spleef_Block");
		setHardness(0.1F);
		setStepSound(soundSnowFootstep);
		setLightValue(1.0F);
	}

}

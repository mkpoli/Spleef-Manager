package spleefmanager;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import spleefmanager.Element.Block.blockSpleef;
import spleefmanager.Element.Item.itemFloorRestorer;
import spleefmanager.Misc.CreativeTab;
import spleefmanager.commands.Commands;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid="spfm",name="SpleefManager",version="0.0.0.1")
@NetworkMod(clientSideRequired=true,serverSideRequired=false)


public  class spfManager {
	public final static blockSpleef blocksb = new blockSpleef(538,66);
	public final static Item itemfr = new itemFloorRestorer(12003);
	public static CreativeTab CT = new CreativeTab("SpleefFloorAssist");
	@Instance("spfm")
	public static spfManager spfm;
	@SidedProxy(clientSide="spleefmanager.Proxy.clientProxy",serverSide="spleefmanager.Proxy.Proxy")
	public static spleefmanager.Proxy.Proxy Proxy;
	@PreInit
	public static void PreInit(FMLPreInitializationEvent Init)
	{
		
	}
	@Init
	public static void Init(FMLInitializationEvent Init){
		Commands cmd = new Commands();

    	//Stacks Instance
    	ItemStack redstoneStack = new ItemStack(Item.redstone);
    	ItemStack diamondStack = new ItemStack(Item.diamond);
    	ItemStack plankStack = new ItemStack(Block.planks);
    	ItemStack dirtStack = new ItemStack(Block.dirt);  		
        //Elements Registing
    	GameRegistry.registerBlock(blocksb,"blocksb");
    	LanguageRegistry.addName(blocksb, "Spleef Block");
    	LanguageRegistry.addName(itemfr, "Floor Restorer");
    	LanguageRegistry.instance().addStringLocalization("itemGroup.SpleefFloorAssist", "en_US", "Spleef Floor Assist");
    	//Crafting
    	GameRegistry.addRecipe(new ItemStack(itemfr),"A  "," B ","  C",
    			'A',redstoneStack,'B',diamondStack,'C',plankStack);
    	GameRegistry.addRecipe(new ItemStack(blocksb),"A",'A',dirtStack);
    		
    	//Other
    	MinecraftForge.setBlockHarvestLevel(blocksb, "shovel", 3);
	}
	@PostInit
	public static void PostInit(FMLPostInitializationEvent Init){
		
	}
	public spfManager() {
		// TODO Auto-generated constructor stub
	}

}

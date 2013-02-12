/**	
  * The mod's main load file
  * 
  * Instanced itself as spfm
  * 
  * Instanced BlockSpleef as blocksb
  * Instanced ItemFloorRestorer as itemfr
  * Instanced CreativeTab as CT
  * 
  * Instanced ItemStacks Instances
  * Registed Blocks And Language Registed Strings
 * 
 * Added Recipes
 * 
 * Registed Commands
 * 
 * @author mkpoli & WeAthFolD
 * 
 */

package spleefmanager;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLogic;
import net.minecraft.command.CommandHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;
import spleefmanager.element.Block.BlockSpleef;
import spleefmanager.element.Item.ItemFloorRestorer;
import spleefmanager.commands.CommandDelArea;
import spleefmanager.commands.CommandHelp;
import spleefmanager.commands.CommandRestoreArea;
import spleefmanager.commands.CommandSetArea;
import spleefmanager.misc.AreaInformation;
import spleefmanager.misc.CreativeTab;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="spfm",name="SpleefManager",version="0.0.0.1") //Mod Info
@NetworkMod(clientSideRequired=true,serverSideRequired=false) //Mod Settings of Network

public  class SpfManager {
	public final static Block blocksb = new BlockSpleef(538,66); 
	public final static ItemFloorRestorer itemfr = new ItemFloorRestorer(12003);
	public static CreativeTab CT = new CreativeTab("SpleefFloorAssist");
	public static NBTTagCompound nbt = new NBTTagCompound();
	public static AreaInformation areaInf=new AreaInformation();
	@Instance("spfm")
	public static SpfManager spfm;
	
	@SidedProxy(clientSide="spleefmanager.proxy.ClientProxy",serverSide="spleefmanager.proxy.Proxy")
	public static spleefmanager.proxy.Proxy Proxy; //defined Proxy class
	
	@PreInit
	public static void PreInit(FMLPreInitializationEvent Init) {
	}
	
	@Init
	public static void Init(FMLInitializationEvent Init) {
		//Commands cmd = new Commands(); //Instanced Commands as cmd
		Proxy.Init(); //Initial of Proxy class
    	//Stacks Instance
		ItemStack bonemealStack  = new ItemStack(Item.dyePowder,15);
    	ItemStack diamondStack = new ItemStack(Item.diamond);
    	ItemStack stickStack = new ItemStack(Item.stick);
    	ItemStack dirtStack = new ItemStack(Block.dirt);  		
        //Elements Registing
    	GameRegistry.registerBlock(blocksb,"blocksb");
    	blocksb.setCreativeTab(CT);
    	LanguageRegistry.addName(blocksb, "Spleef Block");
    	LanguageRegistry.addName(itemfr, "Floor Restorer");
    	LanguageRegistry.instance().addStringLocalization("itemGroup.SpleefFloorAssist", "en_US", "Spleef Floor Assist");
    	//Crafting
    	GameRegistry.addRecipe(new ItemStack(itemfr),"AA "," BB ","  C",
    			'A',bonemealStack,'B',diamondStack,'C',stickStack);
    	GameRegistry.addRecipe(new ItemStack(blocksb),"A",'A',dirtStack);
    		
    	//Other
    	MinecraftForge.setBlockHarvestLevel(blocksb, "shovel", 3);
	}
	
	@PostInit
	public static void PostInit(FMLPostInitializationEvent Init) {
	}
	
	public SpfManager() {
	}
	
	@ServerStarting //commands registration
	public void serverStarting(FMLServerStartingEvent event) {
	    CommandHandler commandManager = (CommandHandler)event.getServer().getCommandManager();
	    commandManager.registerCommand(new CommandHelp());
	    commandManager.registerCommand(new CommandDelArea());
	    commandManager.registerCommand(new CommandRestoreArea());
	    commandManager.registerCommand(new CommandSetArea());
	}
}

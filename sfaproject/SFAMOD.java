package sfaproject;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import sfaproject.Element.Block.blockSpleef;
import sfaproject.Element.Item.itemFloorRestorer;
import sfaproject.Misc.CreativeTab;
import sfaproject.Proxy.Proxy;
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

@Mod(modid="sfa",name="Spleef Floor Assist",version="0.0.0")
@NetworkMod(clientSideRequired=true,serverSideRequired=false)

public class SFAMOD {
    //Public Instance
	public final static Item itemfr = new itemFloorRestorer(12003);
	public static CreativeTab CT = new CreativeTab("SpleefFloorAssist");
	public final static Block blocksb = new blockSpleef(538,66);
	// The instance of your mod that Forge uses.
    @Instance("sfa")
    public static SFAMOD instance;
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="sfaproject.Proxy.clientProxy", serverSide="sfaproject.Proxy.Proxy")
    public static Proxy proxy;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
            // Stub Method
    }
    
    @Init
    public void load(FMLInitializationEvent event) {
        //Renderer Registing(PreLoadTXTR)    
    		proxy.registerRenderers();

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
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }
}

package spleefmanager.Misc;

import javax.lang.model.element.Element;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import spleefmanager.spfManager;
import spleefmanager.Element.Item.itemFloorRestorer;

public class CreativeTab extends CreativeTabs {

	public CreativeTab(String label) {
		super(label);
	}

	@Override
	public ItemStack getIconItemStack() {
	    return new ItemStack(new itemFloorRestorer(12003));
	}
	//
}

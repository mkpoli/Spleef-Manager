package spleefmanager.misc;

import javax.lang.model.element.Element;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import spleefmanager.SpfManager;
import spleefmanager.element.Item.ItemFloorRestorer;

public class CreativeTab extends CreativeTabs {

	public CreativeTab(String label) {
		super(label);
	}

	@Override
	public ItemStack getIconItemStack() {
	    return new ItemStack(new ItemFloorRestorer(12003));
	}
}

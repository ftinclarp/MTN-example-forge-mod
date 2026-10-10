package com.mtn.example;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class MyItem extends Item {

    public MyItem() {
        super("myitem");
        setCreativeTab(CreativeTabs.TAB_MISC);
    }

    public MyItem setCreativeTab(CreativeTabs tab) {
        return this;
    }
}

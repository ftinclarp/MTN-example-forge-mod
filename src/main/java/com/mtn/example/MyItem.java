package com.mtn.example;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class MyItem extends Item {

    public MyItem() {
        super();
        setUnlocalizedName("myitem");
        setTextureName("mtnexample:myitem");
        setCreativeTab(CreativeTabs.tabMisc);
    }
}

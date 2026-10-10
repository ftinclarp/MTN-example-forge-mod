package com.mtn.example;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class MyBlock extends Block {

    public MyBlock() {
        super("myblock");
        setCreativeTab(CreativeTabs.TAB_BLOCKS);
    }

    public MyBlock setCreativeTab(CreativeTabs tab) {
        return this;
    }
}

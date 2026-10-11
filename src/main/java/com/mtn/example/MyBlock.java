package com.mtn.example;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MyBlock extends Block {

    public MyBlock() {
        super(Material.rock);
        setBlockName("myblock");
        setBlockTextureName("mtnexample:myblock");
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(1.5F);
        setResistance(10.0F);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 1);
    }
}

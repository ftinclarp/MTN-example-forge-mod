package com.mtn.example;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("MTN-EXAMPLE preInit");
        GameRegistry.registerBlock(ExampleMod.MY_BLOCK, "myblock");
        GameRegistry.registerItem(ExampleMod.MY_ITEM, "myitem");
    }

    public void init(FMLInitializationEvent event) {
        System.out.println("MTN-EXAMPLE init");
    }

    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("MTN-EXAMPLE postInit");
    }
}

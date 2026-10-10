package com.mtn.example;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("MTN-EXAMPLE preInit");
    }

    public void init(FMLInitializationEvent event) {
        System.out.println("MTN-EXAMPLE init");
    }

    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("MTN-EXAMPLE postInit");
    }
}

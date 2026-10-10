package com.mtn.example;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "mtnexample", name = "MTN Example", version = "1.0")
public class ExampleMod {

    public ExampleMod() {
        System.out.println("MTN-EXAMPLE ExampleMod.<init>");
    }

    @SidedProxy(clientSide = "com.mtn.example.ClientProxy", serverSide = "com.mtn.example.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("MTN-EXAMPLE ExampleMod.preInit");
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("MTN-EXAMPLE ExampleMod.init");
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("MTN-EXAMPLE ExampleMod.postInit");
        proxy.postInit(event);
    }
}

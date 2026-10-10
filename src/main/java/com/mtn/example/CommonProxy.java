package com.mtn.example;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("MTN-EXAMPLE preInit");
        GameRegistry.registerBlock(ExampleMod.MY_BLOCK, "myblock");
        GameRegistry.registerItem(ExampleMod.MY_ITEM, "myitem");
        GameRegistry.registerTileEntity(MyChest.class, "mychest");

        // R3a: register a test message (network smoke test). Do NOT send yet.
        ExampleMod.NETWORK.registerMessage((msg, ctx) -> {
            System.out.println("MTN-EXAMPLE received packet: " + msg.getText());
            return null;
        }, MyTestMessage.class, 0, Side.CLIENT);

        ExampleMod.exerciseNbt();
        ExampleMod.exerciseChest();
    }

    public void init(FMLInitializationEvent event) {
        System.out.println("MTN-EXAMPLE init");
    }

    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("MTN-EXAMPLE postInit");
    }
}

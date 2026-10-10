package com.mtn.example;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

@Mod(modid = "mtnexample", name = "MTN Example", version = "1.0")
public class ExampleMod {

    public static final MyBlock MY_BLOCK = new MyBlock();
    public static final MyItem MY_ITEM = new MyItem();

    /** R3a: the mod's simple network channel (messages registered in CommonProxy.preInit). */
    public static final cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper NETWORK =
            cpw.mods.fml.common.network.NetworkRegistry.INSTANCE.newSimpleChannel("mtnexample");

    public ExampleMod() {
        System.out.println("MTN-EXAMPLE ExampleMod.<init>");
    }

    /** Exercises the layer's NBT + ItemStack + Blocks/Items API. */
    public static void exerciseNbt() {
        ItemStack stack = new ItemStack(ExampleMod.MY_ITEM, 42);
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("owner", "MTN");
        tag.setInteger("tier", 3);
        stack.setTagCompound(tag);

        System.out.println("MTN-EXAMPLE stack=" + stack);
        System.out.println("MTN-EXAMPLE tag.owner=" + tag.getString("owner"));
        System.out.println("MTN-EXAMPLE tag.tier=" + tag.getInteger("tier"));
        System.out.println("MTN-EXAMPLE blocks.air=" + Blocks.air.getUnlocalizedName());
    }

    /** Exercises the layer's TileEntity + IInventory API via a chest. */
    public static void exerciseChest() {
        MyChest chest = new MyChest();
        chest.setInventorySlotContents(0, new ItemStack(MY_ITEM, 7));
        System.out.println("MTN-EXAMPLE chest.slot0="
                + chest.getStackInSlot(0).getCount());
        System.out.println("MTN-EXAMPLE chest.size="
                + chest.getSizeInventory());
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

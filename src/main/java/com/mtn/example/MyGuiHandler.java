package com.mtn.example;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.World;

/**
 * R3b GUI handler. Server side returns the {@link MyChestContainer};
 * client side returns a {@link net.minecraft.client.gui.inventory.GuiChest}.
 */
public class MyGuiHandler implements IGuiHandler {

    public static final MyGuiHandler INSTANCE = new MyGuiHandler();

    private MyGuiHandler() {
    }

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
            int x, int y, int z) {
        System.out.println("MTN-EXAMPLE getServerGuiElement id=" + id + " at " + x + "," + y + "," + z);
        IInventory chest = (IInventory) world.getTileEntity(x, y, z);
        System.out.println("MTN-EXAMPLE getServerGuiElement chest=" + chest);
        return new MyChestContainer(player.inventory, chest);
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
            int x, int y, int z) {
        System.out.println("MTN-EXAMPLE getClientGuiElement id=" + id + " at " + x + "," + y + "," + z);
        IInventory chest = (IInventory) world.getTileEntity(x, y, z);
        System.out.println("MTN-EXAMPLE getClientGuiElement chest=" + chest);
        return new net.minecraft.client.gui.inventory.GuiChest(player.inventory, chest);
    }

    public static void open(EntityPlayer player, int id, World world,
            int x, int y, int z) {
        player.openGui("mtnexample", id, world, x, y, z);
    }
}

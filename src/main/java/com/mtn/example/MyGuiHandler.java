package com.mtn.example;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.World;

/**
 * R3b GUI handler. The layer opens the {@code FabricHandledScreen} itself, so
 * {@code getClientGuiElement} returns {@code null}.
 */
public class MyGuiHandler implements IGuiHandler {

    public static final MyGuiHandler INSTANCE = new MyGuiHandler();

    private MyGuiHandler() {
    }

    @Override
    public Object getServerGuiElement(int id, Object player, Object world,
            int x, int y, int z) {
        IInventory chest = (IInventory) ((World) world).getBlockTileEntity(x, y, z);
        return new MyChestContainer(((EntityPlayer) player).inventory, chest);
    }

    @Override
    public Object getClientGuiElement(int id, Object player, Object world,
            int x, int y, int z) {
        // The layer opens the FabricHandledScreen itself.
        return null;
    }

    public static void open(EntityPlayer player, int id, World world,
            int x, int y, int z) {
        NetworkRegistry.INSTANCE.openGui(ExampleMod.class, id, player, world, x, y, z);
    }
}

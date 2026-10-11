package com.mtn.example;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryPlayer;
import net.minecraft.inventory.Slot;

/**
 * R3b container: 3x3 chest slots + 27 player slots + 9 hotbar slots.
 * Mirrors the classic Forge-1.7.10 chest layout.
 */
public class MyChestContainer extends Container {

    public MyChestContainer(InventoryPlayer player, IInventory chest) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                addSlotToContainer(new Slot(chest, row * 3 + col, 8 + col * 18, 18 + row * 18));
            }
        }
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlotToContainer(new Slot(player, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
        for (int col = 0; col < 9; col++) {
            addSlotToContainer(new Slot(player, col, 8 + col * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }
}

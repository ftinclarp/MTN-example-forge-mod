package com.mtn.example;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

/**
 * Standard vanilla-style container: 27 chest slots (3x9) + 27 player
 * slots + 9 hotbar slots, laid out exactly like the vanilla chest GUI.
 */
public class MyChestContainer extends Container {

    public MyChestContainer(InventoryPlayer player, IInventory chest) {
        // chest: 3 rows of 9, starting at y = 18
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlotToContainer(new Slot(chest, col + row * 9,
                        8 + col * 18, 18 + row * 18));
            }
        }
        // player inventory: 3 rows of 9, starting at y = 84
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlotToContainer(new Slot(player, col + row * 9 + 9,
                        8 + col * 18, 84 + row * 18));
            }
        }
        // hotbar: 1 row of 9, starting at y = 142
        for (int col = 0; col < 9; col++) {
            addSlotToContainer(new Slot(player, col, 8 + col * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }
}

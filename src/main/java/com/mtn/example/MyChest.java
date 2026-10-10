package com.mtn.example;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class MyChest extends TileEntity implements IInventory {

    private ItemStack[] slots = new ItemStack[9];
    private String customName = "My Chest";

    @Override
    public int getSizeInventory() { return slots.length; }

    @Override
    public ItemStack getStackInSlot(int i) { return slots[i]; }

    @Override
    public ItemStack decrStackSize(int i, int count) {
        if (slots[i] == null) return null;
        ItemStack s = slots[i];
        if (s.getCount() <= count) { slots[i] = null; return s; }
        ItemStack split = s.copy();
        split.setCount(count);
        s.setCount(s.getCount() - count);
        return split;
    }

    @Override public ItemStack getStackInSlotOnClosing(int i) { return null; }
    @Override public void setInventorySlotContents(int i, ItemStack s) { slots[i] = s; }
    @Override public String getInventoryName() { return customName; }
    @Override public boolean hasCustomInventoryName() { return true; }
    @Override public int getInventoryStackLimit() { return 64; }
    @Override public boolean isUseableByPlayer(EntityPlayer p) { return true; }
    @Override public void openInventory() {}
    @Override public void closeInventory() {}
    @Override public boolean isItemValidForSlot(int i, ItemStack s) { return true; }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList list = nbt.getTagList("Items", 10);
        for (int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound entry = list.getCompoundTagAt(i);
            int slot = entry.getInteger("Slot");
            int count = entry.getInteger("Count");
            slots[slot] = new ItemStack(ExampleMod.MY_ITEM, count);
        }
        customName = nbt.getString("CustomName");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        NBTTagList list = new NBTTagList();
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null) continue;
            NBTTagCompound entry = new NBTTagCompound();
            entry.setInteger("Slot", i);
            entry.setInteger("Count", slots[i].getCount());
            list.appendTag(entry);
        }
        nbt.setTag("Items", list);
        nbt.setString("CustomName", customName);
    }
}

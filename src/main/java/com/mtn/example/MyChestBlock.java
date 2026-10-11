package com.mtn.example;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * R3b chest block. Extends {@link BlockContainer} so it owns a
 * {@link MyChest} tile entity. Right-click opens the GUI on the server only.
 */
public class MyChestBlock extends BlockContainer {

    public MyChestBlock() {
        super(Material.wood);
        setBlockName("mychest_block");
        setBlockTextureName("mtnexample:mychest_block");
        setHardness(2.5F);
        setResistance(2.5F);
        setStepSound(Block.soundTypeWood);
        setHarvestLevel("axe", 0);
    }

    public TileEntity createNewTileEntity(World world, int meta) {
        return new MyChest();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        System.out.println("MTN-EXAMPLE MyChestBlock.onBlockActivated isRemote=" + world.isRemote);
        if (world.isRemote) {
            return true; // server opens the GUI; client just consumes.
        }
        MyGuiHandler.open(player, 0, world, x, y, z);
        return true;
    }
}

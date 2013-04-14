package jgdovin.voidsatchel.items.container;

import jgdovin.voidsatchel.items.InventoryVoidSatchel;
import jgdovin.voidsatchel.utils.Archive;
import jgdovin.voidsatchel.utils.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerVoidSatchel extends Container {

    private final int BAG_START_X = 8, BAG_START_Y = 18;

    private int startX = BAG_START_X, startY = BAG_START_Y;

    private int rows = 3, cols = 13;
    private InventoryVoidSatchel inv;
    private IInventory plInv, chestInv = null;
    private World theWorld;

    public ContainerVoidSatchel(ItemStack stack, EntityPlayer ep) {

        inv = new InventoryVoidSatchel(stack);
        plInv = ep.inventory;
        theWorld = ep.worldObj;

       addPlayerInventory(ep.inventory, 102);
       addInventory(inv,8,18);
    }

    private void addInventory(IInventory in, int x, int y) {
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                addSlotToContainer(new Slot(in, c + r * cols, x + c * 18, y + r
                        * 18));
    }

    private void addPlayerInventory(InventoryPlayer ip, int ystart) {
        // Add the player's action bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < 9; ++actionBarSlotIndex) {
            this.addSlotToContainer(new Slot(ip, actionBarSlotIndex, 8
                    + actionBarSlotIndex * 18, 58 + ystart));
        }

        // Add the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < 3; ++inventoryRowIndex) {
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < 9; ++inventoryColumnIndex) {
                this.addSlotToContainer(new Slot(ip, inventoryColumnIndex
                        + inventoryRowIndex * 9 + 9, 8
                        + inventoryColumnIndex * 18, ystart + inventoryRowIndex
                        * 18));
            }
        }
    }

 
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    @Override
    public void onCraftGuiClosed(EntityPlayer player) {

        super.onCraftGuiClosed(player);

        if (!player.worldObj.isRemote) {
            InventoryPlayer invPlayer = player.inventory;
            for (ItemStack itemStack : invPlayer.mainInventory) {
                if (itemStack != null) {
                    if (NBTHelper.hasTag(itemStack,
                            Archive.NBT_ITEM_VOID_SATCHEL_GUI_OPEN)) {
                        NBTHelper.removeTag(itemStack,
                                Archive.NBT_ITEM_VOID_SATCHEL_GUI_OPEN);
                    }
                }
            }
        }
    }
}
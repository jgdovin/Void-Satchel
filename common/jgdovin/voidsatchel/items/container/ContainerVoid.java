package jgdovin.voidsatchel.items.container;

import jgdovin.voidsatchel.utils.Archive;
import jgdovin.voidsatchel.utils.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerVoid extends Container {

    public ContainerVoid(InventoryPlayer inventoryPlayer) {

        // Add the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < 3; ++inventoryRowIndex){
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < 9; ++inventoryColumnIndex){
                this.addSlotToContainer(new Slot(inventoryPlayer, inventoryColumnIndex
                        + (inventoryRowIndex * 9) + 9, 44 + (inventoryColumnIndex * 18),
                        104 + (inventoryRowIndex * 18)));
            }
        }

        // Add the player's action bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < 9; ++actionBarSlotIndex){
            this.addSlotToContainer(new Slot(inventoryPlayer, actionBarSlotIndex,
                    44 + (actionBarSlotIndex * 18), 162));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    @Override
    public void onCraftGuiClosed(EntityPlayer player) {

        super.onCraftGuiClosed(player);

        if (!player.worldObj.isRemote){
            InventoryPlayer invPlayer = player.inventory;
            for (ItemStack itemStack : invPlayer.mainInventory){
                if (itemStack != null){
                    if (NBTHelper.hasTag(itemStack, Archive.NBT_ITEM_VOID_SATCHEL_GUI_OPEN)){
                        NBTHelper.removeTag(itemStack, Archive.NBT_ITEM_VOID_SATCHEL_GUI_OPEN);
                    }
                }
            }
        }
    }
}
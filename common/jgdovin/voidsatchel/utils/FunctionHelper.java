package jgdovin.voidsatchel.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class FunctionHelper {

    public static ItemStack getCurrentBag(EntityPlayer player) {
        if (player != null){
            for (ItemStack itemStack : player.inventory.mainInventory){
                if (itemStack != null){
                    if (NBTHelper.hasTag(itemStack, Archive.NBT_ITEM_VOID_SATCHEL_GUI_OPEN)){
                        return itemStack;
                    }
                }
            }
        }
        return null;
    }
}

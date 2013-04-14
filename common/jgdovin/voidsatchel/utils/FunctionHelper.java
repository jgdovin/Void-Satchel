package jgdovin.voidsatchel.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class FunctionHelper {
    
    private static final String slot = "slot";
    
    /**
     * Reads a Inventory from a NBTTagList.
     * 
     * @param list
     *            The Name of the NBTTagList to read from.
     * @param size
     *            The size of the Inventory.
     * @return The Items on the inventory.
     */
    public static ItemStack[] readInventoryFromNBT(NBTTagList list, int size) {
        ItemStack[] stacks = new ItemStack[size];

        NBTTagCompound compound;
        int index;
        for (int i = 0; i < list.tagCount(); i++){
            compound = (NBTTagCompound) list.tagAt(i);
            index = compound.getInteger(slot);
            stacks[index] = ItemStack.loadItemStackFromNBT(compound);
        }

        return stacks;
    }

    /**
     * Writes a inventory to a NBTTagList.
     * 
     * @param stacks
     *            The stacks in the current inventory to add to the NBTTagList.
     * @return The NBTTagList associated to the inventory.
     */
    public static NBTTagList writeInventoryToNBT(ItemStack[] stacks) {
        NBTTagCompound stackNBT;
        NBTTagList list = new NBTTagList();
        for (int i = 0; i < stacks.length; i++){
            if (stacks[i] == null){
                continue;
            }

            stackNBT = new NBTTagCompound();
            stackNBT.setInteger(slot, i);
            stacks[i].writeToNBT(stackNBT);
            list.appendTag(stackNBT);
        }

        return list;
    }
}

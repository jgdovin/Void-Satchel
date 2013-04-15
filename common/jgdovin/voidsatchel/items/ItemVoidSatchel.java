package jgdovin.voidsatchel.items;

import jgdovin.voidsatchel.VoidSatchel;
import jgdovin.voidsatchel.utils.Archive;
import jgdovin.voidsatchel.utils.NBTHelper;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemVoidSatchel extends Item {

    private String customName;

    public ItemVoidSatchel(int id) {
        super(id);
        setCreativeTab(CreativeTabs.tabTools);
    }

    @Override
    public boolean getShareTag() {

        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {

        if (itemStack.hasDisplayName()){
            this.setCustomName(itemStack.getDisplayName());
        }
        NBTHelper.setBoolean(itemStack, Archive.NBT_ITEM_VOID_SATCHEL_GUI_OPEN, true);
        entityPlayer.openGui(VoidSatchel.instance, Archive.voidSatchelGUID, entityPlayer.worldObj,
                (int) entityPlayer.posX, (int) entityPlayer.posY, (int) entityPlayer.posZ);

        return itemStack;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public boolean hasCustomName() {
        return (customName != null) && (customName.length() > 0);
    }

    public String getCustomName() {
        return this.hasCustomName() ? customName : Archive.containerVoidSatchel;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(Archive.texture
                + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}
package jgdovin.voidsatchel.utils.handler;

import jgdovin.voidsatchel.items.ItemVoidSatchel;
import jgdovin.voidsatchel.items.container.ContainerVoid;
import jgdovin.voidsatchel.items.gui.GUIVoid;
import jgdovin.voidsatchel.utils.Archive;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case Archive.voidSatchelGUID:
                return new ContainerVoid(player.inventory);
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case Archive.voidSatchelGUID:
                ItemVoidSatchel itemVS = (ItemVoidSatchel) player.getCurrentEquippedItem()
                        .getItem();
                return new GUIVoid(player.inventory, itemVS);
            default:
                return null;
        }
    }
}
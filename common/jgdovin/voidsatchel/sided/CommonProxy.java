package jgdovin.voidsatchel.sided;

import jgdovin.voidsatchel.items.container.ContainerVoidSatchel;
import jgdovin.voidsatchel.items.gui.GUIVoid;
import jgdovin.voidsatchel.utils.Archive;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        switch (ID) {
            case Archive.voidSatchelGUID:
                return new ContainerVoidSatchel(
                        player.getCurrentEquippedItem(), player);
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        switch (ID) {
            case Archive.voidSatchelGUID:
                return new GUIVoid(player.getCurrentEquippedItem(), player);
            default:
                return null;
        }
    }
}
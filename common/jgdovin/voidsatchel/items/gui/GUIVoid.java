package jgdovin.voidsatchel.items.gui;

import jgdovin.voidsatchel.items.ItemVoidSatchel;
import jgdovin.voidsatchel.items.container.ContainerVoid;
import jgdovin.voidsatchel.utils.Archive;
import jgdovin.voidsatchel.utils.NBTHelper;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GUIVoid extends GuiContainer {

    private ItemVoidSatchel itemVoid;

    public GUIVoid(InventoryPlayer inventoryPlayer, ItemVoidSatchel itemVoid) {

        super(new ContainerVoid(inventoryPlayer));
        this.itemVoid = itemVoid;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        fontRenderer.drawString(StatCollector.translateToLocal(itemVoid.hasCustomName() ? itemVoid
                .getCustomName() : itemVoid.getCustomName()), 8, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal(Archive.CONTAINER_INVENTORY), 44,
                (ySize - 96) + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(Archive.guiVoid);
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }

    @Override
    public void onGuiClosed() {

        super.onGuiClosed();

        if (mc.thePlayer != null){
            for (ItemStack itemStack : mc.thePlayer.inventory.mainInventory){
                if (itemStack != null){
                    if (NBTHelper.hasTag(itemStack, Archive.NBT_ITEM_VOID_SATCHEL_GUI_OPEN)){
                        NBTHelper.removeTag(itemStack, Archive.NBT_ITEM_VOID_SATCHEL_GUI_OPEN);
                    }
                }
            }
        }
    }
}
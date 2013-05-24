package jgdovin.voidsatchel.items.gui;

import jgdovin.voidsatchel.items.ItemVoidSatchel;
import jgdovin.voidsatchel.items.container.ContainerVoidSatchel;
import jgdovin.voidsatchel.utils.Archive;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GUIVoid extends GuiContainer {

    private ItemVoidSatchel itemVoid;

    public GUIVoid(ItemStack stack, EntityPlayer player) {

        super(new ContainerVoidSatchel(stack, player));
        this.itemVoid = (ItemVoidSatchel) stack.getItem();
        xSize = 180;
        ySize = 185;
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        fontRenderer.drawString(StatCollector.translateToLocal(itemVoid.getCustomName()), 10, 6,
                0xffffff, false);
        fontRenderer.drawString(StatCollector.translateToLocal("Items to Destroy"), 11,
                (ySize - 112) + 2, 0xffffff, false);
        fontRenderer.drawString(StatCollector.translateToLocal(Archive.CONTAINER_INVENTORY), 15,
                (ySize - 98) + 2, 0xffffff, false);
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
    }
}
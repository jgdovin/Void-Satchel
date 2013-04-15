package jgdovin.voidsatchel.items.gui;

import jgdovin.voidsatchel.items.ItemVoidSatchel;
import jgdovin.voidsatchel.items.container.ContainerVoidSatchel;
import jgdovin.voidsatchel.utils.Archive;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GUIVoid extends GuiContainer {

    private ItemVoidSatchel itemVoid;
    private EntityPlayer voidPlayer;
    private ItemStack itemStack;

    public GUIVoid(ItemStack stack, EntityPlayer player) {

        super(new ContainerVoidSatchel(stack, player));
        this.itemVoid = (ItemVoidSatchel) stack.getItem();
        this.voidPlayer = player;
        this.itemStack = stack;
        xSize = 180;
        ySize = 185;

    }

    @Override
    public void initGui() {
        super.initGui();
        int x = (width - xSize) / 2, y = (height - ySize) / 2;
        int bw = xSize - 22;

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        fontRenderer.drawString("\u00a7f" + StatCollector.translateToLocal(itemVoid
                .hasCustomName() ? itemVoid.getCustomName() : itemVoid
                .getCustomName()), 8, 6, 4210752);
        fontRenderer.drawString(
                "\u00a7f" + StatCollector.translateToLocal(Archive.CONTAINER_INVENTORY), 15,
                (ySize - 98) + 2, 4210752);
        fontRenderer.drawStringWithShadow(
                StatCollector.translateToLocal("\u00a76Items to Destroy"), 11,
                (ySize - 112) + 2, 4210752);
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

    protected void actionPerformed(GuiButton guibutton) {
        // id is the id you give your button

    }
    // Packet code here
    // PacketDispatcher.sendPacketToServer(packet); //send packet
}

package jgdovin.voidsatchel.utils;

import jgdovin.voidsatchel.VoidSatchel;
import jgdovin.voidsatchel.items.ModItems;
import jgdovin.voidsatchel.utils.handler.GUIHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Registry {

    private static GUIHandler handeler = new GUIHandler();

    public static void register() {
        // Registers the GUI Handler
        NetworkRegistry.instance().registerGuiHandler(VoidSatchel.instance, handeler);

        registerItems();
    }

    /**
     * Registers all the Items.
     */
    private static void registerItems() {

        GameRegistry.registerItem(ModItems.voidSatchel, Archive.voidSatchel);
    }
}
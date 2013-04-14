package jgdovin.voidsatchel.utils;

import jgdovin.voidsatchel.VoidSatchel;
import jgdovin.voidsatchel.items.ModItems;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Registry {

    public static void register() {
        // Registers the GUI Handler
        NetworkRegistry.instance().registerGuiHandler(VoidSatchel.instance, VoidSatchel.baseProxy);

        registerItems();
    }

    /**
     * Registers all the Items.
     */
    private static void registerItems() {

        GameRegistry.registerItem(ModItems.voidSatchel, Archive.voidSatchel);
    }
}
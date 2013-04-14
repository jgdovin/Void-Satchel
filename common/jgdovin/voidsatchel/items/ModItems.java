package jgdovin.voidsatchel.items;

import jgdovin.voidsatchel.utils.Archive;
import jgdovin.voidsatchel.utils.Config;
import net.minecraft.item.Item;

public class ModItems {

    public static Item voidSatchel;

    public static void init() {
        voidSatchel = new ItemVoidSatchel(Config.voidSatchelID)
                .setUnlocalizedName(Archive.voidSatchel).setMaxStackSize(1).setNoRepair();
    }
}
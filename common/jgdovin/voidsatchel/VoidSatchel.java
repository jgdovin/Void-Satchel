package jgdovin.voidsatchel;

import jgdovin.voidsatchel.items.ModItems;
import jgdovin.voidsatchel.utils.Archive;
import jgdovin.voidsatchel.utils.Config;
import jgdovin.voidsatchel.utils.Registry;
import jgdovin.voidsatchel.utils.handler.LanguageHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Archive.id, name = Archive.name, version = Archive.ver)
public class VoidSatchel {

    @Instance(Archive.id)
    public static VoidSatchel instance;

    @PreInit
    public void preInit(FMLPreInitializationEvent evt) {

        Config.init(evt);

        ModItems.init();

        LanguageHandler.loadLanguages();
    }

    @Init
    public void init(FMLInitializationEvent event) {

        Registry.register();
    }
}
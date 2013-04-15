package jgdovin.voidsatchel;

import jgdovin.voidsatchel.items.ModItems;
import jgdovin.voidsatchel.sided.CommonProxy;
import jgdovin.voidsatchel.utils.Archive;
import jgdovin.voidsatchel.utils.Config;
import jgdovin.voidsatchel.utils.Registry;
import jgdovin.voidsatchel.utils.handler.LanguageHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Archive.id, name = Archive.name, version = Archive.ver)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class VoidSatchel {

    @Instance(Archive.id)
    public static VoidSatchel instance;

    @SidedProxy(clientSide = Archive.clientProxy, serverSide = Archive.commonProxy)
    public static CommonProxy baseProxy;

    @PreInit
    public void preInit(FMLPreInitializationEvent evt) {

        Config.init(evt);

        ModItems.init();

        LanguageHandler.loadLanguages();
    }

    @Init
    public void init(FMLInitializationEvent event) {

        Registry.register();

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.voidSatchel), new Object[] { "SSS",
                "ELE", "SSS", 'L', Item.bucketLava, 'S', Item.silk, 'E', Item.enderPearl });
    }
}
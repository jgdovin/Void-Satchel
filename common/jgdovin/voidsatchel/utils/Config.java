package jgdovin.voidsatchel.utils;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {

    // ID for the Void Satchel
    public static int voidSatchelID;

    public static void init(FMLPreInitializationEvent event) {

        File configFile = new File(event.getModConfigurationDirectory(), Archive.name + ".cfg");

        Configuration configuration = new Configuration(configFile);

        try{
            configuration.load();

            voidSatchelID = configuration.getItem(Archive.voidSatchel + " Item", 9000,
                    Archive.voidSatchel + " Item Id:").getInt();

        }catch(Exception e){
            FMLLog.log(Level.SEVERE, e, Archive.name
                    + " has had a problem loading its configuration");
        }finally{
            configuration.save();
        }
    }
}
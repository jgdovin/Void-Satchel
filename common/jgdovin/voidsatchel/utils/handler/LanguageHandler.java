package jgdovin.voidsatchel.utils.handler;

import jgdovin.voidsatchel.utils.Archive;
import jgdovin.voidsatchel.utils.LanguageHelper;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LanguageHandler {

    public static void loadLanguages() {

        for (String localizationFile : Archive.langFiles){
            LanguageRegistry.instance().loadLocalization(localizationFile,
                    LanguageHelper.getLocaleFromFileName(localizationFile),
                    LanguageHelper.isXMLLanguageFile(localizationFile));
        }
    }
}
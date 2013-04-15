package jgdovin.voidsatchel.utils;

public class Archive {

    /*
     * ******************************************************************
     * Mod
     * ******************************************************************
     */
    public static final String id = "voidsatchel";
    public static final String name = "Void Satchel";
    public static final String ver = "@VERSION@";

    /*
     * ******************************************************************
     * Locations
     * ******************************************************************
     */
    public static final String texture = id + ":";
    public static final String gui = "/mods/" + id + "/textures/gui/";
    public static final String lang = "/mods/" + id + "/lang/";
    public static final String guiVoid = gui + "guiVoid.png";
    public static final String proxy = "jgdovin." + id + ".sided.";
    public static final String clientProxy = proxy + "ClientProxy";
    public static final String commonProxy = proxy + "CommonProxy";

    /*
     * ******************************************************************
     * Void Satchel
     * ******************************************************************
     */
    public static final String voidSatchel = "voidBag";
    public static final String containerVoidSatchel = "container." + voidSatchel;
    public static final int voidSatchelGUID = 0;

    /*
     * ******************************************************************
     * NBT and GUI related things
     * ******************************************************************
     */
    public static final String NBT_ITEM_VOID_SATCHEL_GUI_OPEN = "itemVoidBagGuiOpen";
    public static final String CONTAINER_INVENTORY = "container.inventory";

    /*
     * ******************************************************************
     * Languages
     * ******************************************************************
     */
    public static String[] langFiles = {
            // US local
            lang + "en_US.xml",
            // ES Local
            lang + "es_ES.xml" };
}
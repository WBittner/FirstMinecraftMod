package com.bittner.myfirstmod;

import com.bittner.myfirstmod.handler.ConfigurationHandler;
import com.bittner.myfirstmod.proxy.IProxy;
import com.bittner.myfirstmod.reference.Reference;
import com.bittner.myfirstmod.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by William on 5/18/2015.
 */

//click on mod, ctrl + b to step into mod to add more
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class MyFirstMod
{
    //takes an argument - mod ID
    //use to reference own mod reliably - know no one else tampered with - "safe" instance
    @Mod.Instance(Reference.MOD_ID)
    public static MyFirstMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    //subscribe to the event handler
    //every mod is in the same event phase at the same time - no mod will be in post before all have finished init
    //arg to method says that this must happen during PRE init phase
    @Mod.EventHandler
    /* Pre init things to handle:
        Network Handling
        Mod Configuration
        Initialize items/blocks
     */
    public void preInit(FMLPreInitializationEvent event)
    {
        //Given suggested file name from event
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        //Tell FML that this class is listening to things on the bus
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        LogHelper.info("Pre Initialization Complete!");
    }

    /* Init things to handle:
        Register GUI, tile entities, crafting recipes
        General event handler things
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

        LogHelper.info("Initialization Complete!");
    }

    /* Post handling:'
        Wrap up
     */
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete!");
    }
}



package com.example.examplemod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";

    /** Объект-экземпляр мода */
    @Mod.Instance(MODID)
    public static ExampleMod instance = new ExampleMod();

    @SidedProxy(clientSide = "com.example.examplemod.ClientProxy", serverSide = "com.example.examplemod.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        //event.registerServerCommand(new Command());
    }
}

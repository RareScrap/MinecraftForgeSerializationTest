package com.example.examplemod;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {
    /** Обертка для работы с сетью */
    public static final SimpleNetworkWrapper INSTANCE =
            NetworkRegistry.INSTANCE.newSimpleChannel(ExampleMod.MODID.toLowerCase());

    public void init(FMLInitializationEvent event) {
        INSTANCE.registerMessage(PacketToServer.MessageHandler.class,
                PacketToServer.class, 0, Side.SERVER); // Регистрация сообщения
    }
}

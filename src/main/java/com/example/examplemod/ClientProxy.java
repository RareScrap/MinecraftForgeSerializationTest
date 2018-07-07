package com.example.examplemod;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.client.ClientCommandHandler;

public class ClientProxy extends CommonProxy {
    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        ClientCommandHandler.instance.registerCommand(new Command());
    }
}

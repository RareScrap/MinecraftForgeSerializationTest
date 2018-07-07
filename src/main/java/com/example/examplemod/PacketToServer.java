package com.example.examplemod;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.ChatComponentText;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PacketToServer implements IMessage {
    DiceRoll diceRoll;

    /**
     * Необходимый пустой публичный конструктор
     */
    public PacketToServer() {}

    /**
     * Необходимый пустой публичный конструктор
     */
    public PacketToServer(DiceRoll diceRoll) {
        this.diceRoll = diceRoll;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        try {
            ByteInputStream bis = new ByteInputStream(buf.array(), buf.arrayOffset(), buf.array().length);
            ObjectInputStream ois = new ObjectInputStream(bis);
            diceRoll = (DiceRoll) ois.readObject();
            ois.close();
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        try {
            ByteOutputStream bos = new ByteOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(diceRoll);
            oos.flush();
            buf.writeBytes(bos.getBytes());
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class MessageHandler implements IMessageHandler<PacketToServer, IMessage> {

        @Override
        public IMessage onMessage(PacketToServer message, MessageContext ctx) {
            FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().sendChatMsg(new ChatComponentText(message.diceRoll.roll(false)));
            return null;
        }
    }
}

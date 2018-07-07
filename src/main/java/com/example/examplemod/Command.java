package com.example.examplemod;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import java.util.List;

public class Command implements ICommand {
    @Override
    public String getCommandName() {
        return "com";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return null;
    }

    @Override
    public List getCommandAliases() {
        return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] p_71515_2_) {
        World world = sender.getEntityWorld();

        if (world.isRemote)  {
            System.out.println("asd");
            CommonProxy.INSTANCE.sendToServer(new PacketToServer(
                    new DiceRoll("TestPlayer", "rollName", 5)
            ));
            return;
        }

        sender.addChatMessage(new ChatComponentText("ERROR"));
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

package com.pogmod.event;

import com.pogmod.command.HelloCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "pogmod")
public class ModEvent {
    @SubscribeEvent
    public static void serverStarting(final RegisterCommandsEvent event){

        HelloCommand.register(event.getDispatcher());

    }
}

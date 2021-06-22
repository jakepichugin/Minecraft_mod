package com.pogmod.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;

public class HelloCommand {

    public static void register(CommandDispatcher<CommandSource> dispatcher) {

    }

    private static int hello(CommandSource source, PlayerEntity player) {
        source.sendSuccess(new TranslationTextComponent("commands.hello", player.getDisplayName()), true);
        return 1;
    }



}

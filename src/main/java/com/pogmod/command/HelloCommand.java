package com.pogmod.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;

public class HelloCommand {

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("hello").executes(source -> {
            return hello(source.getSource(), source.getSource().getPlayerOrException());

        }).then(Commands.argument("target", EntityArgument.player()).executes(source -> {
            return hello(source.getSource(), EntityArgument.getPlayer(source,"target"));
        })));

    }

    private static int hello(CommandSource source, PlayerEntity player) {
        source.sendSuccess(new TranslationTextComponent("Hello I am cool, get netherite armor or you will make a dirt hut HAAHAHAHA", player.getDisplayName()), true);
        return 1;
    }



}

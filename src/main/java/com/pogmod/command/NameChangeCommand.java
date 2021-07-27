package com.pogmod.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;

public class NameChangeCommand {

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("hello").executes(source -> {
            return namechange(source.getSource(), source.getSource().getPlayerOrException());

        }).then(Commands.argument("target", EntityArgument.player()).executes(source -> {
            return namechange(source.getSource(), EntityArgument.getPlayer(source,"target"));
        })));

    }

    private static int namechange(CommandSource source, PlayerEntity player) {
        source.sendSuccess(new TranslationTextComponent("", player.getDisplayName()), true);
        return 1;

    }

}

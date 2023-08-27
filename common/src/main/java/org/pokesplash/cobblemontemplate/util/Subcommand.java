package org.pokesplash.cobblemontemplate.util;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;

/**
 * Class used to create subcommands.
 */
public abstract class Subcommand {

	// The usage message, as a String.
	private String usage;

	/**
	 * Constructor to create a new subcommand and generate a usage string.
	 * @param usageString
	 */
	public Subcommand(String usageString) {
		usage = usageString;
	}

	/**
	 * Method to send the usage string to the player.
	 * @param context The source of the command
	 * @return integer to complete command.
	 */
	public int showUsage(CommandContext<CommandSourceStack> context) {
		context.getSource().sendSystemMessage(Component.literal(Utils.formatMessage(usage, context.getSource().isPlayer())));
		return 1;
	}

	/**
	 * Method to override to create the command.
	 * @return
	 */
	public abstract LiteralCommandNode<CommandSourceStack> build();

	/**
	 * Method to override where the logic of the command goes.
	 * @param context The source of the command.
	 * @return Integer to complete the command.
	 */
	public abstract int run(CommandContext<CommandSourceStack> context);
}

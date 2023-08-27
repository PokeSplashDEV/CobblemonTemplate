package org.pokesplash.cobblemontemplate;

import dev.architectury.event.events.common.CommandRegistrationEvent;
import org.pokesplash.cobblemontemplate.command.basecommand.ExampleCommand;
import org.pokesplash.cobblemontemplate.util.CommandsRegistry;
import org.pokesplash.cobblemontemplate.util.Permissions;

public class CobblemonTemplate
{
	public static final String MOD_ID = "cobblemontemplate";

	public static final Permissions permissions = new Permissions();

	public static void init() {
		CommandsRegistry.addCommand(new ExampleCommand());
		CommandRegistrationEvent.EVENT.register(CommandsRegistry::registerCommands);
	}
}

package org.pokesplash.cobblemontemplate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pokesplash.cobblemontemplate.command.basecommand.ExampleCommand;
import org.pokesplash.cobblemontemplate.util.CommandsRegistry;
import org.pokesplash.cobblemontemplate.util.Permissions;

public class CobblemonTemplate
{
	public static final String MOD_ID = "cobblemontemplate";
	public static final Permissions permissions = new Permissions();
	public static final Logger LOGGER = LogManager.getLogger();

	public static void init() {
		// Adds command to registry
		CommandsRegistry.addCommand(new ExampleCommand());
	}
}

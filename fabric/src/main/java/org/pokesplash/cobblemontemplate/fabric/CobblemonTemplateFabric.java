package org.pokesplash.cobblemontemplate.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.pokesplash.cobblemontemplate.CobblemonTemplate;
import org.pokesplash.cobblemontemplate.util.CommandsRegistry;

public class CobblemonTemplateFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CobblemonTemplate.init();
        CommandRegistrationCallback.EVENT.register(CommandsRegistry::registerCommands);
    }
}
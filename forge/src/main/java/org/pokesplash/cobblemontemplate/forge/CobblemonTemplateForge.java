package org.pokesplash.cobblemontemplate.forge;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.pokesplash.cobblemontemplate.CobblemonTemplate;
import org.pokesplash.cobblemontemplate.util.CommandsRegistry;

@Mod(CobblemonTemplate.MOD_ID)
public class CobblemonTemplateForge {
    public CobblemonTemplateForge() {
        CobblemonTemplate.init();
    }

    @SubscribeEvent
    public void registerCommands(RegisterCommandsEvent e) {
        CommandsRegistry.registerCommands(e.getDispatcher());
    }
}
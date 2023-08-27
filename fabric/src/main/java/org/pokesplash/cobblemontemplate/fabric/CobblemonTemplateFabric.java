package org.pokesplash.cobblemontemplate.fabric;

import net.fabricmc.api.ModInitializer;
import org.pokesplash.cobblemontemplate.CobblemonTemplate;

public class CobblemonTemplateFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CobblemonTemplate.init();
    }
}
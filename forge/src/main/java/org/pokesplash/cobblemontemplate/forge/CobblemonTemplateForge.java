package org.pokesplash.cobblemontemplate.forge;

import net.minecraftforge.fml.common.Mod;
import org.pokesplash.cobblemontemplate.CobblemonTemplate;

@Mod(CobblemonTemplate.MOD_ID)
public class CobblemonTemplateForge {
    public CobblemonTemplateForge() {
        CobblemonTemplate.init();
    }
}
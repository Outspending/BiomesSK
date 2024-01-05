package me.outspending.biomessk;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import me.outspending.biomesapi.biome.CustomBiome;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.logging.Logger;

public final class BiomesSK extends JavaPlugin {

    public static CustomBiome lastCreatedBiome;

    private static JavaPlugin instance;
    private static SkriptAddon addon;

    @Override
    public void onEnable() {
        Logger logger = getLogger();
        instance = this;
        addon = Skript.registerAddon(this);

        logger.info("Loading BiomesSK...");
        try {
            addon.loadClasses("me.outspending.biomessk", "elements");
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("BiomesSK loaded!");
    }

    public static CustomBiome getLastCreatedBiome() {
        return lastCreatedBiome;
    }

    public static void setLastCreatedBiome(CustomBiome lastCreatedBiome) {
        BiomesSK.lastCreatedBiome = lastCreatedBiome;
    }

}

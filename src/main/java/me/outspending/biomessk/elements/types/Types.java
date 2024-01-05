package me.outspending.biomessk.elements.types;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import me.outspending.biomesapi.biome.CustomBiome;

public class Types {

    static {
        Classes.registerClass(new ClassInfo<>(CustomBiome.class, "custombiome")
                .user("custombiomes?")
                .name("CustomBiome")
                .description("Represents a custom biome inside BiomesAPI")
                .since("1.0.0")
                .parser(new Parser<>() {

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }

                    @Override
                    public String toString(CustomBiome customBiome, int i) {
                        return customBiome.toString();
                    }

                    @Override
                    public String toVariableNameString(CustomBiome customBiome) {
                        return customBiome.toString();
                    }

                }));
    }
}

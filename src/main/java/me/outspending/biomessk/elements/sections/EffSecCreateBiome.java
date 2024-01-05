package me.outspending.biomessk.elements.sections;

import ch.njol.skript.Skript;
import ch.njol.skript.config.SectionNode;
import ch.njol.skript.lang.EffectSection;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.TriggerItem;
import ch.njol.util.Kleenean;
import me.outspending.biomesapi.BiomeSettings;
import me.outspending.biomesapi.biome.CustomBiome;
import me.outspending.biomesapi.registry.BiomeResourceKey;
import me.outspending.biomessk.BiomesSK;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EffSecCreateBiome extends EffectSection {

    static {
        Skript.registerSection(EffSecCreateBiome.class,
                "create [a] new [custom] biome [with] id %string%");
    }

    private Expression<String> id;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult, @Nullable SectionNode sectionNode, @Nullable List<TriggerItem> list) {
        this.id = (Expression<String>) expressions[0];
        return true;
    }

    @Override
    protected @Nullable TriggerItem walk(Event event) {

        String id = this.id.getSingle(event);
        if (id == null) return super.walk(event, false);

        CustomBiome biome = CustomBiome.builder()
                .resourceKey(BiomeResourceKey.of("biomessk", id))
                .settings(BiomeSettings.defaultSettings())

                .build();

        BiomesSK.setLastCreatedBiome(biome);
        return super.walk(event, true);
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "";
    }
}

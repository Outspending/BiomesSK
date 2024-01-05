package me.outspending.biomessk.elements.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import me.outspending.biomesapi.biome.CustomBiome;
import org.bukkit.Color;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class EffBiomeWaterFogColor extends Effect {

    static {
        Skript.registerEffect(EffBiomeWaterFogColor.class, "set water fog colo[u]r of %custombiome% to %color%");
    }

    private Expression<CustomBiome> biomeExpression;
    private Expression<Color> colorExpression;

    @Override
    protected void execute(Event event) {
        Color color = colorExpression.getSingle(event);
        CustomBiome biome = biomeExpression.getSingle(event);
        if (color == null || biome == null) return;

        biome.setWaterFogColor(color.asRGB());
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        biomeExpression = (Expression<CustomBiome>) expressions[0];
        colorExpression = (Expression<Color>) expressions[1];
        return true;
    }

}

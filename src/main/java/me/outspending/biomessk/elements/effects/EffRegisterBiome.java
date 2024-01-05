package me.outspending.biomessk.elements.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import me.outspending.biomesapi.biome.CustomBiome;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class EffRegisterBiome extends Effect {

    static {
        Skript.registerEffect(EffRegisterBiome.class, "register [a] new [custom] biome %custombiome%");
    }

    private Expression<CustomBiome> customBiomeExpression;

    @Override
    protected void execute(Event event) {
        CustomBiome customBiome = customBiomeExpression.getSingle(event);
        if (customBiome == null) return;

        customBiome.register();
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        customBiomeExpression = (Expression<CustomBiome>) expressions[0];
        return true;
    }
}

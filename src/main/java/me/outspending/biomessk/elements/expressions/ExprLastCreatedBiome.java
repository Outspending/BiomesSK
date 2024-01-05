package me.outspending.biomessk.elements.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.outspending.biomesapi.biome.CustomBiome;
import me.outspending.biomessk.BiomesSK;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class ExprLastCreatedBiome extends SimpleExpression<CustomBiome> {

    static {
        Skript.registerExpression(ExprLastCreatedBiome.class, CustomBiome.class, ExpressionType.SIMPLE,
                "[the] last created [custom] biome");
    }

    @Override
    protected @Nullable CustomBiome[] get(Event event) {
        CustomBiome lastBiome = BiomesSK.getLastCreatedBiome();
        if (lastBiome == null) return null;

        return new CustomBiome[]{lastBiome};
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends CustomBiome> getReturnType() {
        return CustomBiome.class;
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        return true;
    }

}

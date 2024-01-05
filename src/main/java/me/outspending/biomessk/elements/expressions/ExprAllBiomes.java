package me.outspending.biomessk.elements.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.outspending.biomesapi.biome.BiomeHandler;
import me.outspending.biomesapi.biome.CustomBiome;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class ExprAllBiomes extends SimpleExpression<CustomBiome> {

    static {
        Skript.registerExpression(ExprAllBiomes.class, CustomBiome.class, ExpressionType.SIMPLE,
                "all [registered] [custom] biomes");
    }

    @Override
    protected @Nullable CustomBiome[] get(Event event) {
        return BiomeHandler.getRegisteredBiomes().toArray(CustomBiome[]::new);
    }

    @Override
    public boolean isSingle() {
        return false;
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

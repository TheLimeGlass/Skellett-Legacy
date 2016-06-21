package com.gmail.thelimeglass.Expressions;

import javax.annotation.Nullable;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class ExprGetClientTime extends SimpleExpression<Long>{
	
	//[get] [client] time of %player%
	
	private Expression<Player> player;
	@Override
	public Class<? extends Long> getReturnType() {
		return Long.class;
	}
	@Override
	public boolean isSingle() {
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] e, int arg1, Kleenean arg2, ParseResult arg3) {
		player = (Expression<Player>) e[0];
		return true;
	}
	@Override
	public String toString(@Nullable Event e, boolean arg1) {
		return "[get] [client] time of %player%";
	}
	@Override
	@Nullable
	protected Long[] get(Event e) {
		if (player.getSingle(e).getPlayerWeather() != null) {
			return new Long[]{player.getSingle(e).getPlayerTime()};
		} else {
			return null;
		}
	}
}
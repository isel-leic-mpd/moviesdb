package isel.leirt.mpd.moviesdb1.model;

import java.util.function.Function;

public class Actor {
	private int id;
	private String name;
	private double popularity;

	private Function<Integer, Iterable<TvSeries>> series;

	Iterable<TvSeries> getSeries() {
		return series.apply(id);
	}
}

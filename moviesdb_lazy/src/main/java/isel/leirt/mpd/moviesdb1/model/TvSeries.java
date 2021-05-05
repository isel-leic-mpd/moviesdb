package isel.leirt.mpd.moviesdb1.model;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

public class TvSeries {
	private LocalDate season1_start;
	private List<Integer> genre_ids;
	private  int id;
	private  String name;
	private  double popularity;
	private  double vote_average;
	private Function<Integer, Iterable<Actor>> actors;
	private Function<List<Integer>, Iterable<Genre>> genres;

	Iterable<Actor> getActors() {
		return actors.apply(id);
	}

	Iterable<Genre> getGenres() {
		return genres.apply(genre_ids);
	}
}

package isel.leirt.mpd.moviesdb1.model;

import java.time.LocalDate;
import java.util.Optional;


public class TvSeries {
	private LocalDate start_date;

	private  int id;
	private  String name;
	private  double popularity;
	private  Iterable<Actor> actors;
	private  Iterable<Genre> genres;
	private Optional<String> character;

	public TvSeries(LocalDate start_date,
	                String name,
	                int id,
	                double popularity,
	                Optional<String> character,
	                Iterable<Actor> actors,
	                Iterable<Genre> genres
	             ) {
		this.id = id;
		this.name = name;
		this.actors = actors;
		this.genres = genres;
	    this.popularity = popularity;
	    this.start_date = start_date;
	    this.character = character;
	}
	Iterable<Actor> getActors() {
		return actors;
	}

	Iterable<Genre> getGenres() {
		return genres;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public double getPopularity() {
		return popularity;
	}

	public LocalDate getStartDate() {
		return start_date;
	}


}

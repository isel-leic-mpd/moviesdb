package isel.leirt.mpd.moviesdb1.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static isel.leirt.mpd.queries.Queries.map;
import static isel.leirt.mpd.queries.Queries.toList;

public class TvSeriesDto {
	private String first_air_date;
	private  int[] genre_ids;
	private  int id;
	private  String name;
	private  double popularity;
	private String character;

	public LocalDate getStartDate() {
		return LocalDate.parse(first_air_date);
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

	public int[] getGenreIds() {
		return genre_ids;
	}

	public String toString() {
		return "{ "
			+ "series name=" + getName()
			+ ", start_date=" + getStartDate()
			+ ", series_id=" + id
			+ ", popularity=" + popularity
			+ getCharacter().map(c -> ", character=" +c).orElse("")
			+ " }";
	}

	public Optional<String> getCharacter() {
		return (character == null || character.length() ==0) ? Optional.empty() : Optional.of(character);
	}
}

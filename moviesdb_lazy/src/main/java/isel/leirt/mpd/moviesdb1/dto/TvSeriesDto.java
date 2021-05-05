package isel.leirt.mpd.moviesdb1.dto;

import java.time.LocalDate;
import java.util.List;

public class TvSeriesDto {
	private String first_air_date;
	private  List<Integer> genre_ids;
	private  int id;
	private  String name;
	private  double popularity;
	private  double vote_average;
	private String character;

	public LocalDate getStartDate() {
		return LocalDate.parse(first_air_date);
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "{ "
			+ "series name=" + getName()
			+ ", start_date=" + getStartDate()
			+ ", series_id=" + id
			+ ", popularity=" + popularity
			+ ((character != null && character.length()>0) ? (", character=" + character) : "")
			+ " }";
	}
}

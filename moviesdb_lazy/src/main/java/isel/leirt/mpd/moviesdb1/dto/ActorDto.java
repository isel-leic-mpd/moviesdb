package isel.leirt.mpd.moviesdb1.dto;

public class ActorDto {
	private int id;
	private String name;
	private double popularity;
	private String character;

	@Override
	public String toString() {
		return "{ "
		+ "name=" + name
		+ ", id = " + id
		+ ", popularity=" + popularity
		+ ", character=" + character
		+ " }";
	}
}

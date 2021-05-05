package isel.leirt.mpd.moviesdb1.dto;

public class GenreDto {
	private String id;
	private String name;

	public GenreDto(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() { return id; }

	public String getName() { return name; }

	@Override
	public String toString() {
		return "{ "
				+ "name = " + name
				+ ", id = " + id
				+ " }";
	}
}

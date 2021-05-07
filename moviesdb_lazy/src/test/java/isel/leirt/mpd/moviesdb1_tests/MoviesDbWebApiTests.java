package isel.leirt.mpd.moviesdb1_tests;

import isel.leirt.mpd.moviesdb1.MoviesDbWebApi;
import isel.leirt.mpd.moviesdb1.dto.ActorDto;
import isel.leirt.mpd.moviesdb1.dto.GenreDto;
import isel.leirt.mpd.moviesdb1.dto.TvSeriesDto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MoviesDbWebApiTests
{
	/*
	@Test
	public void getGenresTest() {
		MoviesDbWebApi api = new MoviesDbWebApi(new HttpRequest());

		List<GenreDto> genres = api.getGenres();
		genres.forEach(System.out::println);
		assertEquals(16, genres.size());
	}

	@Test
	public void getAnimationTvSeriesTest() {
		MoviesDbWebApi api = new MoviesDbWebApi(new HttpRequest());
		int animationGenreId = 16;
		List<TvSeriesDto> series =
			 api.discoveryTvSeries(1, animationGenreId);
		assertEquals(20, series.size());
	}

	@Test
	public void getActorsOfWestWorldSeriesTest() {
		int westWorldSeriesId = 638;
		MoviesDbWebApi api = new MoviesDbWebApi(new HttpRequest());

		List<ActorDto> actors =
			api.tvSeriesActors(westWorldSeriesId);
		assertEquals(10, actors.size());
	}

	@Test
	public void getRachelWoodTvSeriesTest() {
		MoviesDbWebApi api = new MoviesDbWebApi(new HttpRequest());

		int rachelWoodId = 38940;
		List<TvSeriesDto> series =
			api.actorTvSeries(rachelWoodId);
		assertEquals(18, series.size());
	}
	*/
}
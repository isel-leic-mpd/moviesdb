package isel.leirt.mpd.moviesdb1_tests;




public class MoviesDbServiceTests {
	/*
	@Test
	public void getGenresTest() {
		CounterRequest req = new CounterRequest( new HttpRequest() );
		MoviesDbService serv =
			 new MoviesDbService(new MoviesDbWebApi(req));

		Iterable<Genre> genres = serv.getGenres();
		genres.forEach(System.out::println);
		assertEquals(16, (count(genres)));
		assertEquals(1, req.getCount());
	}

	@Test
	public void getActionAndAdventureTvSeriesTest() {
		CounterRequest req = new CounterRequest( new HttpRequest() );
		int actionAndAdventureGenreId = 10759;
		int maxTvSeries = 40;

		MoviesDbService serv =
			new MoviesDbService(
				new MoviesDbWebApi(
					req
				)
			);


		Iterable<TvSeries> series =
			serv.searchByGenre(actionAndAdventureGenreId, maxTvSeries);

		assertEquals(0, req.getCount());
		System.out.println(count(series));

		assertEquals(2, req.getCount());

		Iterable<TvSeries> firstTen =
			limit(
				serv.searchByGenre(actionAndAdventureGenreId, maxTvSeries),
				10
			);
		assertEquals(2, req.getCount());

		firstTen.forEach(tvs -> {
			System.out.println(tvs.getName() + " actors:");
			tvs.getActors().forEach(System.out::println);
			System.out.println();
		});
		assertEquals(13, req.getCount());
	}

	@Test
	public void getActorsOfWestWorldSeriesTest() {
		int westWorldSeriesId = 63247;
		CounterRequest req = new CounterRequest(new HttpRequest());
		MoviesDbService serv =
			new MoviesDbService(new MoviesDbWebApi(req));

		Iterable<Actor> actors =
			serv.getSeriesActors(westWorldSeriesId);
		assertEquals(0, req.getCount());
		actors.forEach(System.out::println);
		assertEquals(1, req.getCount());
		assertEquals(7, (count(actors)));
		assertEquals(2, req.getCount());
	}

	@Test
	public void getRachelWoodTvSeriesTest() {
		CounterRequest req = new CounterRequest(new HttpRequest());
		MoviesDbService serv =
			new MoviesDbService(new MoviesDbWebApi(req));

		int rachelWoodId = 38940;
		Iterable<TvSeries> series =
			serv.getActorSeries(rachelWoodId);
		assertEquals(0, req.getCount());
		series.forEach(System.out::println);
		assertEquals(1, req.getCount());
		assertEquals(18, (count(series)));
		assertEquals(2, req.getCount());
	}
	*/
}

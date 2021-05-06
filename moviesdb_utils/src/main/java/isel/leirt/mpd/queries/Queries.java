package isel.leirt.mpd.queries;

import isel.leirt.mpd.queries.iterators.*;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class Queries {
	// factories or sequence constructors

	public static  <T> Iterable<T> of( T... params) {
		return () -> new ArrayIterator<>(params);
	}

	// intermediate operations

	public static <T> Iterable<T> filter(Iterable<T> src, Predicate<T> pred ) {
		return () -> new FilterIterator<>(src, pred);
	}



	public static <T,U> Iterable<U> map(
		Iterable<T> seq, Function<T,U> mapper) {

		return () -> new MapIterator<>(seq, mapper);
	}

	// terminal operations

	public static <T> long count(Iterable<T> seq) {
		long c = 0;
		for(T t : seq)  {
			c++;
		}
		return c;
	}

	public static <T extends Comparable<T>>  Optional<T> max(Iterable<T> src) {
		Iterator<T> it = src.iterator();
		if (!it.hasNext()) return Optional.empty();
		T ref = it.next();

		while (it.hasNext()) {
			T curr = it.next();
			if (curr.compareTo(ref) > 0) ref = curr;
		}
		return Optional.of(ref);
	}



	public static <T> Optional<T> first(Iterable<T> src) {
		Iterator<T> it = src.iterator();

		if (it.hasNext()) return Optional.of(it.next());
		else return Optional.empty();
	}


}

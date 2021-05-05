package isel.leirt.mpd.moviesdb1.queries;

import isel.leirt.mpd.moviesdb1.queries.iterators.*;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class Queries {
	// factories or sequence constructors
	public static Iterable<Long> primes() {
		return () -> {
			return new PrimesIterator();
		};
	}

	public static  <T> Iterable<T> of( T... params) {
		return () -> new ArrayIterator<>(params);
	}

	// intermediate operations

	public static <T> Iterable<T> filter(Iterable<T> src, Predicate<T> pred ) {
		return () -> new FilterIterator<>(src, pred);
	}

	public static <T> Iterable<T> takeWhile(Iterable<T> src, Predicate<T> pred ) {
	    return () -> new TakeWhileIterator<>(src, pred);
	}


	public static <T> Iterable<Double> mapToDoubles(
		Iterable<T> seq, ToDoubleFunction<T> mapper) {

		List<Double> temps = new ArrayList<>();

		for(T t: seq) {
			temps.add(mapper.applyAsDouble(t));
		}
		return temps;
	}

	public static Iterable<Integer> range(int li, int ls) {
		List<Integer> rangeList = new ArrayList<>();

		for (int i= li; i <= ls; ++i) {
			rangeList.add(i);
		}
		return rangeList;
	}

	public static <T,U> Iterable<U> map(
		Iterable<T> seq, Function<T,U> mapper) {

		return () -> new MapIterator<>(seq, mapper);
	}

	public static <T,U> Iterable<U> flatMap(
		Iterable<T> seq, Function<T, Iterable<U>> mapper) {

		return () -> new FlatMapIterator<>(seq, mapper);
	}

	public static <T> Iterable<T> skipWhile(Iterable<T> src, Predicate<T> pred ) {
		return () ->  {
			return new Iterator<T>() {
				boolean first = true;
				boolean hasValue;
				Iterator<T> itSrc = src.iterator();
				T curr;

				@Override
				public boolean hasNext() {
					if (hasValue) return true;
					if (first) {
						while (itSrc.hasNext())  {
							T val = itSrc.next();
							if (pred.test(val)) {
								first = false;
								curr = val;
								hasValue = true;
								return true;
							}
						}
						return false;
					}
					return itSrc.hasNext();
				}

				@Override
				public T next() {
					if (!hasNext()) {
						throw new NoSuchElementException();
					}
					if (hasValue) {
						hasValue = false;
						return curr;
					}
					return itSrc.next();
				}
			};

		};
	}

	public static <T> Iterable<T> limit(Iterable<T> src, int n) {
		return () -> {
			return new Iterator<T>() {
				int n;
				Iterator<T> itSrc = src.iterator();

				@Override
				public boolean hasNext() {
					return itSrc.hasNext() && n > 0;
				}


				@Override
				public T next() {
					if (!hasNext()) {
						throw new NoSuchElementException();
					}
					n--;
					return itSrc.next();
				}
			};
		};

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

	public static double maxDouble(Iterable<Double> doubles) {
		double max = Double.MIN_VALUE;

		for(double d : doubles)  {
			if (d > max) max = d;
		}
		return max;
	}

	public static <T> Optional<T> first(Iterable<T> src) {
		Iterator<T> it = src.iterator();

		if (it.hasNext()) return Optional.of(it.next());
		else return Optional.empty();
	}
}

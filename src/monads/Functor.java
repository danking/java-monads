package monads;

import java.util.function.Function;

public interface Functor<F extends Functor<?,?>, T> {
	public <U> F fmap(Function<T, U> f);

}

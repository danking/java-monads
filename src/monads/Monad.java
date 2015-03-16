package monads;

import java.util.function.Function;

public interface Monad<M extends Monad<?, ?>, T> extends Functor<M, T> {
	public M ret(T t);
	public <U> M bind(Function<T, M> f);
}

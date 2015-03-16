package monads;

public interface UnitMonad<M extends UnitMonad<?,?>, T> extends Monad<M,T> {
	M unit();
}

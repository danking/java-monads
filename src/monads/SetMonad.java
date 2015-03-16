package monads;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SetMonad<T> implements UnitMonad<SetMonad<?>, T> {

	private final Set<T> s;

	public static <T> SetMonad<T> make(Set<T> s) {
		return new SetMonad<>(s);
	}

	private SetMonad(Set<T> s) {
		this.s = s;
	}

	@Override
	public <U> SetMonad<U> fmap(Function<T, U> f) {
		return make(s.stream().map(f).collect(Collectors.toSet()));
	}

	@Override
	public SetMonad<T> unit() {
		return make(new HashSet<>());
	}

	@Override
	public SetMonad<T> ret(T t) {
		return make(new HashSet<>(Collections.singleton(t)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <U> SetMonad<U> bind(Function<T, SetMonad<?>> f) {
		Set<U> news = new HashSet<>();

		for (T t : s) {
			news.addAll(((SetMonad<U>)f.apply(t)).s);
		}

		return make(news);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		Iterator<T> it = this.s.iterator();
		if (it.hasNext()) {
			sb.append(it.next());
			while (it.hasNext()) {
				sb.append(", ");
				sb.append(it.next());
			}
		}
		sb.append("}");
		return sb.toString();
	}

}

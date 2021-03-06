package util;

public class Pair<A, B> {
	private final A a;
	private final B b;

	public static <A, B> Pair<A, B> make(A a, B b) {
		return new Pair<>(a, b);
	}

	private Pair(A a, B b) {
		this.a = a;
		this.b = b;
	}

	public A first() {
		return this.a;
	}

	public B second() {
		return this.b;
	}

	@Override
	public String toString() {
		return "(" + this.a + ", " + this.b + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Pair))
			return false;
		Pair<?, ?> other = (Pair<?, ?>) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		return true;
	}


}

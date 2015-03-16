package examples;

import java.util.HashSet;
import java.util.Set;

import monads.SetMonad;
import util.Pair;

public class Examples {

	public static void main(String[] args) {
		Set<Integer> s1 = new HashSet<>();
		Set<Character> s2 = new HashSet<>();

		s1.add(1);
		s1.add(2);
		s1.add(3);

		s2.add('a');
		s2.add('b');

		SetMonad<Integer> ms1 = SetMonad.make(s1);
		SetMonad<Character> ms2 = SetMonad.make(s2);

		SetMonad<Pair<Integer, Character>> ms1xms2 =
			ms1.bind(x ->
			ms2.fmap(y ->
			Pair.make(x, y)));

		System.out.println(ms1xms2);
	}

}

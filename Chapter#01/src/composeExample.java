import java.util.function.Function;

public class composeExample {

	public static void main(String... args) {
		composeExample();
	}
	private static void composeExample() {
		
		//using compose Keyword
        Function<Integer, Integer> absThenNegate
                = ((Function<Integer, Integer>) Math::negateExact).compose(Math::abs);
        
        //using andThen keyword
        Function<Integer, Integer> negateThenAbs
                = ((Function<Integer, Integer>) Math::negateExact).andThen(Math::abs);

        System.out.println(absThenNegate.apply(-25));
        System.out.println(absThenNegate.apply(25));
        System.out.println(negateThenAbs.apply(-25));
        System.out.println(negateThenAbs.apply(25));

    }

}

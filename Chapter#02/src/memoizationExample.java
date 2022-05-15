import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class memoizationExample {
	
	public static void main(String... args) {
		memoizationExample();
	}
	private final static Map<Integer, Integer> memoizationCache = new HashMap<>();

    public static Integer computeExpensiveSquare(Integer input) {
        if (!memoizationCache.containsKey(input)) {
            memoizationCache.put(input, doComputeExpensiveSquare(input));
        }
        return memoizationCache.get(input);
    }

    private static Integer doComputeExpensiveSquare(Integer input) {
        System.out.println("Computing square");
        return input * input;
    }

	private static void memoizationExample() {
        // Simple memoization
        System.out.println(computeExpensiveSquare(4));
        System.out.println(computeExpensiveSquare(4));
        System.out.println();

        // Better memoization
        Function<Integer, Integer> squareFunction = x -> {
            System.out.println("In function");
            return x * x;
        };

        Function<Integer, Integer> memoizationFunction = Memoizer.memoize(squareFunction);
        System.out.println(memoizationFunction.apply(2));
        System.out.println(memoizationFunction.apply(2));
        System.out.println(memoizationFunction.apply(2));

        Function<Double, Double> memoizationFunction2 = Memoizer.memoize(x -> x * x);
        System.out.println(memoizationFunction2.apply(4.0));
    }

}

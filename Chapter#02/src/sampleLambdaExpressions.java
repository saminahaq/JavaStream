import java.util.function.BiFunction;
import java.util.function.Function;

public class sampleLambdaExpressions {
	
	public static void main(String... args) {
		sampleLambdaExpressions();
	}

	  private static void sampleLambdaExpressions() {
	        // Sample lambda expressions
	        Function<Integer, Integer> s = x -> {
	            Integer y;
	            y = x + 1;
	            return y;
	        };

	        BiFunction<Integer, Double, Double> bi = (Integer x, Double y) -> x + y;
	        System.out.println(bi.apply(2, 2.0));
	    }

}

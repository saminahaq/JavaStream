import java.util.function.BiFunction;
import java.util.function.Function;

public class curryingExample {

	public static void main(String...  args) {
		curryingExample();
	}
	 private static void curryingExample() {
	        
		 	// Simple BiFunction
	        BiFunction<String, String, String> biFunctionConcat = (a, b) -> a + b;
	        System.out.println(biFunctionConcat.apply("Cat", "Dog"));

	        // 
	        Function<String, Function<String, String>> curryConcat;
	        //very Interesting
	        curryConcat = (a) -> (b) -> biFunctionConcat.apply(a, b);
	        Function<String, String> intermediateFunction;
	        intermediateFunction = curryConcat.apply("Cat");
	        
	        // Displays the lambda expression reference
	       // System.out.println(intermediateFunction); //reference object
	      //  System.out.println(curryConcat.apply("Cat"));  //reference object
	        System.out.println(intermediateFunction.apply("Dog"));

	        // Other usage
	        System.out.println(curryConcat.apply("Cat").apply("Dog"));
	        System.out.println(curryConcat.apply("Flying ").apply("Monkeys"));

	       //very Interesting
	        Function<Double, Function<Double, Double>> curryAdd
	                = (a) -> (b) -> a * b;
	        System.out.println(curryAdd.apply(3.0).apply(4.0));

	    }

}

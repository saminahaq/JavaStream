import java.util.function.Function;

public class pureFunctionExamples {

	public static void main(String... args) {
		pureFunctionExamples();
	}
	private static void pureFunctionExamples() {
        System.out.println(SimpleMath.square(5));
        
        //pure Function used .apply method
        Function<Integer, Integer> squareFunction = x -> x * x;
        System.out.println(squareFunction.apply(5));
    }
}

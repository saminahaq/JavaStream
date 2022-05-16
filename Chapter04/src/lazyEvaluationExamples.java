import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class lazyEvaluationExamples {
	
	public static void main(String... args) {
		lazyEvaluationExamples();
	}
	
	 private static void lazyEvaluationExamples() {
	        IntUnaryOperator sampleMap = num -> {
	            System.out.println("number: " + num);
	            return num;
	        };
	        Random random = new Random();
	        IntStream randomStream = random.ints()
	                .limit(5)
	                .map(sampleMap)
	                .sorted();
	        System.out.println(randomStream);
	        randomStream.forEach(System.out::println);

	        // Divide by zero example
	        Function<Integer, Integer> divide = n -> 1 / 0;
	        Function<Integer, Integer> add = n -> n + 3;
	        Function<Integer, Integer> multiply = n -> n * 5;
	        Function<Integer, Integer> subtract = n -> n - 4;

	        Function[] arr = {divide, add, multiply, subtract};
	        Stream<Function> stream = Arrays.stream(arr);
	        stream.skip(1)
	                .forEach(operation -> System.out.println(operation.apply(2)));
	    }

}

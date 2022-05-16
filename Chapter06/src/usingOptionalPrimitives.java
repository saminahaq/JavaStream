import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class usingOptionalPrimitives {
	
	public static void main(String... args) {
		usingOptionalPrimitives();
	}
	
	
	 private static void usingOptionalPrimitives() {
	        // Stream and Optional
	        Optional<Integer> anyInteger
	                = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
	                .stream()
	                .filter(i -> i % 2 == 0)
	                .findAny();
	        anyInteger.ifPresent(System.out::println);

	        // IntStream and OptionalInt
	        OptionalInt anyInt
	                = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8})
	                .filter(i -> i % 2 == 0)
	                .findAny();
	        anyInt.ifPresent(System.out::println);
	    }

	   

}

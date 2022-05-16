import java.util.Arrays;
import java.util.stream.IntStream;

public class sortingStreamExamples {

	public static void main(String... args) {
		sortingStreamExamples();
	}
	
	//sorting elements
	 private static void sortingStreamExamples() {
	        int[] numbers = {3, 6, 8, 8, 4, 6, 3, 3, 5, 6, 9, 4, 3, 6};
	        IntStream stream = Arrays.stream(numbers);
	        stream.sorted().forEach(n -> System.out.print(n + " "));
	        System.out.println();

	        stream = Arrays.stream(numbers);
	        stream.sorted().distinct().forEach(n -> System.out.print(n + " "));
	        System.out.println();
	    }
	
}

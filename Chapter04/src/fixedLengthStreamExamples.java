import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class fixedLengthStreamExamples {
	
	public static void main(String... args) {
		fixedLengthStreamExamples();
	}
	
	 private static void fixedLengthStreamExamples() {
	        int[] numbers = {3, 6, 8, 8, 4, 6, 3, 3, 5, 6, 9, 4, 3, 6};
//	    IntStream stream = Arrays.stream(numbers);

	        Rectangle[] rectangles = {
	            new Rectangle(10, 10, 50, 75),
	            new Rectangle(30, 40, 30, 45),
	            new Rectangle(110, 70, 70, 15),
	            new Rectangle(50, 10, 45, 35)
	        };
	        
	        
	        Stream<Rectangle> stream = Arrays.stream(rectangles);
	        
	        stream.forEach(x -> System.out.println(x));

	        List<String> cities = new ArrayList<>();
	        cities.add("London");
	        cities.add("Paris");
	        cities.add("Cairo");
	        cities.add("Manila");
	        Stream<String> cityStream = cities.stream();
	        
	        cityStream.forEach(x -> System.out.println(x));
	    }


}

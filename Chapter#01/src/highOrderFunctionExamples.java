
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;


public class highOrderFunctionExamples {

	public static void main(String... args) {
	// High-order and first-class functions : these terminology is associated with the functional programming,
	// nomal function	
		
		//check Chapter # 02
		
		highOrderFunction();
	}
	

	
	private static void highOrderFunction() {
	
		//Using List
		
//	    Integer arr[] = {1, 2, 3, 4, 5};
//	    List<Integer> numbers = Arrays.asList(arr);
//	    numbers.forEach(x -> System.out.println(x));
		
	
		//Using Stream 
		
		Stream<Integer> stream = Stream.of(10,20,14,18);
		stream.map(x -> x*1.5).forEach(x-> System.out.println(x));
		
		//another style usinf Stream
		stream = Stream.of(130,203,134,138);
		stream.map(x -> x/1.2).forEach(x -> System.out.println(x));
		
		//another style using Stream and Function
		Stream<String> names = Stream.of("George", "Mary", "Karen", "Jim");
		Function<String, String> toLower = (String name) -> name.toLowerCase();
        names.map(toLower).sorted().forEach(x -> System.out.println(x));
		
	}
}

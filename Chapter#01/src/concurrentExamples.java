import java.util.stream.Stream;

public class concurrentExamples {

	public static void main(String... args) {
		concurrent();
	}
	
	
	 private static void concurrent() {
	        Stream<Integer> stream = Stream.of(12, 52, 32, 74, 25);
	        stream.map(x -> x * 2).forEach(x -> System.out.println(x));
	        System.out.println("---");
	        stream = Stream.of(12, 52, 32, 74, 25);
	        stream.parallel().map(x -> x * 2).forEach(x -> System.out.println(x));
	    }
}

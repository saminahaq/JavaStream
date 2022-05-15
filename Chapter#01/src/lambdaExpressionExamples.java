import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

public class lambdaExpressionExamples {

	public static void main(String... args) {
		lambdaExpression();
		methodReferenceExample();
		collectionExamples();
		
	}
	  private static void lambdaExpression() {
	       
		  Random random = new Random();
	        
		  	//simple Style # 01
		  	System.out.println("Style # 01");
	        random.ints().limit(5).map(x -> 2 * x).forEach(System.out::println);
	        
	        //Simple Style # 02 [Interesting Style]
	        System.out.println("Style # 02");
	        random.ints().limit(5).map(x -> {
	            int y = 2 * x;
	            return y;
	        }).forEach(System.out::println);
	        
	        //Simple Style # 03
	        System.out.println("Style # 03");
	        random.ints().limit(5).map(x -> 2 * x).forEach(System.out::println);
	    }
	  
	  
	  private static void methodReferenceExample() {
	        
		  	//Simple Lambda Style
		  	Stream<Integer> stream = Stream.of(12, 52, 32, 74, 25);
	        stream.map(x -> x * 2).forEach(x -> System.out.println(x));
	        
	        //Simple Method Reference Style
	        stream = Stream.of(12, 52, 32, 74, 25);
	        stream.map(x -> x * 2).forEach(System.out::println);
	        
	      //Simple Method Reference Style
	        stream = Stream.of(12, 52, 32, 74, 25);
	        stream.map(Math::sin).forEach(System.out::println);

	    }

	    private static void collectionExamples() {
	    	
	    	//Printing names
	        String names[] = {"Sally", "George", "Paul"};
	        List<String> list = Arrays.asList(names);
	        
	        //Using Stream
	        Stream<String> stream = list.stream();
	       // does't work here: Function<String,Integer> len = (String name) -> name.length(); 
	        
	        stream.forEach(name -> System.out.println(name + " - " + name.length() + " - " +name.toUpperCase()));

	        //Using List
	        list.forEach(name -> System.out.println(name + " - " + name.length()));
	    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class highOrderFunctionExamples {

	private static List<String> list = Arrays.asList("Huey", "Duey", "Luey");
	public static void main(String... args) {
		highOrderFunctionExamples();
	}
	
	//check Chapter # 01
	
	 private static String processString(
	            Function<String, String> operation,
	            String target) {
	        return operation.apply(target);
	    }
	 
	 private static void highOrderFunctionExamples() {
	        // Imperative approach
	        for (String element : list) {
	            System.out.println(element.toLowerCase());
	        }

	        //Lambda function 
	        list.forEach( s -> System.out.println(s.length()));
	        
	        // High-order function approach : the use of ProcessString in High order is flexibility 
	        list.forEach(s -> System.out.println(
	                processString(t -> t.toUpperCase(),s)));
	        
	        
	        // Using a method reference
	        list.forEach(s -> System.out.println(
	                processString(String::toLowerCase, s)));

	        System.out.println();

	        //Different concepts
	        List<String> numberString = Arrays.asList("12", "34", "82");
	        List<Integer> numbers = new ArrayList<>();
	        List<Integer> doubleNumbers = new ArrayList<>();

	        //Style # 01
	        System.out.println("Style # 01");
	        for (String num : numberString) {
	            numbers.add(Integer.parseInt(num));
	        }
	        System.out.println(numbers);

	        numbers.clear();
	        numberString
	                .stream()
	                .forEach(s -> numbers.add(Integer.parseInt(s)));
	        System.out.println(numbers);

	      //Style # 02
	        System.out.println("Style # 02 using Function");
	        numbers.clear();
	        Function<List<String>, List<Integer>> singleFunction = s -> {
	            s.stream()
	                    .forEach(t -> numbers.add(Integer.parseInt(t)));
	            return numbers;
	        };
	        System.out.println(singleFunction.apply(numberString));

	      //Style # 03
	        System.out.println("Style # 03 Function");
	        Function<List<String>, List<Integer>> doubleFunction = s -> {
	            s.stream()
	                    .forEach(t -> doubleNumbers.add(Integer.parseInt(t) * 2));
	            return doubleNumbers;
	        };
	        System.out.println(doubleFunction.apply(numberString));

	        doubleNumbers.clear();
//	        Arrays.asList(numberString);
	      //Style # 04
	        System.out.println("Last example");
	        
	        Arrays.asList(numberString).stream()
	                .map(doubleFunction)
	                .forEach(s -> System.out.println(s));
	    }

	 
}

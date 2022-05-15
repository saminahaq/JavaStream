import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class functionalInterfaceExamples {

	public static void main(String... args) {
		functionalInterfaceExamples();
	}
	
	/* 
	 * few definations [Fucntional Interfacce]
	 * Function  : These transform their argument and return a  value
	 * Predicate : These are used to perform a test, which return a boolean value
	 * Consumer  : These use their argument, but do not return a value
	 * Supplier  : These are not passed data, but do return data
	 * Operator  : These perform a reduction type operation
	 */
	
    private static void functionalInterfaceExamples() {
//      Predicate<Integer> tooLarge = s -> s>100;
    	
   //Predicate exapmle
    	//Example # 01
      IntPredicate tooLarge = s -> s > 100;
      System.out.println(tooLarge.test(45));
      
      //Example # 02
      List<Integer> list = Arrays.asList(230, 45, 13, 563, 4);
      Stream<Integer> stream = list.stream();
      stream.forEach(s -> System.out.println(tooLarge.test(s)));

   // Example # Supplier
      Supplier<Integer> randomIntegers = () -> {
          Random random = new Random();
          int number = random.nextInt(10);
          while (number >= 5 && number <= 8) {
              number = random.nextInt(10);
          }
          return number;
      };
      for (int i = 0; i < 10; i++) {
         System.out.print(randomIntegers.get() + " ");
      }
      System.out.println();
      
      //Example # Operator 
      BinaryOperator<String> stringConcatenate = (s, t) -> s + ":" + t;
      System.out.println(stringConcatenate.apply("Cat", "Dog"));
  }
}

import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class infiniteStreamsExample {
	
	
	public static void main(String...  args) {
		infiniteStreamsExample();
	}
	private static void infiniteStreamsExample() {


        // Simple integer stream iteration
		
       /* System.out.println("Simple integer iteration");
        IntStream.iterate(0, n -> n + 1)
                .limit(10)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();*/

        
    /*  System.out.println("Filter the output");
        IntStream.iterate(0, n -> n + 1)
                .filter(n -> n > 10 && n < 100)
                .limit(10)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();*/

		
        // Infinite stream
		
       /* System.out.println("Infinite stream");
        IntStream.iterate(0, n -> (n+1)%2)
         .distinct()
         .limit(10)
         .forEach(System.out::println);*/

		
        // Infinte stream using the Scanner class
		
       /* Scanner scanner = new Scanner(System.in);
        Stream.iterate(scanner.next(), s -> scanner.next())
                .limit(5)
                .forEach(System.out::println);*/
       
		
		// Simple string iterate 
		
        /*System.out.println("String itertation example");
        Stream.iterate("Going", m -> m + "...")
                .limit(5)
                .forEach(System.out::println);*/

        // Madlibs
     /*   String[] subject = {"cat", "dog", "monkey", "bat"};
        String[] verb = {"chased", "ate", "lost", "swatted"};
        String[] object = {"ball", "rat", "doughnut", "tamale"};
        Random random = new Random();

        Stream.iterate("", m -> subject[random.nextInt(3)]
                + " " + verb[random.nextInt(3)]
                + " the " + object[random.nextInt(3)])
                .limit(5)
                .forEach(System.out::println);

        Stream.iterate(subject[random.nextInt(3)]
                + " " + verb[random.nextInt(3)]
                + " the " + object[random.nextInt(3)], m -> subject[random.nextInt(3)]
                + " " + verb[random.nextInt(3)]
                + " the " + object[random.nextInt(3)])
                .limit(5)
                .forEach(System.out::println);*/

        // generate examples
        
		/*System.out.println("Repeating values example");
        Supplier intSupplier = () -> 0;
        Stream.generate(intSupplier)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("Reusing previous values example");
        Stream.generate(() -> nextInt())
                .limit(5)
                .forEach(System.out::println);*/

        // Cannot use a lambda expression
//        int number = 0;
//        Stream.generate(()->number++)
//                .limit(5)
//                .forEach(System.out::println);  
        
        System.out.println("Random generate example");
        Supplier<Double> randomSupplier = Math::random;
        System.out.println();
        Stream.generate(randomSupplier)
                .limit(4)
                .forEach(System.out::println);

    }
	  static int number = 0;

	    private static int nextInt() {
	        return number++;
	    }

}

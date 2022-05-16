import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class filterExamples {

	public static void main(String... args) {
		filterExamples();
	}
	
	
	private static void filterExamples() {
        String[] animals = {"cats", "dog", "ox", "bats", "horses", "mule"};
        
        //traditional implementation
        System.out.println("Imperative implementation");
        List<String> list = new ArrayList<>();
        for (String name : animals) {
            if (!name.matches(".*s$")) {
                list.add(name);
            }
        }
        list.sort(null);
        for (String name : list) {
            System.out.println(name);
        }

        //Stream implementation
        System.out.println("Stream implementation");
        Stream<String> animalStream = Arrays.stream(animals);
        animalStream
                .filter(x -> !x.matches(".*s$"))
                .sorted()
                .forEach(x -> System.out.println(x));

        
        // Minic SQL statement [very Important]
        System.out.println("SQL example");
        Rectangle[] rectangles = {
            new Rectangle(10, 10, 50, 75),
            new Rectangle(30, 40, 30, 45),
            new Rectangle(110, 70, 70, 15),
            new Rectangle(50, 10, 45, 35)
        };
        Stream<Rectangle> stream = Arrays.stream(rectangles);
        // Select * from rectangles where x>10
        stream.filter(r -> r.getX() > 10)
                .forEach(r -> System.out.println(r));
    }
}

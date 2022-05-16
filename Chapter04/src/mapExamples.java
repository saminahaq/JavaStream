import java.util.Arrays;
import java.util.stream.Stream;

public class mapExamples {

	public static void main(String... args) {
		mapExamples();
	}
	 private static void mapExamples() {
	        Rectangle[] rectangles = {
	            new Rectangle(10, 10, 50, 75),
	            new Rectangle(30, 40, 30, 45),
	            new Rectangle(110, 70, 70, 15),
	            new Rectangle(50, 10, 45, 35)
	        };
	        int total = 0;

	        for (Rectangle rectangle : rectangles) {
	            rectangle.scale(0.25);
	            System.out.println(total + " - " + rectangle.getArea());
	            total += rectangle.getArea();
	        }
	        System.out.println(total);
	        
	        // Iterative approach
	        System.out.println("Iterative mapping");
	        for (Rectangle rectangle : rectangles) {
	            rectangle.scale(0.25);
	        } 
	        for (Rectangle rectangle : rectangles) {
	            total += rectangle.getArea();
	        }
	        System.out.println(total);
	        
	        
	        // Stream map
	        System.out.println("Stream mapping");
	        Stream<Rectangle> stream = Arrays.stream(rectangles);

	        // Approach 1 : stream [Simple]
	        
	        /*System.out.println();
	        total = stream
	                .map(r -> r.scale(0.25))
	                .mapToInt(Rectangle::getArea)
	                .map(Rectangle::getArea)
	                .sum();
	        System.out.println(total);*/
	        
	        
	        // Approach 2 : Stream [Advanced]
	        System.out.println();
	        stream = Arrays.stream(rectangles);
	        total = stream
	                .map(r -> r.scale(0.25))
	                .map(Rectangle::getArea)
	                //                .mapToInt(Rectangle::getArea)
	                //                .reduce(0,(r, s) -> r + s);
	                .reduce(0, (r, s) -> {
	                    System.out.println(r + " - " + s);
	                    return r + s;
	                });
	        System.out.println(total);

	    }
}

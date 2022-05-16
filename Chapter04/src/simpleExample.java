import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class simpleExample {

	public static void main(String...  args) {
		simpleExample();
	}
	private static void simpleExample() {
        int[] numbers = {3, 6, 8, 8, 4, 6, 3, 3, 5, 6, 9, 4, 3, 6};

//        Arrays.sort(numbers);
        
        // usage of Set for finding distinct element for addition
        Set<Integer> numberSet = new HashSet<>();
        for (int number : numbers) {
            numberSet.add(number);
        }

        // Compute total
        int total = 0;
        for (int number : numberSet) {
            total += number;
            System.out.println(number);
        }
        System.out.println(total);

        //using Stream
        total = Arrays
                .stream(numbers)
                .distinct()
                .sum();

        IntStream stream = Arrays.stream(numbers);
        total = stream
                .distinct()
                .sum();

        stream = Arrays.stream(numbers);
        total = stream.sum();
        System.out.println(total);
    }
}

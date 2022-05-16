import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class usingTheSkipMethod {

	public static void main(String...  args) {
		usingTheSkipMethod();
	}
	private static void usingTheSkipMethod() {
        int[] numbers = {3, 6, 8, 8, 4, 6, 3, 3, 5, 6, 9, 4, 3, 6};
        
        //make here "IntStream" for integer
        IntStream stream = Arrays.stream(numbers);
        //make these into statistic
        
        IntSummaryStatistics stats = stream.skip(5).summaryStatistics();
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Count: " + stats.getCount());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Sum: " + stats.getSum());
    }

}

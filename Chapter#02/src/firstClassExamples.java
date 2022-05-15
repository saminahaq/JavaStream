import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;


public class firstClassExamples {
	private static List<String> list = Arrays.asList("Huey", "Duey", "Luey");
	
	public static void main(String... args) {
		firstClassExamples();
	}
	
	private static BiFunction<Integer, Float, Float> calculatePayFunction(EmployeeType type) {
        switch (type) {
            case Hourly:
//                return (hours, payRate) -> hours * payRate;
                return (hours, payRate) -> {
                    if (hours <= 40) {
                        return hours * payRate;
                    } else {
                        return hours * payRate + (hours - 40) * 1.5f * payRate;
                    }
                };
            case Salary:
                return (hours, payRate) -> 40 * payRate;
            case Sales:
                return (hours, payRate) -> 500f + 0.15f * payRate;
            default:
                return null;
        }
    }
	 private static void firstClassExamples() {
	        BiFunction<Integer, Float, Float> calculateFunction;
	        int hoursWorked = 51;
	        calculateFunction = calculatePayFunction(EmployeeType.Hourly);
	        System.out.println(calculateFunction.apply(hoursWorked, 15.75f));

	        if (hoursWorked <= 40) {
	            calculateFunction = (hours, payRate) -> 40 * payRate;
	        } else {
	            calculateFunction = (hours, payRate) -> hours * payRate + (hours - 40) * 1.5f * payRate;
	        }
	        System.out.println(calculateFunction.apply(hoursWorked, 15.75f));

	        // Consumer example
	        Consumer<String> consumer;
	        Function<String, String> toLowerFunction;
//	        function = t -> t.toLowerCase();
	        toLowerFunction = String::toLowerCase;
	        consumer = s -> System.out.println(toLowerFunction.apply(s));
//	        consumer = s -> System.out::println(s);

	        list.forEach(consumer);
	    }
}

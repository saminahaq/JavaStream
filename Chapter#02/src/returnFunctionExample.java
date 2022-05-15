import java.util.Arrays;
import java.util.function.BiFunction;

public class returnFunctionExample {
	
	public static void main(String... args) {
		returnFunctionExample();
	}
	
	//Non-functional Approach :[Imperative approach]
	private static float calculatePay(int hoursWorked, float payRate, EmployeeType type) {
        switch (type) {
            case Hourly:
                return hoursWorked * payRate;
            case Salary:
                return 40 * payRate;
            case Sales:
                return 500.0f + 0.15f * payRate;
            default:
                return 0.0f;
        }
    }
	 //Functional Approach : advanatage of this solution is lambda expression can be passed in several different ways
	   private static BiFunction<Integer, Float, Float> calculatePayFunction(EmployeeType type) {
	        switch (type) {
	            case Hourly:
//	                return (hours, payRate) -> hours * payRate;
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
	private static void returnFunctionExample() {
        int[] hoursWorked = {8, 12, 8, 6, 6, 5, 6, 0};
        // Calculate sum imperatively
        int totalHoursWorked = 0;
        for (int hour : hoursWorked) {
            totalHoursWorked += hour;
        }

        // Calculate sum using stream
        totalHoursWorked = Arrays.stream(hoursWorked).sum();

//        System.out.println(
//                calculatePay(totalHoursWorked, 15.75f, EmployeeType.Hourly));

      //Functional Approach 
        System.out.println(
                calculatePayFunction(EmployeeType.Hourly)
                .apply(totalHoursWorked, 15.75f));
    }
}

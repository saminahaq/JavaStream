import java.util.function.BiFunction;
import java.util.function.Function;

public class eliminatingDependenciesExample {
	
	 static int num = 5;
	 public static void main(String... args) {
		 eliminatingDependenciesExample();
	 }
	private static void eliminatingDependenciesExample() {
		
        BiFunction<Integer, Double, Double> computeHourly = (hours, rate) -> hours * rate;
        Function<Double, Double> computeSalary = rate -> rate * 40.0;
        BiFunction<Double, Double, Double> computeSales = (rate, commission) -> rate * 40.0 + commission;
        //here no dependencies present : elimation make function more flexiable
        double hourlyPay = computeHourly.apply(35, 12.75);
        double salaryPay = computeSalary.apply(25.35);
        double salesPay = computeSales.apply(8.75, 2500.0);

        System.out.println(computeHourly.apply(35, 12.75)
                + computeSalary.apply(25.35)
                + computeSales.apply(8.75, 2500.0));

        double total = 0.0;
        boolean hourly = true;
        if (hourly) {
            total = hourlyPay;
        } else {
            total = salaryPay + salesPay;
        }
        System.out.println(total);

        Function<Double, Double> pureFunction = t -> 3 * t;
        System.out.println(pureFunction.apply(total));
        num = 6;
        //impure function because it using the variable "num"
        Function<Double, Double> impureFunction = t -> 3 * t + num;
        System.out.println(impureFunction.apply(total));
    }
}

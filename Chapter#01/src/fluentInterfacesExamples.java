import java.time.LocalDate;



public class fluentInterfacesExamples {
	
	public static void main(String... args) {
		fluentInterfaces();
	}
	
	public static void fluentInterfaces() {
		LocalDate today = LocalDate.now();
		//LocalDate futureDate = today.plusYears(2);
//	        futureDate = today.minusMonths(1);
//	        futureDate = today.plusDays(3);
//	        System.out.println(LocalDate.now());
//	        System.out.println(futureDate);
	        
		LocalDate futureDate;
	        futureDate = LocalDate.now()
	                .plusYears(2)
	                .minusMonths(1)
	                .plusDays(3);
	        
	        System.out.println(LocalDate.now());
	        System.out.println(futureDate);

		
	}

}

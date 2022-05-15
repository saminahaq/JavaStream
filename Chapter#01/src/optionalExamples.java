import java.util.Optional;


public class optionalExamples {
	   
	//optional function handle the null values
	public static Optional<Customer> findCustomerWithID(long id) {
	        //...
	        return Optional.empty();
	    }

	    private static void optionalExamples() {
	        Optional<Customer> optionalCustomer = findCustomerWithID(123);
	        if (optionalCustomer.isPresent()) {
	            Customer customer = optionalCustomer.get();
	            // Use customer
	        } else {
	            // handle missing value
	        }
	    }
}

import java.util.function.Function;

public class composeExamples {

	//Function composition is concerned two functions to form a third one. 
	public static void main(String... args) {
		composeExamples();
	}
	 private static void composeExamples() {
	        // compositionFunctionExamples();
	       // demonstration();
	          customerExamples();
	    }

	    private static void compositionFunctionExamples() {

	        // Java 8 approach, keyword: before, andThen, and after
	    	//style # 01
	        Function<Double, Double> doubleFunction = x -> 2 * x;
	        // Function Compostion using two function than keyword "compose"
	        Function<Double, Double> second
	                = doubleFunction.compose(x -> -x);
	        System.out.println(second.apply(5.0));

	        //style # 02 , using "apply" keyword
	        Function<Integer, Integer> baseFunction = t -> t + 2;
	        System.out.println(baseFunction.apply(5));

	        //style # 03, two function , using andThen
	        Function<Integer, Integer> afterFunction
	                = baseFunction.andThen(t -> t * 3);
	        System.out.println(afterFunction.apply(5));

	        //style # 04, compose
	        Function<Integer, Integer> beforeFunction
	                = baseFunction.compose(t -> t * 3);
	        System.out.println(beforeFunction.apply(5));
	        
	        //style # 05
	        System.out.println(baseFunction.compose((Integer t) -> t * 3).apply(5));
	    }

	    private static void demonstration() {
	        System.out.println("------- deomonstration ------");
	        
	        //style # 01
	        Function<Integer, Integer> baseFunction = t -> {
	            t = t + 2;
	            System.out.println("baseFunction: " + t);
	            return t;
	        };

	        System.out.println(baseFunction.apply(5));

	        //style # 02
	        Function<Integer, Integer> afterFunction = baseFunction.andThen(t -> {
	            t = t * 3;
	            System.out.println("afterFunction: " + t);
	            return t;
	        });
	        System.out.println(afterFunction.apply(5));
	        
	        //style # 03
	        Function<Integer, Integer> beforeFunction = (t -> {
	            t = t * 2;
	            System.out.println("beforeFunction: " + t);
	            return t;
	        });
	        System.out.println(beforeFunction.apply(5));

	        System.out.println("-- and then ----");
	        
	        //style # 04
	        System.out.println(afterFunction.compose(beforeFunction).apply(5));
	        // This does it in the wrong order
	        System.out.println(beforeFunction.compose(afterFunction).apply(5));
	    }
	    
	    private static void customerExamples() {
	       
	    	//
	        Customer customer = new Customer("bestcustomer@thebestcustomer.com");
	        Salesman salesman = new Salesman(customer);

	        Function<Customer, String> customerToEmailAddress
	                = Customer::getEmailAddress;
	        Function<Salesman, Customer> salesmanToBestCustomer
	                = Salesman::getBestCustomer;
	        Function<Salesman, String> toEmailAddress
	                = salesmanToBestCustomer.andThen(customerToEmailAddress);
	        
	        System.out.println(toEmailAddress.apply(salesman));
	        System.out.println(salesman.getBestCustomer().getEmailAddress());
	        
	        Function<Manager, String> managerToEmailAddress
	                = Manager::getEmailAddress;
	        Function<Salesman, Manager> salesmanToManager
	                = Salesman::getManager;
	        Function<Salesman, String> toManagerEmailAddress
	                = salesmanToManager.andThen(managerToEmailAddress);
	        
	        Manager manager = new Manager("manager@thecompany.com");
	        Salesman salesman2 = new Salesman(manager);
	        
	        System.out.println(toManagerEmailAddress.apply(salesman2));
	        System.out.println(salesman2.getManager().getEmailAddress());
	        
	        processEmailAddress(salesman,toEmailAddress);
	        processEmailAddress(salesman2,toManagerEmailAddress);
	    }
	    
	    private static void processEmailAddress(
	            Salesman salesman,
	            Function<Salesman, String> toEmailAddress) {
	        System.out.println(toEmailAddress.apply(salesman));        
	    }

	    
}

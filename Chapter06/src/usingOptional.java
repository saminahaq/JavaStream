
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

public class usingOptional {
	
	
	//very important concepts
	public static void main(String... args) {
		usingOptional();
	}
	
	
	
	private static void usingOptional() {
        Customer customer1 = new Customer(123, "Sue");
        Customer customer2 = new Customer(456, "Bob");
        Customer customer3 = new Customer(789, "Mary");
        Customer defaultCustomer = new Customer(0, "Default");
        Customers customers = new Customers();
        customers.addCustomer(defaultCustomer.getId(), defaultCustomer);
        customers.addCustomer(customer1.getId(), customer1);
        customers.addCustomer(customer2.getId(), customer2);
        customers.addCustomer(customer3.getId(), customer3);

        // Creating Optional instances
        //Task # 01 Start
        System.out.println("Creating Optional instances");
        String animal = "cat";
        //creating optional
        Optional<String> opt;
        opt = Optional.of(animal);
        System.out.println(opt);

//        animal = null;
//        opt = Optional.of(animal);
//        System.out.println(opt);
        animal = "cat";
        opt = Optional.ofNullable(animal);
        System.out.println(opt);

        animal = null;
        opt = Optional.ofNullable(animal);
        System.out.println(opt);

//        animal = null;
//        opt = Optional.of(animal);
//        System.out.println(opt);
     
        //Task # 01 End
        
        //Task # 02 Start
        //Aproach # 01 :Traditional Approach
        System.out.println();
        Customer customer;
        System.out.println("findCustomerWithID");
        int id = 234;
      //int   id = 789;
        customer = customers.findCustomerWithID(id);

        if (customer != null) {
            if (customer.getName().equals("Mary")) {
                System.out.println("Processing Mary");
            } else {
                System.out.println(customer);
            }
        } else {
            System.out.println(defaultCustomer);
        }

        System.out.println();
        
        //Approach 02 using OPtional
        
        System.out.println("findOptionalCustomerWithID");
        Optional<Customer> optionalCustomer = customers.findOptionalCustomerWithID(id);
        if (optionalCustomer.isPresent()) {
            if (optionalCustomer.get().getName().equals("Mary")) {
                System.out.println("Processing Mary");
            } else {
                System.out.println(optionalCustomer.get());
            }
        } else {
            System.out.println(defaultCustomer);
        }

        System.out.println();
        //Approach 03 using if Present
        System.out.println("Using if Present");
        Consumer<Customer> consume = o -> {
            if (o.getName().equals("Mary")) {
                System.out.println("Processing Mary");
            } else {
                System.out.println(optionalCustomer.get());
            }
        };

        optionalCustomer.ifPresent(consume);

        optionalCustomer.ifPresent(o -> {
            if (o.getName().equals("Mary")) {
                System.out.println("Processing Mary");
            } else {
                System.out.println(optionalCustomer.get());
            }
        });

      //Approach 03 Using orElse
        System.out.println();
        System.out.println("Using orElse");
        Customer current = customers
                .findOptionalCustomerWithID(id)
                .orElse(defaultCustomer);
        System.out.println(current);

      //Approach 03 Using orElseGet
        System.out.println();
        System.out.println("Using orElseGet");
        current = customers
                .findOptionalCustomerWithID(id)
                .orElseGet(() -> customers.findOptionalCustomerWithID(0).get());
        System.out.println(current);

        //Using Using orElseThrow with exceptional handling
        System.out.println();
        System.out.println("Using orElseThrow");
        try {
            current = customers
                    .findOptionalCustomerWithID(id)
                    .orElseThrow(NoCustomerFoundException::new);
            System.out.println(current);
        } catch (NoCustomerFoundException ex) {
            ex.printStackTrace();
        }
        
        System.out.println();
        System.out.println("---Complete solution");
        Function<? super Customer, Customer> processMary =
                x -> {
                    if (x.getName().equals("Mary")) {
                        System.out.println("Processing Mary");
                    } 
                    return x;
                };
        Function<? super Customer, Customer> processNotMary =
                x -> {
                    if (!x.getName().equals("Mary")) {
                        System.out.println(x);
                    }
                    return x;
                };
        
        Function<? super Customer, Customer> processCustomer
                = x -> {
                    if (x.getName().equals("Mary")) {
                        System.out.println("Processing Mary");
                    } else {
                        System.out.println(optionalCustomer.get());
                    }
                    return x;
                };
//        Function<? super Part, Part> selectCustomerMap
//                = x -> x.setPartName(x.getPartName() + "-Out-of-stock");
        try {
            id = 789;
            customer3.setName("Mary Sue");
//            id = 123; // 123 blows up!!!
            current = customers
                    .findOptionalCustomerWithID(id)
//                    .map(processCustomer)
                    .map(processMary)
                    .map(processNotMary)
                    .orElseThrow(NoCustomerFoundException::new);
            System.out.println(current);
        } catch (NoCustomerFoundException ex) {
            ex.printStackTrace();
        }

        // Using filter method
        System.out.println();
        System.out.println("---Using Optional filter");
        id = 456;
        current = customers
                .findOptionalCustomerWithID(id)
                .filter(i -> i.getId() > 400)
                .orElseGet(()
                        -> customers.findOptionalCustomerWithID(0).get());
        System.out.println(current);

        // Using Stream filter method
        System.out.println();
        System.out.println("Using Stream filter");
        OptionalInt result = IntStream.of(1, 5, 12, 7, 5, 24, 6)
                .filter(n -> n > 10)
                .max();
        result.ifPresent(o -> System.out.println(o));

        // Using filter map method
        System.out.println();
        System.out.println("Using filter map");
        id = 456;
        String name;
        Optional<Customer> optCustomer = customers.findOptionalCustomerWithID(id);
        if (optCustomer.isPresent()) {
            name = optCustomer.get().getName().trim();
        } else {
            name = "No Name";
        }
        System.out.println(name);
        name = customers
                .findOptionalCustomerWithID(id)
                .map(o -> o.getName().trim())
                .orElse("No Name");

        System.out.println(name);

        // Returning a List
        System.out.println();
     //   System.out.println("Returning a list");
//        List<Customer> list = customers
//                .findOptionalCustomerWithID(id)
//                .map(Collections::singletonList)
//                .orElse(Collections.emptyList());
//        
//        for (Customer c : list) {
//            System.out.println(c);
//        }

        System.out.println("Optional Parameter Example");
        Customer customerOptional = new Customer(123);
        System.out.println(customerOptional);
        customerOptional = new Customer(123, "Steve");
        System.out.println(customerOptional);
        customerOptional = new Customer(123, Optional.of("Steve"));
        System.out.println(customerOptional);
        customerOptional = new Customer(123, Optional.empty());
        System.out.println(customerOptional);
    }


}

package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeImp {
	static List<Employee>  employees = new ArrayList<>();
	static {
        employees.add(
                new Employee("Shabbir", "Dawoodi", 5000.0, List.of("Project 1","Project 2"))
        );

        employees.add(
                new Employee("Nikhil", "Gupta", 6000.0, List.of("Project 1","Project 3"))
        );

        employees.add(
                new Employee("Shivam", "Kumar", 5500.0, List.of("Project 3","Project 4"))
        );

    }
	
	public static void main(String... args) {
		
		
		//ForEach -> its termination operation that mean after forEach we can not do anything more
		
		/*employees.stream()
				.forEach( empl -> System.out.println("Employee ->  "+ empl));
		
		//map
        //collect
		//using List
		List<Employee>  incSal=
					employees.stream()
				.map(employee -> new Employee(
						employee.getFirstName(),
						employee.getLastName(),
						employee.getSalary() * 100,
						employee.getProjects()
						))
				.collect(Collectors.toList());// put chaom the operation by "Collect"
		
		System.out.println(incSal);
		
		/////////////////////////// OR //////////////////////////
		//usinf Set
		Set<Employee> increasedSal =
                employees.stream()
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary()  * 1.10,
                        employee.getProjects()
                ))
                .collect(Collectors.toSet());
        System.out.println(increasedSal);
		
		
      //filter  -> findFirst  //any operator return stream obj is called dintermediate opeartor and put lambda
        List<Employee> filtEmpl =
        		employees
        				.stream()
        				.filter( empl -> empl.getSalary() > 5000) //intermediate op
        				.map(employ  -> new Employee( //intermediate op
        						employ.getFirstName(),
        						employ.getLastName(),
        						employ.getSalary(),
        						employ.getProjects()
        				))
        				.collect(Collectors.toList());
        				
        System.out.println(filtEmpl);
       
   
      //filter --->.findFirst() .orElse(null);
        
        Employee  filterfindFirstorElse =  //only employee not the list b/c we r getting one value
        		employees
        					.stream()
        					.filter( empl -> empl.getSalary() >5000)
        					.map(empl -> new Employee(
        							empl.getFirstName(),
        							empl.getLastName(),
        							empl.getSalary(),
        							empl.getProjects()
        				))
        					.findFirst()  //only one 
        					.orElse(null); //when parameter 7000 so execute this one and get null 
        				
        
        System.out.print(filterfindFirstorElse);
        
     
        
							
        //flatMap  -> flat the object e.g list of string only string of list thats mean flatten out the objects 
		
		String projects =
				employees
				.stream()
				.map(empl -> empl.getProjects())
				.flatMap(strings -> strings.stream())
				.collect(Collectors.joining(","));
		System.out.println(projects);
							

        //short Circuit operations -> it will limit your data
		List<Employee> shortCircuit =
                employees
                .stream()
                .skip(1)
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(shortCircuit);

        //Finite Data
        Stream.generate(Math::random)
        .limit(5)
        .forEach(value -> System.out.println(value));
        
  
        
      //sorting
        
        
        List<Employee> sortedEmployees =
                employees
                .stream()
                .sorted((o1, o2) -> o1.getFirstName()
                        .compareToIgnoreCase(o2.getFirstName()))
                .collect(Collectors.toList());
        
        System.out.println(sortedEmployees);
        
      
      //min or max
		Employee minMaxSal =
				employees
					.stream()
						//.max(Comparator.comparing(Employee::getSalary))
						.min(Comparator.comparing(Employee::getSalary))
						.orElseThrow(NoSuchElementException::new);

		System.out.println(minMaxSal);
	*/	
      //reduce
		
		Double totalSal =
                employees
                .parallelStream()  //want to do the parallel stream instead of sequential stream so put parallelStrem
                .map(employee -> employee.getSalary())
                .reduce(0.0,Double::sum);  // sum of all salary accumulate all salary
        System.out.println(totalSal);

        
        
        
	}

}

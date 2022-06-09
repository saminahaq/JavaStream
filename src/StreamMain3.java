import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class StreamMain3 {
	
	//method Of stream
	
	
	//Filter --> return boolean
	/*
	 * filter(predicate) //intermediate operator
	 * boolean valued function is predicate is true than filter the data
	 * Filter(predicate) --- return boolean
	 * 
	 */
	 //
		
	
	//Map ---> return value
	/*
	 * intermediate operator
	 * performed operation on each element, important is on each element
	 * 
	 * map(function) - return value 
	 * 
	 */
	
	public static void main(String[] args) {
		
		
	 //Filter	
	  List<String> myList = List.of("one", "two","three");
	  
	  List<String> myStr = myList.stream()
			  						.filter(t -> t.startsWith("t"))
			  						.collect(Collectors.toList());
		
	  myStr.forEach(t -> System.out.println(t));
	  
	  ////or////
	  // myStr.stream().forEach(System.out::println);
	  
	  
	  ////or////
	  //System.out.println(myStr);
		
		
		//Map
		
		
		List<Integer> myListint = List.of(22,45,23,89,44,35,78,99,88,77);
		List<Integer> myStrInt = myListint.stream()
											.map(t -> t* 8)
											.collect(Collectors.toList());
		
		myStrInt.forEach(t -> System.out.println(t));
		
		//Sort
		
		List<Integer> sortList = myListint.stream()
											.sorted()
											.collect(Collectors.toList());
		sortList.forEach(t -> System.out.println(t));
		
		//min
		int minList = myListint.stream()
				.min( (o1, o2) -> o1.compareTo(o2))
				.get();
		System.out.println("Min  :" +minList);
		
		//Max
		
		int maxList = myListint.stream()
				.max( (o1, o2) -> o1.compareTo(o2))
				.get();
		System.out.println("maxList  :" +maxList);
		
	}
	
	
	
	
	
}

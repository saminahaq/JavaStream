import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain1 {
	
	public static void main(String[] args) {
		//Create a List and filter even number.
		
		List<Integer> list1= List.of(1,2,3,4,5); //unmodifiedable list [immutable]
		
		List<Integer> list2 = Arrays.asList(1,2,3,5); //Also ImmutableList
		
		/////////////////////////shortCut//////////////////////////////////
		
		List<Integer> evenList = list1.stream()
										.filter(i -> (i%2 == 0))
										.collect(Collectors.toList());
		System.out.println(evenList);
		 
		//filter out greater than 3
		
		List<Integer> listG = list1.stream().filter(t -> t > 3).collect(Collectors.toList());
		System.out.println(listG);
		
	}

}

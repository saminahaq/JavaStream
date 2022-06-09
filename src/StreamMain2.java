import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain2 {
	
	//create stream object
	
	public static void main(String[] args) {
		
		//Stream API -- Collection
		//Collection/group of object also implied
		
		//create the object of stream
		Stream<Object> mystreamObj =  Stream.empty(); //blank stream
		mystreamObj.forEach(t -> System.out.println("Empty stream object" + t));//beacuse if the 't' is true than print
		
		 //Method #01 : array object Collection
		
		String[] name = {"one","two","three"};
		
		Stream<String> str = Stream.of(name);
		str.forEach(t -> System.out.println(t));
 
		//3
		Stream<Object> strbuild = Stream.builder().build();
		
		
		//4 //Common used
		List<Integer> myList = new ArrayList<>(); // myList is the child object of List class, and than calling stream on child obj 
		
		myList.add(78);
		myList.add(80);
		myList.add(81);
		
		Stream<Integer> myStream = myList.stream();
		myStream.forEach(t -> System.out.println(t));
		
		
		
		
		
	}
	

}

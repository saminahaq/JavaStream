import java.util.ArrayList;

public class defaultInterfaceExamples {
	
	public static void main(String... args) {
		defaultInterfaceExamples();
	}
	
	
	private static void defaultInterfaceExamples() {
	        ComputeImpl computeImpl = new ComputeImpl();
	        System.out.println(computeImpl.doubleNumber(2));
	        System.out.println(computeImpl.negateNumber(2));
	        System.out.println(computeImpl.compute());
	        
// Also these below additional method does not break the code 
	        ArrayList<String> list = new ArrayList();
	        list.add("Apple");
	        list.add("Peach");
	        list.add("Banana");
	        list.forEach(f -> System.out.println(f));
	    }

}


public class functionalInterfaceExample {

	public static void main(String... args) {
		functionalInterfaceExample();
	}
	   private static void functionalInterfaceExample() {
	        new Thread(() -> {
	            for (int i = 0; i < 5; i++) {
	                System.out.println("Thread!");
	            }
	        }).start();
	    }
}

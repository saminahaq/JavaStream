
public class exceptionHandlingExample {
	public static void main(String... args) {
		exceptionHandlingExample();
	}
	
	 private static void exceptionHandlingExample() throws IllegalArgumentException {
	        IntegerConcatenation ic = (m, n) -> {
	            if (m == 0) {
	                throw new IllegalArgumentException();
	            } else {
	                return m + ":" + n;
	            }
	        };
	        System.out.println(ic.concatenate(0, 45));
	    }
}

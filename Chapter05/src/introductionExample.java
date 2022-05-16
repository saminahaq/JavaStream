
public class introductionExample {

	public static void main(String... args) {
		introductionExample();
	}
	
	 private static void introductionExample() {
	        // Imperative solution
	        long fact = 1;
	        for (int i = 1; i <= 5; i++) {
	            fact *= i;
	        }
	        System.out.println(fact);
	        // Recursive solution
	        System.out.println(factorial(5));
	    }

	    public static long factorial(long n) {
	        if (n == 1) {
	            return 1;
	        } else {
	            return n * factorial(n - 1);
	        }
	    }
	    
	
}

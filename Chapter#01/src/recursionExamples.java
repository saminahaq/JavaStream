
public class recursionExamples {
	
	public static void main(String...  args) {
	
		recursionExamples();
	}
	//tail recursive
	private static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

	
	 private static void recursionExamples() {
		  // Recursive solution
	     
	        int num = 3;

	      int  result = factorial(num);
	        System.out.println(result);
	    }


}

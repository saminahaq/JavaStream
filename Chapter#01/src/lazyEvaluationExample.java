import java.util.Random;

public class lazyEvaluationExample {

	public static void main(String... args) {
		lazyEvaluation();
	}
	
	//Lazyevaluation gives a facility of runtime optimization
	 private static void lazyEvaluation() {
		  Random random = new Random();
	        random.ints().limit(5).sorted().map( x -> Math.abs(x))
	        .forEach(x -> System.out.println(x));
	        System.out.println("---");
	      
	    }

}

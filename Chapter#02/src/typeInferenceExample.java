
public class typeInferenceExample {

	public static void main(String... args) {
		typeInferenceExample();
	}
	
	private static void typeInferenceExample() {
		
		// we have the interface of StringConcatenation, IntegerConcatenation. DoubleConcatenation
        StringConcatenation sc = (s, t) -> s + ":" + t;
        IntegerConcatenation ic = (m, n) -> m + ":" + n;
        DoubleConcatenation dc = (m, n) -> m + ":" + n;

        System.out.println(sc.concatenate("Cat", "Dog"));
        System.out.println(ic.concatenate(23, 45));
        System.out.println(dc.concatenate(23.12, 45.12));

        //very importany
        //optimized solution : here we hav ethe funtional interface that eliminate the need of three difereent interface
        // funtional interface : "Concatenation"
        Concatenation<String> stringConcatenate = (s, t) -> s + ":" + t;
        Concatenation<Integer> integerConcatenate = (s, t) -> s + ":" + t;
        System.out.println(stringConcatenate.concatenate("Cat", "Dog"));
        System.out.println(integerConcatenate.concatenate(23, 45));
    }
	
}

import java.util.function.Function;

public class closureExamples {
	
	public static void main(String... args) {
		closureExamples();
	}
	
	private static void closureExamples() {
        ClosureExample ce = new ClosureExample();
        //here should be final, because now it would not modified
        final Function<String, String> function = ce.getStringOperation();
        System.out.println(function.apply("Closure"));
//
//        function = String::toLowerCase;
//        Consumer<String> consumer = s -> System.out.println(function.apply(s));
    }

}

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class lambdaExpressionsRevisited {

	private static List<String> list = Arrays.asList("Huey", "Duey", "Luey");
	public static void main(String... args) {
		lambdaExpressionsRevisited();
	}
	
	private static void lambdaExpressionsRevisited() {
        //Style #01
		list.forEach(new ConsumerImpl<>());
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String t) {
                System.out.println(t);
            }
        });

        //Style # 02
        list.forEach(t -> System.out.println(t));

        //Style # 03
        Consumer consumer = t -> System.out.println(t);
        list.forEach(consumer);
    }
}

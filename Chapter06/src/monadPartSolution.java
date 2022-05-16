import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class monadPartSolution {

	
	//Monad provide the facilities of chaining and piplea pproach of function
	public static void main(String... args) {
		monadPartSolution();
	}
    private static void monadPartSolution() {
        Map<Integer, Part> parts = new HashMap<>();
        parts.put(123, new Part(123, "bolt"));
        parts.put(456, new Part(456, "nail"));
        parts.put(789, new Part(789, "wire"));

        System.out.println("---Parts Monad Example");
        Function<? super Part, Optional<Part>> toUpperParts
                = x -> Optional.of(new Part(123, x.getPartName().toUpperCase()));
        Function<? super Part, ? extends Part> outOfStock
                = x -> new Part(234, x.getPartName() + "-Out-of-stock");

        Optional<Part> optPart = Optional.of(new Part(111, "Mirror"));
        Optional<Part> partResult = optPart.flatMap(toUpperParts);
        System.out.println(optPart + " " + optPart.get());
        System.out.println(partResult + " " + partResult.get());

//        Optional<Parts>  xw = partResult.map(outOfStock);
//        System.out.println(xw + " " + xw.get());
        System.out.println(optPart.flatMap(toUpperParts).map(outOfStock));

        System.out.println("---The Part Example");
        // The part example
        Function<? super Part, Optional<Part>> setOOSState
                = x -> x.outOfStock(true);
        Function<? super Part, Optional<Part>> setOOSName
                = x -> x.partName(x.getPartName() + "-Out-of-stock");
        Function<? super Part, Part> setOOSNameMap
                = x -> x.setPartName(x.getPartName() + "-Out-of-stock");
        optPart = Optional.of(parts.get(123));
        try {
            optPart = Optional.of(parts.get(456));
//            optPart = Optional.ofNullable(parts.get(111));
            System.out.println("lambda expressions");
            System.out.println(
                    optPart
                    .flatMap(x -> x.outOfStock(true))
                    .flatMap(x -> x.partName(x.getPartName() + "-Out-of-stock"))
                    .flatMap(Part::replicatePartMonad)
                    .orElseThrow(() -> new RuntimeException())
            );

            System.out.println("lambda variables");
            optPart = Optional.of(parts.get(456));
            System.out.println(
                    optPart
                    .flatMap(setOOSState)
                    .map(setOOSNameMap)
                    //                    .flatMap(setOOSName)
                    .flatMap(Part::replicatePartMonad)
                    .orElseThrow(() -> new RuntimeException())
            );
            System.out.println(optPart);
        } catch (RuntimeException ex) {
            System.out.println("Exception: " + optPart);
        }
    }

//    private static void usingMonads() {
//        System.out.println("---Integer flatMap Example");
//        Optional<Integer> one = Optional.of(1);
//
//        Optional<Integer> plusOne = one.flatMap(n -> Optional.of(n + 1));
//        System.out.println(plusOne.get());
//
//        Function<? super Integer, Optional<Integer>> plusOneFunction
//                = n -> Optional.of(n + 1);
//        plusOne = one.flatMap(plusOneFunction);
//        System.out.println(plusOne.get());
//
//        System.out.println("---Integer map Example");
//        Function<? super Integer, ? extends Integer> plusOneMapFunction
//                = n -> n + 1;
//        plusOne = one.map(x -> x + 1);
//        System.out.println(plusOne.get());
//        plusOne = one.map(plusOneMapFunction);
//        System.out.println(plusOne.get());
//
//        System.out.println("---Integer flatMap and map Example");
//        plusOne = one
//                .map(x -> x.intValue() + 1)
//                .flatMap(n -> Optional.of(n + 1));
//        System.out.println(plusOne.get());
//
//        System.out.println("---Integer to String Example");
//        Optional<String> result = one.flatMap(n -> Optional.of((++n).toString()));
//        System.out.println(result + " " + result.get());
//
//        //
//        System.out.println("---String Monad Example");
//        String iterative = "go".toUpperCase().concat("ing");
//        System.out.println("Iterative: " + iterative);
//        iterative = "go".concat("ing").toUpperCase();
//        System.out.println("Iterative: " + iterative);
//        Function<? super String, Optional<String>> toConcatString = x -> Optional.of(x + "ing");
//        Function<? super String, Optional<String>> toUpperString = x -> Optional.of(x.toUpperCase());
//        Optional<String> ostring = Optional.of("go");
//        // The order of the flatMap methods is important
//        ostring = Optional.of("go");
//        result = ostring
//                .flatMap(toConcatString)
//                .flatMap(toUpperString);
//        System.out.println(ostring.get());
//        System.out.println(result.get());
//
//        // flatMap method order reversed
//        result = ostring
//                .flatMap(toUpperString)
//                .flatMap(toConcatString);
//        System.out.println(ostring.get());
//        System.out.println(result.get());
//        //
//        System.out.println("---Left Identity Example");
//        ostring = Optional.of("go");
//        Optional<String> monad1;
//        monad1 = ostring.flatMap(toConcatString);
//        result = toUpperString.apply(monad1.get());
//        System.out.println(result.get());
//        //
//        System.out.println("---Right Identity Example");
//        ostring = Optional.of("right");
//        System.out.println(ostring.flatMap(s -> Optional.of(s)) == ostring);
//        System.out.println(ostring.flatMap(s -> Optional.of(s)).equals(ostring));
//        System.out.println(ostring.flatMap(s -> Optional.of(s)) + "==" + ostring);
//
////        jdk8_optional_monad_laws laws = new jdk8_optional_monad_laws();
////        try {
////            laws.test();
////        } catch (Exception ex) {
////            ex.printStackTrace();
// //       }
//    }
}

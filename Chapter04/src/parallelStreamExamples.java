import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class parallelStreamExamples {

	public static void main(String... args) {
		parallelStreamExamples();
	}
	
	
	
	private static void parallelStreamExamples() {

		
//      int[] pay = {40, 45, 54, 35, 48, 40, 40, 23, 54, 45, 44};
//      IntStream payStream = Arrays.stream(pay);
//      payStream.map(h->getRate(h)).forEach(p -> System.out.println(p));

      List<Integer> hours
              = Arrays.asList(32, 40, 24, 23, 35, 18, 40, 30, 23, 
                      54, 35, 34, 25, 15, 34, 35, 42, 44, 40, 35, 
                      35, 45, 35, 31, 12, 56);
      // 26610
      // 26250         
      System.out.println("Total hours");
      int sumHours = hours
              .parallelStream()
              .map(h -> h * 30)
              .reduce(0, (r, s) -> r + s);
      System.out.println(sumHours);

      // Non-interference Examples
      System.out.println("Non-interference Examples");
      // ArrayList Version
//      System.out.println("ArrayList Version");
//      Stream<Integer> hoursStream;
//      hoursStream = hours.parallelStream();
//      int totalHours = hoursStream
//              .map(h -> {
//                  int amount = h*30;
//                  if (amount > 40) {
//                      hours.add(h + 10);
//                  }
//                  return amount;
//              })
//              .reduce(0, (r, s) -> r + s);
//      System.out.println(totalHours);

      // CopyOnWriteArrayList List Example
      System.out.println("CopyOnWriteArrayList List Example");
      CopyOnWriteArrayList<Integer> concurrentHours
              = new CopyOnWriteArrayList(
                      Arrays.asList(32, 40, 54, 23, 35, 48, 40, 40, 23, 54, 45, 44,
                              45, 65, 34, 35, 42, 42, 50, 45, 35, 45, 35, 31, 12, 56));
      Stream<Integer> hoursStream;
      hoursStream = concurrentHours.parallelStream();
      int totalHours = hoursStream
              .map(h -> {
                  int amount = h * 30;
                  if (amount > 40) {
                      concurrentHours.add(h + 10);
                  }
                  return amount;
              })
              .reduce(0, (r, s) -> r + s);
      System.out.println(totalHours);

      // Stateful operation
      System.out.println("Stateful Operation Example");
//      rate = 30;
      for (int i = 0; i < 2; i++) {
          rate = 30;
          int total = hours
                  .parallelStream()
                  .map(h -> getPay(h))
                  .reduce(0, (r, s) -> r + s);
          System.out.println(total);
      }

      // Side effects
      System.out.println("Side Effect Example");
      List<Integer> overtimeList = new ArrayList<>();
//      hours
//              .parallelStream()
//              .filter(s -> s > 40)
//              .forEach(s -> overtimeList.add(s));

      overtimeList = hours
              .parallelStream()
              .filter(s -> s > 40)
              .collect(Collectors.toList());
      // ArrayList is not thread safe
      for (Integer hour : overtimeList) {
          System.out.print(hour + " ");
      }
      System.out.println();

      // Ordering
      System.out.println("Unsorted Example");
      hours
              .parallelStream()
              .filter(s -> s > 40)
              .sorted()
              .forEach(h -> System.out.print(h + " "));
      System.out.println();

      System.out.println("Sorted Example");
      hours
              .parallelStream()
              .filter(s -> s > 40)
              .sorted()
              .forEachOrdered(s -> System.out.print(s + " "));
      System.out.println();
  }

  static int rate = 30;

  private static int getPay(int hours) {
      if (hours > 40) {
          rate = 25;
          try {
              Thread.sleep(500);
          } catch (InterruptedException ex) {
              ex.printStackTrace();
          }
      } else {
          rate = 30;
      }
      return rate * hours;
  }
}

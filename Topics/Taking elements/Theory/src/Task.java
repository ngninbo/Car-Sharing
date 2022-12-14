// You can experiment here, it won’t be checked

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task {
  public static void main(String[] args) {
    // put your code here
    var val = Stream.of(1, 2, 3);
    var val2 = IntStream.of(1, 2, 3);
    var val3 = Stream.of(1, 2, 3).mapToLong(n -> n);

    List<Integer> fibonacci = List.of(0, 1, 1, 2, 3, 5, 8, 13);

    List<Integer> result = fibonacci.stream()
            .dropWhile(n -> n > 5)
            .collect(Collectors.toList());

    System.out.println(result);

    Stream.iterate(1, i -> i + 2)
            .skip(5)
            .limit(5)
            .forEach(n -> System.out.print(n + " "));

    List<River> rivers = List.of(
          new River("Nile", 6650),
          new River("Amazon", 6400),
          new River("Yangtze", 6300),
          new River("Mississippi", 6275),
          new River("Yenisei", 5539),
          new River("Huang He", 5464)
  );

    long count = rivers.stream().dropWhile(r -> r.getLength() < 6000).count();

    System.out.println("\nRivers count: " + count);

  }
}


class River {
  private final String name;
  private final long length;

  // a constructor and getters
  River(String name, long length) {
    this.name = name;
    this.length = length;
  }

  public String getName() {
    return name;
  }

  public long getLength() {
    return length;
  }
}
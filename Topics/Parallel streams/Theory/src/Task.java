// You can experiment here, it won’t be checked

import java.util.stream.Stream;

public class Task {
  public static void main(String[] args) {
    // put your code here
    System.out.println(Stream.of(1, 2, 3, 4, 5).reduce(1, Integer::sum));
    System.out.println(Stream.of(1, 2, 3, 4, 5).parallel().reduce(0, Integer::sum) + 1);
    System.out.println(Stream.of(1, 2, 3, 4, 5).parallel().reduce(1, Integer::sum));
    System.out.println(Stream.of(1, 2, 4, 5).parallel().reduce(1, Integer::sum));

  }
}

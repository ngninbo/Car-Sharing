// You can experiment here, it won’t be checked

import java.util.stream.IntStream;

public class Task {
  public static void main(String[] args) {
    // put your code here
    IntStream.iterate(10, (n) -> n + 1).limit(3).forEach(System.out::println);
  }
}

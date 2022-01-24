// You can experiment here, it won’t be checked

import java.util.stream.IntStream;

public class Task {
  public static void main(String[] args) {
    // put your code here
    IntStream.empty().summaryStatistics()
            .toString()
            .lines()
            .forEach(System.out::println);
  }
}

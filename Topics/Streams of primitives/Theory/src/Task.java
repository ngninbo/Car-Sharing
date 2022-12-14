// You can experiment here, it won’t be checked

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Task {
  public static void main(String[] args) {
    // put your code here
    IntStream.empty().summaryStatistics()
            .toString()
            .lines()
            .forEach(System.out::println);

    IntSummaryStatistics stat = IntStream.of().summaryStatistics();

    System.out.printf("Count: %d, Min: %d, Max: %d, Avg: %.1f%n",
            stat.getCount(), stat.getMin(), stat.getMax(), stat.getAverage());
  }
}

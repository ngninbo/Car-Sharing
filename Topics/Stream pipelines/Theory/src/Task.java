// You can experiment here, it won’t be checked

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Task {
  public static void main(String[] args) {
    // put your code here
    List<Integer> numbers = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
    int result = numbers.stream()
            .filter(n -> n % 2 == 0)
            .mapToInt(x -> x)
            .sum();

    System.out.println(result);
    /*
    Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
    Supplier<Stream<Integer>> saved = saveStream(stream.filter(e -> e % 2 == 0));

    System.out.println(saved.get().count());
    System.out.println(saved.get().max(Integer::compareTo).orElse(0));
    System.out.println(saved.get().min(Integer::compareTo).orElse(0));*/
  }
}

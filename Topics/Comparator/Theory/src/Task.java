// You can experiment here, it won’t be checked

import java.util.Arrays;
import java.util.List;

public class Task {
  public static void main(String[] args) {
    // put your code here
    List<Integer> numbers = Arrays.asList(12, 2, 13, 4, 15, 6);

    numbers.sort((i1, i2) -> !i1.equals(i2) ? 0 : i2 - i1);

    System.out.println(numbers);
  }
}

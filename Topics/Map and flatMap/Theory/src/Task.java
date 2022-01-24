// You can experiment here, it won’t be checked

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {
  public static void main(String[] args) {
    // put your code here
    List<String> countries = Arrays.asList("Costa Rica", "Hungary", "Saint Kitts and Nevis", "Norway");
    List<Integer> numbers = countries.stream()
            .map(country -> country.split("\\s+"))
            .map(country -> country.length)
            .collect(Collectors.toList());

    numbers.forEach(System.out::print);
  }
}

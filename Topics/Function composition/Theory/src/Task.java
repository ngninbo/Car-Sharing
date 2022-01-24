// You can experiment here, it won’t be checked

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;

public class Task {
  public static void main(String[] args) {
    // put your code here
    IntUnaryOperator next = x -> x + 1;
    IntUnaryOperator square = x -> x * x;

    IntUnaryOperator combinedOperator = next.compose(square);
    int result = combinedOperator.applyAsInt(5);

    System.out.println(result);

    Predicate<Character> isLetter = Character::isLetter;

    Predicate<Character> isUpperCase = Character::isUpperCase;

    Predicate<Character> predicate = isLetter.and(isUpperCase.negate());

    List<Boolean> results = new ArrayList<>();

    results.add(predicate.test('1')); // false
    results.add(predicate.test('3')); // false
    results.add(predicate.test('c')); // true
    results.add(predicate.test('D')); // false
    results.add(predicate.test('e')); // true
    results.add(predicate.test('Q')); // false

    results.forEach(System.out::println);

    IntUnaryOperator mult2 = num -> num * 2;
    IntUnaryOperator add3 = num -> num + 3;

    IntUnaryOperator combinedOperator2 = add3.compose(mult2.andThen(add3)).andThen(mult2);
    int result2 = combinedOperator2.applyAsInt(5);
    System.out.println(result2);

    Consumer<Integer> printer = System.out::println;
    Consumer<Integer> devNull = (val) -> { int v = val * 2; };

    Consumer<Integer> combinedConsumer = devNull.andThen(devNull.andThen(printer));
    combinedConsumer.accept(100);

    // Comparator
    List<Integer> numbers = Arrays.asList(12, 2, 13, 4, 15, 6);

    numbers.sort((i1, i2) -> !i1.equals(i2) ? 0 : i2 - i1);

    System.out.println(numbers);
  }
}

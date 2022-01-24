import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.*;

class EvenAndOddFilter {

    public static final int THREE = 3;
    public static final int FIVE = 5;

    public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
        // write your stream here
        Predicate<Integer> isDivisibleByThreeAndFive = i -> i % THREE == 0 && i % FIVE == 0;
        return IntStream.concat(evenStream, oddStream)
                .sorted()
                .filter(isDivisibleByThreeAndFive::test)
                .skip(2);
    }

    // Don't change the code below
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] values = scanner.nextLine().split(" ");

        List<Integer> numbers = Arrays.stream(values)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(x -> x)
                .toArray();

        int[] oddNumbers = numbers.stream()
                .filter(n -> n % 2 == 1)
                .mapToInt(x -> x)
                .toArray();

        IntStream filteringStream = createFilteringStream(
                Arrays.stream(evenNumbers),
                Arrays.stream(oddNumbers));

        System.out.println(filteringStream.boxed().collect(Collectors.toList()));
    }
}
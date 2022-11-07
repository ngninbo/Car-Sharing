import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = scanner.nextInt();
        List<Integer> result;

        Collections.sort(numbers);

        List<Integer> sameNumbers = numbers.stream().filter(i -> i == n).collect(Collectors.toList());

        if (sameNumbers.isEmpty()) {

            result = numbers.stream()
                    .filter(i -> Math.abs(i - n) == 1)
                    .collect(Collectors.toList());

            if (result.isEmpty()) {
                System.out.println(numbers.get(numbers.size() - 1));
            } else {
                result.stream().sorted().forEach(i -> System.out.print(i + " "));
            }
        } else {
            sameNumbers.forEach(i -> System.out.print(i + " "));
        }

    }
}
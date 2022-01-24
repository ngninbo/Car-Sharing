import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static final String UPPER_BOUND = "#FFFF";
    public static final String LOWER_BOUND = "#0000";

    private static List<String> extractCodes(List<String> codes) {
        // write your code here
        return codes.stream()
                .takeWhile(s -> !UPPER_BOUND.equals(s))
                .dropWhile(s -> !LOWER_BOUND.equals(s))
                .skip(1)
                .collect(Collectors.toList());
    }

    /* Please do not modify the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> codes = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        System.out.println(String.join(" ", extractCodes(codes)));
    }
}
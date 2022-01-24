import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.comparing(Integer::shortValue).reversed())
                .forEach(a -> System.out.print(a + " "));
    }
}
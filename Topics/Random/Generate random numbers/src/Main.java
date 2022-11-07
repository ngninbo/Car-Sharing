import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        Random rand = new Random(a + b);
        int intervalLength = b - a + 1;

        int sum = IntStream.range(0, n)
                .map(i -> rand.nextInt(intervalLength) + a)
                .sum();

        System.out.println(sum);
    }
}
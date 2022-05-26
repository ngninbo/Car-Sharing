import java.util.Arrays;
import java.util.Scanner;

class CollectorProduct {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] values = scanner.nextLine().split(" ");

        long val = Arrays.stream(values)
                .map(Integer::parseInt)
                .reduce(1, (prod, next) -> prod *= next * next);

        System.out.println(val);
    }
}
import java.util.Arrays;

import java.util.Scanner;
import java.util.logging.Level;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long sum = Arrays.stream(scanner.nextLine().toUpperCase().split("\\s+"))
                .map(Level::parse)
                .map(Level::intValue)
                .reduce(0, Integer::sum);

        System.out.println(sum);
    }
}
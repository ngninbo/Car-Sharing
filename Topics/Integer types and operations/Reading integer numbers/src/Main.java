import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(System.out::println);
    }
}
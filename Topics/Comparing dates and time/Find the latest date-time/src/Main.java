import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfDates = Integer.parseInt(scanner.nextLine());
        LocalDateTime latest = IntStream.range(0, numberOfDates)
                .mapToObj(i -> LocalDateTime.parse(scanner.nextLine()))
                .max(LocalDateTime::compareTo).orElseThrow();

        System.out.println(latest);
    }
}
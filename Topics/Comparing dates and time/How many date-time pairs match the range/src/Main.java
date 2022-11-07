import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime startDateTime;
        LocalDateTime endDateTime;

        LocalDateTime lowerDate = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime upperDate = LocalDateTime.parse(scanner.nextLine());

        startDateTime = lowerDate.compareTo(upperDate) < 0 ? lowerDate : upperDate;
        endDateTime = upperDate.compareTo(lowerDate) > 0 ? upperDate : lowerDate;

        int numDateTime = Integer.parseInt(scanner.nextLine());
        long numDateTimeInRange = IntStream.range(0, numDateTime)
                .mapToObj(i -> LocalDateTime.parse(scanner.nextLine()))
                .filter(dateTime -> dateTime.compareTo(startDateTime) >= 0 && dateTime.isBefore(endDateTime))
                .count();

        System.out.println(numDateTimeInRange);
    }
}
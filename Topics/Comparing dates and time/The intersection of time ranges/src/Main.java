import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime firstRangeLower = LocalTime.parse(scanner.next());
        LocalTime firstRangeUpper = LocalTime.parse(scanner.next());
        LocalTime secondRangeLower = LocalTime.parse(scanner.next());
        LocalTime secondRangeUpper = LocalTime.parse(scanner.next());

        System.out.println(intersectionTimeRange(firstRangeLower, firstRangeUpper, secondRangeLower, secondRangeUpper));
    }

    private static boolean intersectionTimeRange(LocalTime firstRangeLower,
                                                 LocalTime firstRangeUpper,
                                                 LocalTime secondRangeLower,
                                                 LocalTime secondRangeUpper) {
        if (secondRangeLower.isBefore(firstRangeLower) && secondRangeUpper.isBefore(firstRangeLower)) {
            return false;
        } else if (secondRangeLower.isAfter(firstRangeUpper) && secondRangeUpper.isAfter(firstRangeUpper)) {
            return false;
        } else {
            return secondRangeLower.isBefore(firstRangeUpper) || secondRangeUpper.isAfter(firstRangeUpper);
        }
    }
}
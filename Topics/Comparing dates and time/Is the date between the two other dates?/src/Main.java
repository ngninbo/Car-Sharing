import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate target = LocalDate.parse(scanner.next());
        LocalDate lower = LocalDate.parse(scanner.next());
        LocalDate upper = LocalDate.parse(scanner.next());
        System.out.println(isBetween(target, lower, upper));
    }

    public static boolean isBetween(LocalDate target, LocalDate lower, LocalDate upper) {
        return lower.isAfter(upper) ?
                target.isBefore(lower) && target.isAfter(upper) :
                target.isAfter(lower) && target.isBefore(upper);
    }
}
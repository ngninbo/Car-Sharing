import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.parse(scanner.next());
        int numberOfDays = scanner.nextInt();
        LocalDate nextYear = LocalDate.of(date.getYear() + 1, 1, 1);
        System.out.println(nextYear.equals(date.plusDays(numberOfDays)));
    }
}
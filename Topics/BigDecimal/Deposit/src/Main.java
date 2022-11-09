import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal startingAmount = new BigDecimal(scanner.nextLine());
        final int n = 2;
        int yearlyPercent = scanner.nextInt();

        BigDecimal interest = BigDecimal.ONE
                .add(new BigDecimal(yearlyPercent).divide(BigDecimal.TEN.pow(n), 2, RoundingMode.CEILING));

        int years = scanner.nextInt();

        BigDecimal finalAmount = startingAmount.multiply(interest.pow(years)).setScale(n, RoundingMode.CEILING);

        System.out.printf("Amount of money in the account: %s", finalAmount);
    }
}
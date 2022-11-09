import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int maxSize = 3;

        BigDecimal totalGold = scanner.tokens()
                .map(BigDecimal::new)
                .limit(maxSize)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(totalGold);
    }
}
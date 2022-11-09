import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int maxSize = 3;
        BigDecimal sum = scanner.tokens()
                .map(BigDecimal::new)
                .limit(maxSize)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal avg = sum.divide(new BigDecimal(maxSize), 0, RoundingMode.DOWN);
        System.out.println(avg);
    }
}
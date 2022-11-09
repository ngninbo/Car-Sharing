import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        BigDecimal number = scanner.nextBigDecimal();
        int newScale = scanner.nextInt();
        System.out.println(number.setScale(newScale, RoundingMode.HALF_DOWN));
    }   
}
import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal a = new BigDecimal(scanner.nextLine());
        BigDecimal b = new BigDecimal(scanner.nextLine());
        System.out.println(a.multiply(b));
    }
}
import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger m = new BigInteger(scanner.next());
        BigInteger n = BigInteger.ONE;

        while (factorial(n).compareTo(m) < 0) {
            n = n.add(BigInteger.ONE);
        }

        System.out.println(n.longValue());
    }

    private static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ONE) || n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }

        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}
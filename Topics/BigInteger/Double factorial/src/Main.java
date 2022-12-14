import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> (n % 2 == 0) == (i % 2 == 0))
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(calcDoubleFactorial(n));
    }
}
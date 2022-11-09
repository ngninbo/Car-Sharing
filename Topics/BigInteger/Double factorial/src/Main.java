import java.math.BigInteger;
import java.util.stream.IntStream;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        return IntStream.rangeClosed(1, n).boxed()
                .filter(i -> (n % 2 == 0) == (i % 2 == 0))
                .map(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }
}
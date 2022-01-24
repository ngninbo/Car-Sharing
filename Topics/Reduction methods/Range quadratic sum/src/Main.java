import java.util.stream.*;

class QuadraticSum {
    public static long rangeQuadraticSum(int fromIncl, int toExcl) {

        return LongStream.range(fromIncl, toExcl)
                .reduce(0, (square, value) -> square += value * value); // write your code with streams here
    }
}
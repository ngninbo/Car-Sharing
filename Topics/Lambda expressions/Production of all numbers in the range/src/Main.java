import java.util.function.*;
import java.util.stream.LongStream;


class Operator {

    public static LongBinaryOperator binaryOperator = (a, b) -> LongStream
            .rangeClosed(a, b)
            .reduce(1, (a1, b1) -> a1 * b1);
}
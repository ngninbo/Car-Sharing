import java.util.function.LongUnaryOperator;

class Operator {

    public static LongUnaryOperator unaryOperator = x -> {
        long nextEven = x + 1;
        if (nextEven % 2 != 0) {
            nextEven++;
        }

        return nextEven;
    };
}
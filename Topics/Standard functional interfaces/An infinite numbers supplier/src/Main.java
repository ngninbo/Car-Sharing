import java.util.function.*;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        return new Supplier<>() {
            int value = 0;

            @Override
            public Integer get() {
                return value++;
            }
        };
    }
}
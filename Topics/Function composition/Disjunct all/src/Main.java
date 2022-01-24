import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

class CombiningPredicates {

    /**
     * The method represents a disjunct operator for a list of predicates.
     * For an empty list it returns the always false predicate.
     */
    public static IntPredicate disjunctAll(List<IntPredicate> predicates) {

        int t = 0;

        AtomicBoolean isTrue = new AtomicBoolean(false);
        if (predicates.isEmpty()) {
            return n -> false;
        }

        predicates.forEach(intPredicate -> {
            if (intPredicate.test(t)) {
                isTrue.set(true);
            }
        });

        return isTrue.get() ? n -> true : n -> false;
    }

    // Don't change the code below
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split(" ");

        List<Boolean> values = Arrays.stream(strings)
                .map(Boolean::parseBoolean)
                .collect(Collectors.toList());

        List<IntPredicate> predicates = new ArrayList<>();
        values.forEach(v -> predicates.add(x -> v));

        System.out.println(disjunctAll(predicates).test(0));
    }
}
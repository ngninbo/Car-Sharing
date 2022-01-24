import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Utils {

    public static List<Integer> sortOddEven(List<Integer> numbers) {
        Predicate<Integer> isOdd = s -> s % 2 != 0;
        numbers.sort(Integer::compare);
        List<Integer> oddList = numbers.stream()
                .filter(isOdd)
                .collect(Collectors.toList());

        List<Integer> evenList = numbers.stream()
                .filter(isOdd.negate())
                .sorted((s1, s2) -> Integer.compare(s2, s1))
                .collect(Collectors.toList());

        oddList.addAll(evenList);
        return oddList;
    }
}
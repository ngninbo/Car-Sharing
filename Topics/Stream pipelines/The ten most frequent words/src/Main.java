import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static final int LIMIT = 10;

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("[\\W]+"))
                .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(LIMIT)
                .forEach(el -> System.out.println(el.getKey()));
    }
}
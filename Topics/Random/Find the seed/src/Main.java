import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Map<Integer, Long> map = new ConcurrentHashMap<>();

        IntStream.rangeClosed(a, b).forEach(s -> {
            Random rand = new Random(s);
            long max = IntStream.range(0, n)
                    .mapToLong(i -> rand.nextInt(k))
                    .max()
                    .orElse(0);

            map.put(s, max);
        });

        map.entrySet().stream()
                .max((el1, el2) -> el2.getValue().compareTo(el1.getValue()))
                .ifPresent(el -> {
                    System.out.println(el.getKey());
                    System.out.println(el.getValue());
                });
    }
}
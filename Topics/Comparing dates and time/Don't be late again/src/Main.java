import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LocalTime> stores = new LinkedHashMap<>();
        int numStores = Integer.parseInt(scanner.nextLine());
        LocalTime endTravel = LocalTime.parse("20:00"); // 19:30 + 00:30

        for (int i = 0; i < numStores; i++) {
            stores.put(scanner.next(), LocalTime.parse(scanner.next()));
        }

        stores.forEach((store, closingTime) -> {
            if (endTravel.compareTo(closingTime) < 0) {
                System.out.println(store);
            }
        });
    }
}
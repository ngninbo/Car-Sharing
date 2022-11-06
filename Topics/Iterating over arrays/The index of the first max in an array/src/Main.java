import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfElements = Integer.parseInt(scanner.nextLine());
        int[] arr;
        int max = 0;
        int idx = 0;

        arr = IntStream.range(0, numberOfElements).map(i -> Integer.parseInt(scanner.next())).toArray();

        for (int i = 0; i < numberOfElements; i++) {
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }

        System.out.println(idx);
    }
}
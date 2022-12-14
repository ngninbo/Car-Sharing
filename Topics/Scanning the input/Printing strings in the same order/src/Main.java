import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    private static final int NUMBER_OF_WORDS = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntStream.range(0, NUMBER_OF_WORDS)
                .mapToObj(value -> scanner.next())
                .forEach(System.out::println);
    }
}
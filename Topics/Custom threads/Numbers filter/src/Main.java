import java.util.Scanner;

class NumbersFilter extends Thread {

    /* use it to read numbers from the standard input */
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        scanner.tokens().mapToInt(Integer::parseInt)
                .takeWhile(value -> value != 0)
                .filter(value -> value % 2 == 0)
                .forEach(System.out::println);

    }
}
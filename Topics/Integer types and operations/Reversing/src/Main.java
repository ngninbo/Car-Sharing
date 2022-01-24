import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int number = scanner.nextInt();

        int reverse = 0;
        int base = 10;

        while (number != 0) {

            int remainder = number % base;
            reverse  = reverse * base + remainder;

            number  /= base;
        }

        System.out.println(reverse);
    }
}
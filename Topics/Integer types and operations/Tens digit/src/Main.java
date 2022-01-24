import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int digit = scanner.nextInt();
        int base = 10;
        int tensDigit = (digit / base) % base;

        System.out.println(tensDigit);
    }
}
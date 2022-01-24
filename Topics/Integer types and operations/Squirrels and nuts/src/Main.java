import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int nuts = scanner.nextInt();
        int squirrels = scanner.nextInt();

        System.out.println(squirrels % nuts);
    }
}
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // write your code here
        int number = scanner.nextInt();

        switch (number) {
            case 1 -> System.out.println("January");
            case 2 -> System.out.println("February");
            case 3 -> System.out.println("March");
            case 4 -> System.out.println("April");
            case 5 -> System.out.println("May");
            case 6 -> System.out.println("June");
            default -> System.out.println("error!");
        }
    }
}
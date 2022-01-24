import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int value = scanner.nextInt();
        int result = ((value + 1) * value +  2) * value + 3;
        System.out.println(result);
    }
}
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int sum = 0;
        int value = scanner.nextInt();
        if (value >= 100 && value <= 999) {
            char[] digits = String.valueOf(value).toCharArray();
            for (char ch : digits) {
                sum += Integer.parseInt(String.valueOf(ch));
            }
            System.out.println(sum);
        }
    }
}
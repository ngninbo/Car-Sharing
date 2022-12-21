
class SimpleCalculator {

    // Implement your methods here
    public static void subtractTwoNumbers(long a, long b) {
        System.out.println(a - b);
    }


    public static void sumTwoNumbers(long a, long b) {
        System.out.println(a + b);
    }


    public static void divideTwoNumbers(long a, long b) {
        System.out.println(b != 0 ? a / b : "Division by 0!");
    }


    public static void multiplyTwoNumbers(long a, long b) {
        System.out.println(a * b);
    }

    // Implemented method
    public static void power(long n, long p) {
        System.out.println(pow(n, p));
    }

    public static long pow(long n, long p) {
        if (p == 0) {
            return 1;
        } else {
            return n * pow(n, p - 1);
        }
    }
}

public class Main {

    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        long num1 = scanner.nextLong();
        String operator = scanner.next();
        long num2 = scanner.nextLong();

        switch (operator) {
            case "^":
                SimpleCalculator.power(num1, num2);
                break;
            case "+":
                SimpleCalculator.sumTwoNumbers(num1, num2);
                break;
            case "-":
                SimpleCalculator.subtractTwoNumbers(num1, num2);
                break;
            case "/":
                SimpleCalculator.divideTwoNumbers(num1, num2);
                break;
            case "*":
                SimpleCalculator.multiplyTwoNumbers(num1, num2);
                break;
            default:
                break;
        }

        int n = scanner.nextInt();
        int p = scanner.nextInt();

        System.out.println(SimpleCalculator.pow(n, p));
    }
}
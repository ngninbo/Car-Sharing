import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int intVal = scanner.nextInt();
        intVal++;

        while (intVal % 2 != 0) {
            intVal++;
        }

        System.out.println(intVal);
    }
}
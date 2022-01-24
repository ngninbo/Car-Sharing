import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int duration = scanner.nextInt();
        int totalFoodCost = scanner.nextInt() * duration;
        int oneWayFlightCost = scanner.nextInt();
        int costOfOneNight = scanner.nextInt() * (duration - 1);

        int vacationCost = totalFoodCost + oneWayFlightCost * 2 + costOfOneNight;
        System.out.println(vacationCost);
    }
}
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // put your code here
        int participantFirstGroup = scanner.nextInt();
        int participantSecondGroup = scanner.nextInt();
        int participantThirdGroup = scanner.nextInt();

        // int sumParticipants = participantFirstGroup + participantSecondGroup + participantThirdGroup;

        int numOfDesksFirstGroup = participantFirstGroup / 2 + participantFirstGroup % 2;
        int numberOfDeskSecondGroup = participantSecondGroup / 2 + participantSecondGroup % 2;
        int numOfDesksThirdGroup = participantThirdGroup / 2 + participantThirdGroup % 2;
        int numOfDesks = numOfDesksFirstGroup + numberOfDeskSecondGroup + numOfDesksThirdGroup;

        System.out.println(numOfDesks);
    }
}
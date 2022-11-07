// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) {
    // put your code here
    int howHungryAmI = 0; // 1 is stuffed, 10 is starving

    int numberOfHamburgersToEat = switch (howHungryAmI) {
      case 1, 2, 3 -> 0;
      case 4, 5, 6 -> 1;
      case 7, 8, 9 -> 2;
      case 10 -> 3;
    };
  }
}

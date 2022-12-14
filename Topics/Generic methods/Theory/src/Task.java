// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) {
    MagicNumber[] numbers = new MagicNumber[8];

    for (int i = 0; i < numbers.length; i++) {
      MagicNumber magicNumber = new MagicNumber(i);
      System.out.print(magicNumber);
    }
  }
}

class MagicNumber {

  private final static int[] NUMBERS;
  private static int next = 0;

  private int number;

  static {
    NUMBERS = new int[] { 1, 3, 7, 15, 31, 63 };
    next++;
    method();
  }

  {
    this.number = NUMBERS[next % NUMBERS.length];
    next++;
  }

  public MagicNumber(int base) {
    this.number += base;
    next++;
    method();
  }

  @Override
  public String toString() {
    return number + " ";
  }

  public static void method() {

  }

}

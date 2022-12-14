// You can experiment here, it won’t be checked

import java.util.function.IntUnaryOperator;

public class Task {
  public static void main(String[] args) {
    // put your code here
    IntUnaryOperator mult2 = num -> num * 2;
    IntUnaryOperator add3 = num -> num + 3;

    IntUnaryOperator combinedOperator = add3.compose(mult2.andThen(add3)).andThen(mult2);
    int result = combinedOperator.applyAsInt(5);
    System.out.println(result);
  }
}

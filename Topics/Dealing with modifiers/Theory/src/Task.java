// You can experiment here, it won’t be checked

import java.io.PrintStream;

public class Task {
  public static void main(String[] args) throws Exception {
    // put your code here
    Task.class.getMethod("hello").invoke(null);
  }

  public static void hello() {
    System.out.println("Hello world!");
  }
}

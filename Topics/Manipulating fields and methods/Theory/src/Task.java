// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) throws Exception {
    Task.class.getMethod("hello").invoke(null);
  }

  static void hello() {
    System.out.println("Hello world!");
  }
}

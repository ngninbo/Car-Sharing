// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) {
    // put your code here
  }
}

class Cat {

  private String name;
  private String color;
  private int size;

  public Cat(String name, String color, int size) {
    this.name = name;
    this.color = color;
    this.size = size;
  }

  public class Bow {
    String color;
    int size;

    public Bow(String color, int size) {
      this.color = color;
      this.size = size;
    }

    public void printColor() {
      System.out.print("Cat " + name + " is " + color + ". ");
      System.out.print("The size of " + name + " is " + size + ". ");
      System.out.print("Cat " + name + " has " + this.color + " bow. ");
      System.out.print("The size of bow is " + this.size + ".");
    }
  }

  public static void main(String[] args) {

    Cat cat = new Cat("Bob", "white", 10);
    Cat.Bow bow = cat.new Bow("red", 15);

    bow.printColor();
  }
}

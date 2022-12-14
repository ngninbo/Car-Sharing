// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) {
    // put your code here
  }
}

class Action {
  public void doAction() {
    System.out.println("Doing an action");
  }
}


class Human {

  public void doYoga() {
    Action action = new Action() {
      public void doAction() {
        System.out.println("Doing yoga.");
      }
    };
    action.doAction();
  }
}
